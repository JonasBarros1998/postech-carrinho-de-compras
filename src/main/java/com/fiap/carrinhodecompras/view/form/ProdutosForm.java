package com.fiap.carrinhodecompras.view.form;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutosForm(

	@NotNull(message = "o campo ID deve ser obrigatorio")
	UUID id,

	@NotNull(message = "campo valor e obrigatorio")
	BigDecimal valor,

	@NotNull(message = "campo quantidade e obrigatorio")
	Integer quantidade

) {}