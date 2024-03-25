package com.fiap.carrinhodecompras.view.controller;

import com.fiap.carrinhodecompras.aplicacao.ConsultarProdutosNoCarrinho;
import com.fiap.carrinhodecompras.aplicacao.FecharCarrinho;
import com.fiap.carrinhodecompras.view.form.CarrinhoForm;
import com.fiap.carrinhodecompras.view.form.ConsultarCarrinhoDoUsuarioForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

	FecharCarrinho fecharCarrinho;

	ConsultarProdutosNoCarrinho consultarProdutosNoCarrinho;

	@Autowired
	CarrinhoController(FecharCarrinho enviarProdutos, ConsultarProdutosNoCarrinho consultarProdutosNoCarrinho) {
		this.fecharCarrinho = enviarProdutos;
		this.consultarProdutosNoCarrinho = consultarProdutosNoCarrinho;
	}

	@PostMapping("/adicionar")
	public ResponseEntity<CarrinhoForm> adicionar(@Valid @RequestBody CarrinhoForm carrinhoForm) {
		CarrinhoForm carrinho = this.fecharCarrinho.fechar(carrinhoForm);
		return ResponseEntity.status(HttpStatus.OK).body(carrinho);
	}

	@GetMapping(value = "/consultar", params = {"usuarioID"})
	public ResponseEntity<ConsultarCarrinhoDoUsuarioForm> consultar(@RequestParam UUID usuarioID) {
		return ResponseEntity.status(HttpStatus.OK).body(this.consultarProdutosNoCarrinho.consultar(usuarioID));
	}

}
