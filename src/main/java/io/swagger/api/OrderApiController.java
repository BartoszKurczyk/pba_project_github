package io.swagger.api;

import io.swagger.AdditionalFeatures;
import io.swagger.database.model.OrderDB;
import io.swagger.database.model.OrderRawDB;
import io.swagger.database.model.ProductDB;
import io.swagger.database.model.UserDB;
import io.swagger.database.repository.OrderRawRepository;
import io.swagger.database.repository.OrderRepository;
import io.swagger.database.repository.ProductsRepository;
import io.swagger.database.repository.UsersRepository;
import io.swagger.exceptions.*;
import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")

@Controller
public class OrderApiController implements OrderApi {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private AdditionalFeatures additionalFeatures = new AdditionalFeatures();

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderRawRepository orderRawRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<OrderResponse> makeOrder(String body,String token, String hmacSignature) throws Exception{
        additionalFeatures.BasicAuth(token);
        additionalFeatures.hmacCheck(body,hmacSignature);
        MakeOrderRequest order = objectMapper.readValue(body,MakeOrderRequest.class);
        ValidOrder(order.getOrderDetails());
        OrderDB orderDB = OrderDB.builder().id(order.getOrderDetails().getId()).userId(order.getOrderDetails().getUserId()).build();
        orderRepository.save(orderDB);
        for (ProductInOrder product:order.getOrderDetails().getListOfProductsIds()) {
            OrderRawDB orderRawDB = OrderRawDB.builder().id(UUID.randomUUID()).orderId(orderDB.getId())
                    .productId(product.getProductId()).quantity(product.getQuantity()).build();
            orderRawRepository.save(orderRawDB);
            ProductDB productDB = productsRepository.findById(product.getProductId()).orElse(null);
            productDB.setQuantity(productDB.getQuantity()-product.getQuantity());
            productsRepository.save(productDB);
        }
        return ResponseEntity.ok().body(OrderResponse.builder().responseHeader(ResponseHeader.builder()
                .responseId(order.getRequestHeader().getRequestId()).sendDate(new Date()).build()).
                orderDetails(order.getOrderDetails()).build());
    }

    @Override
    public ResponseEntity<OrderDetailsResponse> getOrderDetails(UUID id,String token) {
        float totalPrice = (float) (0.0);
        OrderDB orderDB = orderRepository.findById(id).orElse(null);
        List<OrderRawDB> orderRawDBList = orderRawRepository.findAll().stream().filter(x-> x.getOrderId().equals(id)).collect(Collectors.toList());
        List<ProductInOrderDetails> productInOrderDetailsList = new ArrayList<ProductInOrderDetails>();
        for (OrderRawDB orderRawDB:orderRawDBList) {
            ProductDB productDB = productsRepository.findById(orderRawDB.getProductId()).orElse(null);
            ShortenProduct shortenProduct = ShortenProduct.builder().id(productDB.getId()).name(productDB.getName()).producer(productDB.getProducer()).
                    price(productDB.getPrice()).build();
            ProductInOrderDetails productInOrderDetails = ProductInOrderDetails.builder().product(shortenProduct).quantity(orderRawDB.getQuantity()).build();
            productInOrderDetailsList.add(productInOrderDetails);
            totalPrice += (productDB.getPrice() * orderRawDB.getQuantity());
        }
        UserDB userDB = usersRepository.findById(orderDB.getUserId()).orElse(null);
        User user = User.builder().id(userDB.getId()).name(userDB.getName()).surname(userDB.getSurname()).adressStreet(userDB.getAdressStreet()).
                buildingNumber(userDB.getBuildingNumber()).apartmentNumber(userDB.getApartmentNumber()).zipCode(userDB.getZipCode()).
                city(userDB.getCity()).email(userDB.getEmail()).build();
        OrderDetails orderDetails = OrderDetails.builder().id(orderDB.getId()).user(user).listOfProducts(productInOrderDetailsList).totalPrice(totalPrice).build();

        return ResponseEntity.ok().body(OrderDetailsResponse.builder().responseHeader(ResponseHeader.builder().responseId(UUID.randomUUID()).sendDate(new Date()).build()).orderDetails(orderDetails).build());
    }

    @Override
    public ResponseEntity<OrdersListResponse> getOrders(String token) {
        additionalFeatures.BasicAuth(token);
        List<Order> orderList = new ArrayList<Order>();
        List<OrderDB> orderDBList = orderRepository.findAll();
        for (OrderDB orderDB:orderDBList) {
            //List<ProductInOrder> productInOrders = new ArrayList<ProductInOrder>();
            List<OrderRawDB> orderRawDBList = orderRawRepository.findAll().stream().filter(x-> x.getOrderId().equals(orderDB.getId())).
                    collect(Collectors.toList());
            List<ProductInOrder> productInOrders = orderRawDBList.stream().map(x-> ProductInOrder.builder().productId(x.getProductId()).
                    quantity(x.getQuantity()).build()).collect(Collectors.toList());
            Order order = Order.builder().id(orderDB.getId()).userId(orderDB.getUserId()).listOfProductsIds(productInOrders).build();
            orderList.add(order);
        }
        return ResponseEntity.ok().body(OrdersListResponse.builder().responseHeader(ResponseHeader.builder().responseId(UUID.randomUUID()).sendDate(new Date()).build()).ordersList(orderList).build());
    }


    private void ValidOrder(Order order){

        OrderDB orderDB = orderRepository.findById(order.getId()).orElse(null);

        if (orderDB!=null) throw new OrderAlreadyExistsException("Order already exists in database");

        UserDB foundUser = usersRepository.findById(order.getUserId()).orElse(null);
        if (foundUser==null){
            throw new UserNotFoundException("User not found");
        }

        for (ProductInOrder product:order.getListOfProductsIds()) {
            ProductDB productDB = productsRepository.findById(product.getProductId()).orElse(null);

            if(productDB==null){
                throw new ProductNotFoundException("Product not found");
            }
            if(product.getQuantity()>productDB.getQuantity()){
                throw new NotEnoughProductException("Not enough products to make order");
            }
        }


    }
}
