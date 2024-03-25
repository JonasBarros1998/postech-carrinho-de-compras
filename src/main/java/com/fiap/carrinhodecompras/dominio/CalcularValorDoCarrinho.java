package com.fiap.carrinhodecompras.dominio;

import java.math.BigDecimal;
import java.util.List;

public final class CalcularValorDoCarrinho {

	public static BigDecimal calcular(List<ProdutosComprados> produtosComprados) {
		return produtosComprados.stream()
			.map(produto -> produto.getValor()
				.multiply(new BigDecimal(produto.getQuantidade())))
			.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
