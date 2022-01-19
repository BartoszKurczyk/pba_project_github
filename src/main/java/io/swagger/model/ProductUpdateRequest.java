package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Product;
import io.swagger.model.RequestHeader;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductUpdateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T16:11:40.820Z")


public class ProductUpdateRequest   {
  @JsonProperty("requestHeader")
  private RequestHeader requestHeader = null;

  @JsonProperty("product")
  private Product product = null;

  public ProductUpdateRequest requestHeader(RequestHeader requestHeader) {
    this.requestHeader = requestHeader;
    return this;
  }

  /**
   * Get requestHeader
   * @return requestHeader
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public RequestHeader getRequestHeader() {
    return requestHeader;
  }

  public void setRequestHeader(RequestHeader requestHeader) {
    this.requestHeader = requestHeader;
  }

  public ProductUpdateRequest product(Product product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductUpdateRequest productUpdateRequest = (ProductUpdateRequest) o;
    return Objects.equals(this.requestHeader, productUpdateRequest.requestHeader) &&
        Objects.equals(this.product, productUpdateRequest.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestHeader, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductUpdateRequest {\n");
    
    sb.append("    requestHeader: ").append(toIndentedString(requestHeader)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

