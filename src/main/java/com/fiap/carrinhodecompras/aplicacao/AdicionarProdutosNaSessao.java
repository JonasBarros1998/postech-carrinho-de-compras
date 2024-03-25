package com.fiap.carrinhodecompras.aplicacao;

import com.fiap.carrinhodecompras.dominio.Carrinho;
import com.fiap.carrinhodecompras.infra.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class AdicionarProdutosNaSessao {

	private CarrinhoRepository carrinhoRepository;

	@Autowired
	public AdicionarProdutosNaSessao(CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}

	public void adicionar(Carrinho carrinho) {
		this.carrinhoRepository.save(carrinho);
	}

}
