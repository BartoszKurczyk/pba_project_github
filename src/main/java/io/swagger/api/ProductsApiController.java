package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.AdditionalFeatures;
import io.swagger.database.model.ProductDB;
import io.swagger.database.repository.ProductsRepository;
import io.swagger.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @PostConstruct
    public void init(){
        double price = 1.1;
        ProductDB product = ProductDB.builder().id(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")).name("Iphone 13").producer("Apple").
        description("Telefon ma to to i tam to").price((float)price).quantity(11).productType(Product.ProductTypeEnum.MOBILE_PHONES).build();
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
    public ResponseEntity<ProductResponse> addProduct(@Valid CreateProductRequest body) {
        return ResponseEntity.ok().build();
    }
    @Override
    public ResponseEntity<ProductsListResponse> getProducts(String token) {
        AdditionalFeatures additionalFeatures = new AdditionalFeatures();
        additionalFeatures.BasicAuth(token);
        List<Product> products = productsRepository.findAll().stream().map(u -> Product.builder().id(u.getId()).
                name(u.getName()).producer(u.getProducer()).description(u.getDescription()).price(u.getPrice()).
                quantity(u.getQuantity()).productType(u.getProductType()).build()).collect(Collectors.toList());
        return ResponseEntity.ok().body(ProductsListResponse.builder().productsList(products).
                responseHeader(ResponseHeader.builder().responseId(UUID.randomUUID()).sendDate(new Date()).build()).build());
    }

}
