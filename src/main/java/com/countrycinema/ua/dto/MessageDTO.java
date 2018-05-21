package com.countrycinema.ua.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageDTO<T> {

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String message;

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private MessageDTO(String message) {
        this.message = message;
    }

    private MessageDTO(T data) {
        this.data = data;
    }

    private MessageDTO(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public static MessageDTO of(String message) {
        return new MessageDTO(message);
    }

    @SuppressWarnings("all")
    public static<T> MessageDTO ofGeneric(T data) {
        return new MessageDTO(data);
    }

    @SuppressWarnings("all")
    public static<T> MessageDTO of(String message, T data) {
        return new MessageDTO(message, data);
    }

}
