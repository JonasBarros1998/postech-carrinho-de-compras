package com.fiap.carrinhodecompras.dominio;

import java.math.BigDecimal;
import java.util.UUID;

public class Pagamento {

	private UUID pagamentoID;

	private UUID usuarioID;

	private UUID vendaID;

	private BigDecimal valorTotalDoCarrinho;

	public Pagamento(UUID pagamentoID, UUID usuarioID, BigDecimal valorTotalDoCarrinho, UUID vendaID) {
		this.pagamentoID = pagamentoID;
		this.usuarioID = usuarioID;
		this.valorTotalDoCarrinho = valorTotalDoCarrinho;
		this.vendaID = vendaID;
	}

	public UUID getPagamentoID() {
		return pagamentoID;
	}

	public UUID getUsuarioID() {
		return usuarioID;
	}

	public BigDecimal getValorTotalDoCarrinho() {
		return valorTotalDoCarrinho;
	}

	public UUID getVendaID() {
		return vendaID;
	}
}
