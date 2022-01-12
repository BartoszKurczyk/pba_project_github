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
import io.swagger.exceptions.NotEnoughProductException;
import io.swagger.exceptions.OrderAlreadyExistsException;
import io.swagger.exceptions.ProductNotFoundException;
import io.swagger.exceptions.UserNotFoundException;
import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")

@Controller
public class OrderApiController implements OrderApi {

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

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
        AdditionalFeatures additionalFeatures = new AdditionalFeatures();
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
