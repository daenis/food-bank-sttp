package com.opendatadelaware.feede.controller.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by aaronlong on 7/2/17.
 */
public class RequestBodyMapper<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestBodyMapper.class);
    private boolean present;
    private T result;

    private RequestBodyMapper(byte[] json, Class<T> tClass) {
        try {
            result = new ObjectMapper().readValue(json, tClass);
            present = true;
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            present = false;
            result = null;
        }
    }

    public static <T> RequestBodyMapper<T> factory(byte[] json, Class<T> theClass) {
        return new RequestBodyMapper<T>(json, theClass);
    }

    public boolean doesExist() {
        return present;
    }

    public T get() {
        return result;
    }
}
