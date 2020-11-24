package com.comcast.tds.contacts.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "code",
        "message"
})
public class Error {

    @NotNull
    @JsonProperty("code")
    @JsonPropertyDescription("")
    @Schema(required = true, type = "string",example = "CONTRACT_VOILATION" )
   // @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "CONTRACT_VOILATION")
    @Size(min = 1, max = 50)
    private String code;

    @NotNull
    @JsonProperty("message")
    @JsonPropertyDescription("")
    @Schema(required = true, type = "string",example = "Field Name - Mandatory Field is missing in the request" )
  //  @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "Field Name - Mandatory Field is missing in the request")
    @Size(min = 1, max = 500)
    private String message;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Error)) return false;
        Error error = (Error) o;
        return getCode().equals(error.getCode()) &&
                getMessage().equals(error.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage());
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
