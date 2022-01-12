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
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")
@Builder

public class User   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("adressStreet")
  private String adressStreet = null;

  @JsonProperty("buildingNumber")
  private Integer buildingNumber = null;

  @JsonProperty("apartmentNumber")
  private Integer apartmentNumber = null;

  @JsonProperty("zipCode")
  private String zipCode = null;

  @JsonProperty("city")
  private String city = null;
  @JsonProperty("email")
  private String email = null;


  public User id(UUID id) {
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

  public User name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Elon", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  **/
  @ApiModelProperty(example = "Musk", required = true, value = "")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public User adressStreet(String adressStreet) {
    this.adressStreet = adressStreet;
    return this;
  }

  /**
   * Get adressStreet
   * @return adressStreet
  **/
  @ApiModelProperty(example = "aleja Piastów", value = "")


  public String getAdressStreet() {
    return adressStreet;
  }

  public void setAdressStreet(String adressStreet) {
    this.adressStreet = adressStreet;
  }

  public User buildingNumber(Integer buildingNumber) {
    this.buildingNumber = buildingNumber;
    return this;
  }

  /**
   * Get buildingNumber
   * minimum: 1
   * @return buildingNumber
  **/
  @ApiModelProperty(example = "26", value = "")

@Min(1)
  public Integer getBuildingNumber() {
    return buildingNumber;
  }

  public void setBuildingNumber(Integer buildingNumber) {
    this.buildingNumber = buildingNumber;
  }

  public User apartmentNumber(Integer apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
    return this;
  }

  /**
   * Get apartmentNumber
   * minimum: 118
   * @return apartmentNumber
  **/
  @ApiModelProperty(value = "")

@Min(118)
  public Integer getApartmentNumber() {
    return apartmentNumber;
  }

  public void setApartmentNumber(Integer apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }

  public User zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  /**
   * Get zipCode
   * @return zipCode
  **/
  @ApiModelProperty(example = "71-064", value = "")

@Pattern(regexp="^[0-9]{2}-[0-9]{3}$") 
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public User city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(example = "Szczecin", value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(example = "e_musk@gmail.com", value = "")

@Pattern(regexp="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") 
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.surname, user.surname) &&
        Objects.equals(this.adressStreet, user.adressStreet) &&
        Objects.equals(this.buildingNumber, user.buildingNumber) &&
        Objects.equals(this.apartmentNumber, user.apartmentNumber) &&
        Objects.equals(this.zipCode, user.zipCode) &&
        Objects.equals(this.city, user.city) &&
        Objects.equals(this.email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, adressStreet, buildingNumber, apartmentNumber, zipCode, city, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    adressStreet: ").append(toIndentedString(adressStreet)).append("\n");
    sb.append("    buildingNumber: ").append(toIndentedString(buildingNumber)).append("\n");
    sb.append("    apartmentNumber: ").append(toIndentedString(apartmentNumber)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

