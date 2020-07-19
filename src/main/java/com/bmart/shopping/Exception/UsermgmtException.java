package com.bmart.shopping.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsermgmtException {

	@ExceptionHandler
	//@ResponseBody
	public String handleInvalidFieldException(InvalidFieldException exception) {
       	return exception.getMessage();	
	}
	
}
