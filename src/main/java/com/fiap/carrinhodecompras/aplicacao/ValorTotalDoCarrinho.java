package com.fiap.carrinhodecompras.aplicacao;

import com.fiap.carrinhodecompras.dominio.CalcularValorDoCarrinho;
import com.fiap.carrinhodecompras.dominio.ProdutosComprados;

import java.math.BigDecimal;
import java.util.List;

public class ValorTotalDoCarrinho {

	public BigDecimal calcular(List<ProdutosComprados> produtosComprados) {
		return CalcularValorDoCarrinho.calcular(produtosComprados);
	}
}
