package com.cv.dataqualityapi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class BusinessException extends RuntimeException {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6921895758874705639L;
	
	private String message;
	
	public BusinessException() {
		
	}
       
    public BusinessException(String message) {
        super(message);
        this.message = message;
    }
    
    public BusinessException(String message, Throwable err) {
        super(message, err);
        this.message = message;
    }

}
