package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ProductInOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-12T13:06:49.137Z")


public class Order   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("userId")
  private UUID userId = null;

  @JsonProperty("listOfProductsIds")
  @Valid
  private List<ProductInOrder> listOfProductsIds = null;

  public Order id(UUID id) {
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

  public Order userId(UUID userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Order listOfProductsIds(List<ProductInOrder> listOfProductsIds) {
    this.listOfProductsIds = listOfProductsIds;
    return this;
  }

  public Order addListOfProductsIdsItem(ProductInOrder listOfProductsIdsItem) {
    if (this.listOfProductsIds == null) {
      this.listOfProductsIds = new ArrayList<ProductInOrder>();
    }
    this.listOfProductsIds.add(listOfProductsIdsItem);
    return this;
  }

  /**
   * Get listOfProductsIds
   * @return listOfProductsIds
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductInOrder> getListOfProductsIds() {
    return listOfProductsIds;
  }

  public void setListOfProductsIds(List<ProductInOrder> listOfProductsIds) {
    this.listOfProductsIds = listOfProductsIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.userId, order.userId) &&
        Objects.equals(this.listOfProductsIds, order.listOfProductsIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, listOfProductsIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    listOfProductsIds: ").append(toIndentedString(listOfProductsIds)).append("\n");
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

