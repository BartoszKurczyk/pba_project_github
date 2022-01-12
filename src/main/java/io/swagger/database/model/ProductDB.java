package io.swagger.database.model;

import io.swagger.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDB {
    @Id
    private UUID id;

    private String name;
    private String producer;
    private String description;
    private float price;
    private int quantity;
    private Product.ProductTypeEnum productType;
}
