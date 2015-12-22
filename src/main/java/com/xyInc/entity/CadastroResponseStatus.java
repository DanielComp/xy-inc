package com.xyInc.entity;

public enum CadastroResponseStatus {
	SUCCESS(201,"Sucesso!"),
	ERRO_COORD_NEGATIVAS(400, "As coordenadas devem ser maiores que 0."),
	ERRO_NOME_VAZIO(400, "O Nome não pode ser vazio."),
	ERRO_ACESSO_BANCO(500, "Erro ao acessar banco de dados, tente mais tarde.");
	
	private String mensagem;
	private int httpStatus;
	
	private CadastroResponseStatus(int httpStatus,String mensagem) {
		this.mensagem = mensagem;
		this.httpStatus = httpStatus;
	}

	public String getMensagem() {
		return mensagem;
	}

	public int getHttpStatus() {
		return httpStatus;
	}
	
}
