package com.opendatadelaware.feede.controller.utils;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

/**
 * Created by markbrown on 7/7/17.
 */
public class ItemsValidator {

    private static final Validator VALIDATOR;

    static {
        VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @NotNull(message = "Category cannot be null")
    private String category;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Quantity cannot be null")
    private String quantity;

    public ItemsValidator() {}

    public boolean isValid() {
        return VALIDATOR.validate(this).size() == 0;
    }

    public String getCategory() {
        return category;
    }

    public ItemsValidator setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemsValidator setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getQuantity() {
        return quantity;
    }

    public ItemsValidator setQuantity (String quantity) {
        this.quantity = quantity;
        return this;
    }

}
