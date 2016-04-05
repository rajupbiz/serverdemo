package com.blob.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AbstractCtrl {
    private static final Logger logger = LoggerFactory.getLogger(AbstractCtrl.class);
    
    @Autowired
    private TraceRepository traceRepo;
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationError(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrorMap = new HashMap<>();
        
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError: fieldErrors) {
            fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return fieldErrorMap;
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUnexpectedException(Exception ex) {
        logger.error("Error during process request", ex);
        return ex.getMessage();
    }
    
  /*  protected void traceAction(String action) {
        String user = "anonymous";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            user = authentication.getName();
        }
        
        Map<String, Object> trace = new LinkedHashMap<>();
        trace.put("user", user);
        trace.put("action", action);
        
        System.out.println("  traceAction :: user  >>>  "+user);
        
        traceRepo.add(trace);
    }*/
}
