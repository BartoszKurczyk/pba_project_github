package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ShortenProduct;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductInOrderDetails
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T16:51:39.989Z")


public class ProductInOrderDetails   {
  @JsonProperty("product")
  private ShortenProduct product = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  public ProductInOrderDetails product(ShortenProduct product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ShortenProduct getProduct() {
    return product;
  }

  public void setProduct(ShortenProduct product) {
    this.product = product;
  }

  public ProductInOrderDetails quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * minimum: 0
   * @return quantity
  **/
  @ApiModelProperty(example = "2", value = "")

@Min(0)
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInOrderDetails productInOrderDetails = (ProductInOrderDetails) o;
    return Objects.equals(this.product, productInOrderDetails.product) &&
        Objects.equals(this.quantity, productInOrderDetails.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInOrderDetails {\n");
    
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

