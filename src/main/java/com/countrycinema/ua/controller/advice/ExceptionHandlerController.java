package com.countrycinema.ua.controller.advice;

import com.countrycinema.ua.common.Logger;
import com.countrycinema.ua.dto.MessageDTO;
import com.countrycinema.ua.exception.BadInputParamException;
import com.countrycinema.ua.exception.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    private static final String ON_ROUTE = "On route: {}";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<MessageDTO> handleException(Exception e, WebRequest request) {
        Logger.error(e, ON_ROUTE, ((ServletWebRequest) request).getRequest().getRequestURI());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(MessageDTO.of(InternalException.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(InternalException.class)
    @ResponseBody
    public ResponseEntity<MessageDTO> handleException(InternalException e, WebRequest request) {
        Logger.error(e, ON_ROUTE, ((ServletWebRequest) request).getRequest().getRequestURI());
        return ResponseEntity.status(e.getStatus()).body(MessageDTO.of(e.getMessage()));
    }

    @ExceptionHandler(BadInputParamException.class)
    @ResponseBody
    public ResponseEntity<MessageDTO> handleException(BadInputParamException e, WebRequest request) {
        Logger.error(e, ON_ROUTE, ((ServletWebRequest) request).getRequest().getRequestURI());
        return ResponseEntity.status(e.getStatus()).body(MessageDTO.of(e.getMessage()));
    }

}
