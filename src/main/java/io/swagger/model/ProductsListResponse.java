package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Product;
import io.swagger.model.ResponseHeader;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductsListResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")
@Builder

public class ProductsListResponse   {
  @JsonProperty("responseHeader")
  private ResponseHeader responseHeader = null;

  @JsonProperty("productsList")
  @Valid
  private List<Product> productsList = new ArrayList<Product>();

  public ProductsListResponse responseHeader(ResponseHeader responseHeader) {
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

  public ProductsListResponse productsList(List<Product> productsList) {
    this.productsList = productsList;
    return this;
  }

  public ProductsListResponse addProductsListItem(Product productsListItem) {
    this.productsList.add(productsListItem);
    return this;
  }

  /**
   * Get productsList
   * @return productsList
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<Product> getProductsList() {
    return productsList;
  }

  public void setProductsList(List<Product> productsList) {
    this.productsList = productsList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductsListResponse productsListResponse = (ProductsListResponse) o;
    return Objects.equals(this.responseHeader, productsListResponse.responseHeader) &&
        Objects.equals(this.productsList, productsListResponse.productsList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeader, productsList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsListResponse {\n");
    
    sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
    sb.append("    productsList: ").append(toIndentedString(productsList)).append("\n");
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

