package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Order;
import io.swagger.model.ResponseHeader;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrdersListResponse
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-20T07:58:25.691Z")


public class OrdersListResponse   {
  @JsonProperty("responseHeader")
  private ResponseHeader responseHeader = null;

  @JsonProperty("ordersList")
  @Valid
  private List<Order> ordersList = new ArrayList<Order>();

  public OrdersListResponse responseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
    return this;
  }

  /**
   * Get responseHeader
   * @return responseHeader
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public ResponseHeader getResponseHeader() {
    return responseHeader;
  }

  public void setResponseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
  }

  public OrdersListResponse ordersList(List<Order> ordersList) {
    this.ordersList = ordersList;
    return this;
  }

  public OrdersListResponse addOrdersListItem(Order ordersListItem) {
    this.ordersList.add(ordersListItem);
    return this;
  }

  /**
   * Get ordersList
   * @return ordersList
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<Order> getOrdersList() {
    return ordersList;
  }

  public void setOrdersList(List<Order> ordersList) {
    this.ordersList = ordersList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrdersListResponse ordersListResponse = (OrdersListResponse) o;
    return Objects.equals(this.responseHeader, ordersListResponse.responseHeader) &&
        Objects.equals(this.ordersList, ordersListResponse.ordersList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeader, ordersList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrdersListResponse {\n");
    
    sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
    sb.append("    ordersList: ").append(toIndentedString(ordersList)).append("\n");
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

