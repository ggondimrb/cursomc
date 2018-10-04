package com.gabrielgondim.cursomc.resources.exceptions;

import java.util.ArrayList;

import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName, String mensagem) {
		errors.add(new FieldMessage(fieldName,mensagem));
		
	}
}
