package com.fiap.carrinhodecompras.adapters;

import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.util.concurrent.CompletableFuture;

public interface IMensagens {
	CompletableFuture<SendMessageResponse> enviar(String mensagem);
}
