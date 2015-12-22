package com.xyInc.entity;

public class CadastroResponse {
	private CadastroResponseStatus status;
	private PontoDeInteresse pontoSalvo;
	
	public CadastroResponse(){
		super();
	}
	
	public CadastroResponse(CadastroResponseStatus status, PontoDeInteresse pontoSalvo) {
		super();
		this.status = status;
		this.pontoSalvo = pontoSalvo;
	}

	public CadastroResponseStatus getStatus() {
		return status;
	}

	public void setStatus(CadastroResponseStatus status) {
		this.status = status;
	}

	public PontoDeInteresse getPontoSalvo() {
		return pontoSalvo;
	}

	public void setPontoSalvo(PontoDeInteresse pontoSalvo) {
		this.pontoSalvo = pontoSalvo;
	}
}
