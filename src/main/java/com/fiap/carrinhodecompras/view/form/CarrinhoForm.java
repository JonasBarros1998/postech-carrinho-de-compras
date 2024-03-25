package com.fiap.carrinhodecompras.view.form;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.util.List;
import java.util.UUID;

public record CarrinhoForm(

	@NotNull(message = "o campo usuarioID e obrigatorio")
	UUID usuarioID,

	@NotNull(message = "o campo pagamentoID e obrigatorio")
	UUID pagamentoID,

	@NotNull(message = "o campo vendaID e obrigatorio")
	UUID vendaID,

	@NotNull
	@Valid
	List<ProdutosForm> produtos

) {
}
