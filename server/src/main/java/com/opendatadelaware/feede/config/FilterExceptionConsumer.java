package com.opendatadelaware.feede.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.io.Serializable;
import java.util.Date;

public class FilterExceptionConsumer {
    private static final Logger LOGGER;
    private static final String METHOD_ERROR_RESPONSE;
    private static final String STANDARD_ERROR_RESPONSE;

    static {
        LOGGER = LoggerFactory.getLogger(FilterExceptionConsumer.class);
        METHOD_ERROR_RESPONSE = "The HTTP method isn't supported here.";
        STANDARD_ERROR_RESPONSE = "Internal error occurred, please try again";
    }

    private final Long timestamp;
    private String message;
    private HttpStatus statusCode;

    private FilterExceptionConsumer() {
        timestamp = new Date().getTime();
    }

    private FilterExceptionConsumer(HttpRequestMethodNotSupportedException e) {
        this();
        message = METHOD_ERROR_RESPONSE;
        statusCode = HttpStatus.METHOD_NOT_ALLOWED;
        logError(e.getMessage());
    }

    private FilterExceptionConsumer(Throwable e) {
        this();
        message = STANDARD_ERROR_RESPONSE;
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        logError(e.getMessage());
    }

    public static FilterExceptionConsumer makeExceptionConsumer(Throwable e) {
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return new FilterExceptionConsumer((HttpRequestMethodNotSupportedException) e);
        } else {
            return new FilterExceptionConsumer(e);
        }
    }

    private void logError(String error) {
        LOGGER.debug(error);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getJson() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new ErrorResponse());
    }

    private class ErrorResponse implements Serializable {

        @JsonProperty("timestamp")
        private final Long timestamp = FilterExceptionConsumer.this.timestamp;

        @JsonProperty("message")
        private final String message = FilterExceptionConsumer.this.message;
    }
}
