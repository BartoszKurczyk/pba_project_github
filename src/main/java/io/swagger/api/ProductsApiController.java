package io.swagger.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.AdditionalFeatures;
import io.swagger.database.model.ProductDB;
import io.swagger.database.repository.ProductsRepository;
import io.swagger.exceptions.ProductAlreadyExistsException;
import io.swagger.exceptions.ProductNotFoundException;
import io.swagger.exceptions.UserAlreadyExistsException;
import io.swagger.exceptions.UserNotFoundException;
import io.swagger.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")

@Controller
public class ProductsApiController implements ProductsApi {

    private static final Logger log = LoggerFactory.getLogger(ProductsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private AdditionalFeatures additionalFeatures = new AdditionalFeatures();

    @PostConstruct
    public void init(){
        double price = 1000.99;
        ProductDB product = ProductDB.builder().id(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")).name("MacBook Pro").producer("Apple").
        description("Laptop ma to to i tam to").price((float)price).quantity(11).productType(Product.ProductTypeEnum.LAPTOPS).build();
        productsRepository.save(product);
    }

    @Autowired
    private ProductsRepository productsRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public ResponseEntity<ProductResponse> addProduct(@Valid CreateProductRequest body,String token) throws NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
        additionalFeatures.BasicAuth(token);
        Product product = body.getProduct();
        if(productsRepository.findAll().stream().filter(x-> x.getId().equals(product.getId()) ||
                (x.getProductType().equals(product.getProducer()) && x.getName().equals(product.getName()))).findAny().orElse(null)!=null)
            throw new ProductAlreadyExistsException("Product can't be added. Already exists.");
        ProductDB productDB = ProductDB.builder().id(product.getId()).name(product.getName()).producer(product.getProducer()).description(product.getDescription()).
                price(product.getPrice()).quantity(product.getQuantity()).productType(product.getProductType()).build();
        productsRepository.save(productDB);
        return ResponseEntity.ok().build();
    }
    @Override
    public ResponseEntity<ProductsListResponse> getProducts(String token) {
        additionalFeatures.BasicAuth(token);
        List<Product> products = productsRepository.findAll().stream().map(u -> Product.builder().id(u.getId()).
                name(u.getName()).producer(u.getProducer()).description(u.getDescription()).price(u.getPrice()).
                quantity(u.getQuantity()).productType(u.getProductType()).build()).collect(Collectors.toList());
        return ResponseEntity.ok().body(ProductsListResponse.builder().productsList(products).
                responseHeader(ResponseHeader.builder().responseId(UUID.randomUUID()).sendDate(new Date()).build()).build());
    }

    @Override
    public ResponseEntity<Void> deleteProduct(UUID id,String token) {
        additionalFeatures.BasicAuth(token);
        if(productsRepository.findById(id).orElse(null) == null) throw new ProductNotFoundException("Product not found. Can't be deleted");
        productsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(UUID id, ProductUpdateRequest body, String token) {
        ProductDB foundProduct = productsRepository.findById(id).orElse(null);
        Product product = body.getProduct();
        if(foundProduct==null) throw new ProductNotFoundException("Product not found. Can't be updated");
        foundProduct.setName(product.getName());
        foundProduct.setProducer(product.getProducer());
        foundProduct.setDescription(product.getDescription());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setQuantity(product.getQuantity());
        foundProduct.setProductType(product.getProductType());

        productsRepository.save(foundProduct);
        return null;
    }
}
