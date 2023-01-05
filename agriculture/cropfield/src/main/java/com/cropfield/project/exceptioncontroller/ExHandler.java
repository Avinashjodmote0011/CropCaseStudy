package com.cropfield.project.exceptioncontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cropfield.project.exceptions.CropNotFoundException;
import com.cropfield.project.exceptions.UserNotFoundException;



@RestControllerAdvice
public class ExHandler {
	@ExceptionHandler(NullPointerException.class)
	public Map<String,String> handlerNullPointerException(NullPointerException ex){
		Map<String,String> errormap=new HashMap<>();
		errormap.put("errorMessage", ex.getMessage());
		
		return errormap;
	}
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleStudentNotFoundException(UserNotFoundException ex){
		Map<String,String> errormap=new HashMap<>();
		errormap.put("erroMessage", ex.getMessage());
		return errormap;
	}
	@ExceptionHandler(CropNotFoundException.class)
	public Map<String,String> handleCropNotFoundException(){
		Map<String,String> errormap=new HashMap<>();
		errormap.put("erroMessage", "no such crop is in the database");
		return errormap;
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public Map<String,String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
		Map<String,String> errormap=new HashMap<>();
		errormap.put("errorMessage", "check the type of value that you entered");
		
		return errormap;
	}
}
