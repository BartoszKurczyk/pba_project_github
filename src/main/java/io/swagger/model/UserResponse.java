package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ResponseHeader;
import io.swagger.model.User;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserResponse
 */
@Builder
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-01-19T11:41:24.115Z")


public class UserResponse   {
  @JsonProperty("responseHeader")
  private ResponseHeader responseHeader = null;

  @JsonProperty("user")
  private User user = null;

  public UserResponse responseHeader(ResponseHeader responseHeader) {
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

  public UserResponse user(User user) {
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
    UserResponse userResponse = (UserResponse) o;
    return Objects.equals(this.responseHeader, userResponse.responseHeader) &&
        Objects.equals(this.user, userResponse.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeader, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResponse {\n");
    
    sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
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

