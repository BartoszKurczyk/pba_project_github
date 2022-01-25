package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;

import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ShortenProduct
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T16:51:39.989Z")


public class ShortenProduct   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("producer")
  private String producer = null;

  @JsonProperty("price")
  private Float price = null;

  public ShortenProduct id(UUID id) {
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

  public ShortenProduct name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Iphone 13", value = "")

@Size(min=5,max=25) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ShortenProduct producer(String producer) {
    this.producer = producer;
    return this;
  }

  /**
   * Get producer
   * @return producer
  **/
  @ApiModelProperty(example = "Apple", value = "")

@Size(min=5) 
  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public ShortenProduct price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * minimum: 0.01
   * @return price
  **/
  @ApiModelProperty(example = "1.1", value = "")

@DecimalMin("0.01")
  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShortenProduct shortenProduct = (ShortenProduct) o;
    return Objects.equals(this.id, shortenProduct.id) &&
        Objects.equals(this.name, shortenProduct.name) &&
        Objects.equals(this.producer, shortenProduct.producer) &&
        Objects.equals(this.price, shortenProduct.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, producer, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShortenProduct {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    producer: ").append(toIndentedString(producer)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

