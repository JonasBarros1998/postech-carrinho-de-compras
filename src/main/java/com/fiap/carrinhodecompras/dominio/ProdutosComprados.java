package com.fiap.carrinhodecompras.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;


@Entity
@Table(name = "produtos_comprados")
public class ProdutosComprados {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private UUID produdoID;

	private BigDecimal valor;

	private Integer quantidade;

	@ManyToOne(cascade = CascadeType.ALL)
	private Carrinho carrinho;

	protected ProdutosComprados() {}

	public ProdutosComprados(UUID produdoID, BigDecimal valor, Integer quantidade, Carrinho carrinho) {
		this.produdoID = produdoID;
		this.valor = valor;
		this.quantidade = quantidade;
		this.carrinho = carrinho;
	}

	public UUID getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public UUID getProdudoID() {
		return produdoID;
	}

}
