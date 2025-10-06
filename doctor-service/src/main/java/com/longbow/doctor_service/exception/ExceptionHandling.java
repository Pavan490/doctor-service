package com.longbow.doctor_service.exception;

import com.longbow.doctor_service.utils.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(Exception.class)

    public ResponseEntity<?> exceptionHandling(Exception exception){
        Map<String,Object> res=new HashMap<>();
        res.put(ResponseData.RESULT,ResponseData.FAILED);
        res.put(ResponseData.ERROR,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodHandlingException(MethodArgumentNotValidException validException){
        Map<String ,Object> response=new HashMap<>();
        validException.getBindingResult().getFieldErrors().forEach(err->{
            response.put(err.getField(),err.getDefaultMessage());
        });
        Map<String,Object> res=new HashMap<>();
        res.put(ResponseData.RESULT,ResponseData.FAILED);
        res.put(ResponseData.ERROR,response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

}
