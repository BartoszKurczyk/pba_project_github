package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.OrderDetails;
import io.swagger.model.ResponseHeader;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderDetailsResponse
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T17:19:33.177Z")


public class OrderDetailsResponse   {
  @JsonProperty("responseHeader")
  private ResponseHeader responseHeader = null;

  @JsonProperty("orderDetails")
  private OrderDetails orderDetails = null;

  public OrderDetailsResponse responseHeader(ResponseHeader responseHeader) {
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

  public OrderDetailsResponse orderDetails(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
    return this;
  }

  /**
   * Get orderDetails
   * @return orderDetails
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OrderDetails getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(OrderDetails orderDetails) {
    this.orderDetails = orderDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsResponse orderDetailsResponse = (OrderDetailsResponse) o;
    return Objects.equals(this.responseHeader, orderDetailsResponse.responseHeader) &&
        Objects.equals(this.orderDetails, orderDetailsResponse.orderDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeader, orderDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsResponse {\n");
    
    sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
    sb.append("    orderDetails: ").append(toIndentedString(orderDetails)).append("\n");
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

