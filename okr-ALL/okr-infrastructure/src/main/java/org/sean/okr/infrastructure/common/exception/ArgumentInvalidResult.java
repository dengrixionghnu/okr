package org.sean.okr.infrastructure.common.exception;

import lombok.Data;

/**
 * @author sean
 * @Description
 * @create 2020-10-21 21:27
 */
@Data
public class ArgumentInvalidResult {
    private String message;
    private String field;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
