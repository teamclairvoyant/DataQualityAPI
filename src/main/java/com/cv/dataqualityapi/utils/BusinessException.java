package com.cv.dataqualityapi.utils;

public class BusinessException extends RuntimeException {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6921895758874705639L;
       
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(String message, Throwable err) {
        super(message, err);
    }

}
