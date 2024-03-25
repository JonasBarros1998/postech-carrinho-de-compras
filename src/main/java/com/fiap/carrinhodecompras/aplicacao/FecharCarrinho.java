package com.fiap.carrinhodecompras.aplicacao;

import com.fiap.carrinhodecompras.dominio.Carrinho;
import com.fiap.carrinhodecompras.dominio.Pagamento;
import com.fiap.carrinhodecompras.dominio.ProdutosComprados;
import com.fiap.carrinhodecompras.view.form.CarrinhoForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FecharCarrinho {

	private EnviarProdutos enviarProdutos;

	private AdicionarProdutosNaSessao adicionarProdutosNaSessao;

	@Autowired
	FecharCarrinho(EnviarProdutos enviarProdutos, AdicionarProdutosNaSessao adicionarProdutosNaSessao) {
		this.enviarProdutos = enviarProdutos;
		this.adicionarProdutosNaSessao = adicionarProdutosNaSessao;
	}

	public CarrinhoForm fechar(CarrinhoForm carrinhoForm) {

		var carrinho = new Carrinho(
			carrinhoForm.usuarioID(),
			carrinhoForm.vendaID(),
			carrinhoForm.pagamentoID()
		);

		List<ProdutosComprados> produtosComprados = carrinhoForm.produtos().stream().map(carrinhoFormItem ->
			new ProdutosComprados(
				carrinhoFormItem.id(),
				carrinhoFormItem.valor(),
				carrinhoFormItem.quantidade(),
				carrinho
			)
		).toList();

		BigDecimal valorDoCarrinho = this.calcularValorDoCarrinho(produtosComprados);

		carrinho.setValorDoCarrinho(valorDoCarrinho);
		carrinho.setProdutosComprados(produtosComprados);

		this.adicionarProdutosNaSessao(carrinho);

		this.enviarParaPagamento(
			new Pagamento(carrinhoForm.pagamentoID(), carrinhoForm.usuarioID(), valorDoCarrinho, carrinhoForm.vendaID())
		);

		return carrinhoForm;

	}

	public void enviarParaPagamento(Pagamento pagamento) {
		this.enviarProdutos.ParaPagamentos(pagamento);
	}

	public BigDecimal calcularValorDoCarrinho(List<ProdutosComprados> produtosComprados) {
		return new ValorTotalDoCarrinho().calcular(produtosComprados);
	}

	public void adicionarProdutosNaSessao(Carrinho carrinho) {
		this.adicionarProdutosNaSessao.adicionar(carrinho);
	}
}
