package io.swagger.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;

import lombok.Builder;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResponseHeader
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-12-16T07:28:43.311Z")
@Builder

public class ResponseHeader   {
  @JsonProperty("responseId")
  private UUID responseId = null;

  @JsonProperty("sendDate")
  private Date sendDate = null;

  public ResponseHeader responseId(UUID responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Get responseId
   * @return responseId
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public UUID getResponseId() {
    return responseId;
  }

  public void setResponseId(UUID responseId) {
    this.responseId = responseId;
  }

  public ResponseHeader sendDate(Date sendDate) {
    this.sendDate = sendDate;
    return this;
  }

  /**
   * Date format according to ISO_8601 for example: yyyy-MM-dd'T'HH:mm:ss.SSSZ
   * @return sendDate
  **/
  @ApiModelProperty(example = "2020-11-17T12:08:56.235-0100", required = true, value = "Date format according to ISO_8601 for example: yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  @NotNull

  @Valid

  public Date getSendDate() {
    return sendDate;
  }

  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseHeader responseHeader = (ResponseHeader) o;
    return Objects.equals(this.responseId, responseHeader.responseId) &&
        Objects.equals(this.sendDate, responseHeader.sendDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, sendDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseHeader {\n");
    
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
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

