package com.fiap.carrinhodecompras.infra.repository;

import com.fiap.carrinhodecompras.dominio.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {

	@Query(value = "select carrinho from Carrinho as carrinho where carrinho.usuarioID = :id order by carrinho.data desc limit 1")
	Optional<Carrinho> consultarProdutoNoCarrinho(UUID id);
}
