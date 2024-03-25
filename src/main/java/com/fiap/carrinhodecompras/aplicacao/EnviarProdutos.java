package com.fiap.carrinhodecompras.aplicacao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.carrinhodecompras.adapters.IMensagens;
import com.fiap.carrinhodecompras.dominio.Pagamento;
import com.fiap.carrinhodecompras.view.exceptions.ConverterParaJsonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnviarProdutos {

	IMensagens mensagens;

	@Autowired
	EnviarProdutos(IMensagens mensagens) {
		this.mensagens = mensagens;
	}

	public void ParaPagamentos(Pagamento pagamento) {

		String carrinhoDeProdutos = this.convertObjectToString(pagamento);

		mensagens.enviar(carrinhoDeProdutos);
	}

	private String convertObjectToString(Pagamento pagamento) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(pagamento);
		} catch (JsonProcessingException jsonProcessingException) {
			throw new ConverterParaJsonException("Nao foi possivel criar o json do objeto solicitado");
		}
	}


}
