package com.fiap.carrinhodecompras.view.exceptions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidacaoHandler {

	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConverterParaJsonException.class)
	public List<ErroForm> handler(ConverterParaJsonException exception) {
		List<ErroForm> erroFormList = new ArrayList<>();
		ErroForm erroForm = new ErroForm(exception.getMessage(), "");
		erroFormList.add(erroForm);

		return erroFormList;
	}

}
