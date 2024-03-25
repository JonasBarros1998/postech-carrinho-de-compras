package com.fiap.carrinhodecompras.dominio;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carrinho")
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private UUID pagamentoID;

	@Column(nullable = false)
	private BigDecimal valorDoCarrinho;

	@Column(nullable = false)
	private UUID usuarioID;

	@Column(nullable = false)
	private UUID vendaID;

	@Column()
	private LocalDateTime data = LocalDateTime.now();

	@OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
	private List<ProdutosComprados> produtosComprados;

	protected Carrinho() {}

	public Carrinho(UUID usuarioID, UUID vendaID, UUID pagamentoID) {
		this.usuarioID = usuarioID;
		this.vendaID = vendaID;
		this.pagamentoID = pagamentoID;
	}

	public List<ProdutosComprados> getProdutos() {
		return this.produtosComprados;
	}

	public UUID getUsuarioID() {
		return usuarioID;
	}

	public UUID getVendaID() {
		return vendaID;
	}

	public UUID getId() {
		return id;
	}

	public BigDecimal getValorDoCarrinho() {
		return valorDoCarrinho;
	}

	public UUID getPagamentoID() {
		return pagamentoID;
	}

	public LocalDateTime getData() {
		return data;
	}

	public List<ProdutosComprados> getProdutosComprados() {
		return produtosComprados;
	}

	public void setValorDoCarrinho(BigDecimal valorDoCarrinho) {
		this.valorDoCarrinho = valorDoCarrinho;
	}

	public void setProdutosComprados(List<ProdutosComprados> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}

}
