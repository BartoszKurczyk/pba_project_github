package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ProductInOrderDetails;
import io.swagger.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderDetails
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T17:03:13.811Z")


public class OrderDetails   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("user")
  private User user = null;

  @JsonProperty("listOfProducts")
  @Valid
  private List<ProductInOrderDetails> listOfProducts = null;

  @JsonProperty("totalPrice")
  private Float totalPrice = null;

  public OrderDetails id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public OrderDetails user(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")

  @Valid

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public OrderDetails listOfProducts(List<ProductInOrderDetails> listOfProducts) {
    this.listOfProducts = listOfProducts;
    return this;
  }

  public OrderDetails addListOfProductsItem(ProductInOrderDetails listOfProductsItem) {
    if (this.listOfProducts == null) {
      this.listOfProducts = new ArrayList<ProductInOrderDetails>();
    }
    this.listOfProducts.add(listOfProductsItem);
    return this;
  }

  /**
   * Get listOfProducts
   * @return listOfProducts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductInOrderDetails> getListOfProducts() {
    return listOfProducts;
  }

  public void setListOfProducts(List<ProductInOrderDetails> listOfProducts) {
    this.listOfProducts = listOfProducts;
  }

  public OrderDetails totalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * Get totalPrice
   * minimum: 0.01
   * @return totalPrice
  **/
  @ApiModelProperty(example = "1.1", value = "")

@DecimalMin("0.01")
  public Float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetails orderDetails = (OrderDetails) o;
    return Objects.equals(this.id, orderDetails.id) &&
        Objects.equals(this.user, orderDetails.user) &&
        Objects.equals(this.listOfProducts, orderDetails.listOfProducts) &&
        Objects.equals(this.totalPrice, orderDetails.totalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user, listOfProducts, totalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    listOfProducts: ").append(toIndentedString(listOfProducts)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
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

