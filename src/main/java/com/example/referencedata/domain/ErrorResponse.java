package com.comcast.tds.contacts.dto;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "errorMessage"
})
public class ErrorResponse {

    /**
     * Error message
     *
     */
    @JsonProperty("errorMessage")
    @JsonPropertyDescription("Error message")
    @Schema(required = false, type = "object")
   // @ApiModelProperty(required = false, dataType = "object", position = 0, value = "Error message", example = "")
    @Valid
    private ErrorMessage errorMessage;

    @JsonProperty("errorMessage")
    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("errorMessage")
    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorResponse)) return false;
        ErrorResponse that = (ErrorResponse) o;
        return Objects.equals(getErrorMessage(), that.getErrorMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrorMessage());
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorMessage=" + errorMessage +
                '}';
    }
}
