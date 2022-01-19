package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.RequestHeader;
import io.swagger.model.User;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T11:41:24.115Z")


public class CreateRequest   {
  @JsonProperty("requestHeader")
  private RequestHeader requestHeader = null;

  @JsonProperty("user")
  private User user = null;

  public CreateRequest requestHeader(RequestHeader requestHeader) {
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

  public CreateRequest user(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateRequest createRequest = (CreateRequest) o;
    return Objects.equals(this.requestHeader, createRequest.requestHeader) &&
        Objects.equals(this.user, createRequest.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestHeader, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateRequest {\n");
    
    sb.append("    requestHeader: ").append(toIndentedString(requestHeader)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

