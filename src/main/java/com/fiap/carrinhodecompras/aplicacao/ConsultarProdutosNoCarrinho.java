package com.fiap.carrinhodecompras.aplicacao;

import com.fiap.carrinhodecompras.infra.repository.CarrinhoRepository;
import com.fiap.carrinhodecompras.view.form.ConsultarCarrinhoDoUsuarioForm;
import com.fiap.carrinhodecompras.view.form.ProdutosForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsultarProdutosNoCarrinho {

	CarrinhoRepository carrinhoRepository;

	@Autowired
	ConsultarProdutosNoCarrinho(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}

	public ConsultarCarrinhoDoUsuarioForm consultar(UUID usuario) {
		var carrinho = this.carrinhoRepository.consultarProdutoNoCarrinho(usuario).orElseThrow(null);

		var produtosForm = carrinho.getProdutos().stream().map(produtosItem ->
			new ProdutosForm(produtosItem.getProdudoID(), produtosItem.getValor(), produtosItem.getQuantidade())
		).toList();

		return new ConsultarCarrinhoDoUsuarioForm(
			carrinho.getPagamentoID(),
			carrinho.getUsuarioID(),
			carrinho.getVendaID(),
			carrinho.getData(),
			produtosForm);
	}
}
