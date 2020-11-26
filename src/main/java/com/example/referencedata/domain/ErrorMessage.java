package com.comcast.tds.contacts.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "errors"
})
public class ErrorMessage {

    @JsonProperty("errors")
    @JsonPropertyDescription("")
    //@ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Schema(required = false, type = "array")
    @Valid
    private List<Error> errors = new ArrayList<>();

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage)) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(getErrors(), that.getErrors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrors());
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errors=" + errors +
                '}';
    }
}
