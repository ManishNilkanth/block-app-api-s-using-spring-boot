package com.manishCreation.blogappapi.s.Exceptions;

import com.manishCreation.blogappapi.s.Payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // If any global error occurs in Controller so first it will come here and will resolve with simple message
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception)
    {
        String massage = exception.getMessage();
        ApiResponse apiResponse = new ApiResponse(massage,false);

        return  new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String ,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception)
    {
        Map<String ,String> response = new HashMap<>();
        exception.getBindingResult().getAllErrors()
                .forEach((error)->{
                    String fieldName =((FieldError)error).getField();
                    String message = error.getDefaultMessage();

                    response.put(fieldName,message);
                });

        return new ResponseEntity<Map<String,String>>(response , HttpStatus.BAD_REQUEST);

    }
}
