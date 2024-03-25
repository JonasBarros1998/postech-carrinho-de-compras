package com.fiap.carrinhodecompras.view.form;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ConsultarCarrinhoDoUsuarioForm(
	UUID pagamentoID,

	UUID usuarioID,

	UUID vendaID,

	LocalDateTime data,

	List<ProdutosForm> produtosForm
) {
}
