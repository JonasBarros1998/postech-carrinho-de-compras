package com.fiap.carrinhodecompras.infra.seguranca;

import com.fiap.carrinhodecompras.view.exceptions.TokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarDadosDoTokenRequisicao {

	BuscarDadosDoToken buscarDadosDoToken;

	@Autowired
	BuscarDadosDoTokenRequisicao(BuscarDadosDoToken buscarDadosDoToken) {
		this.buscarDadosDoToken = buscarDadosDoToken;
	}

	public Usuario buscar(String token) {
		var resposta = this.buscarDadosDoToken.buscar(token);
		if(resposta.getStatusCode().is2xxSuccessful()) {
			return resposta.getBody();
		}

		throw new TokenException("Token invalido");
	}
}
