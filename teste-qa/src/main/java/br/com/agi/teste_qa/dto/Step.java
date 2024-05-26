package br.com.agi.teste_qa.dto;

import java.io.InputStream;
import java.io.Serializable;

public class Step implements Serializable {

private static final long serialVersionUID = -8380986441750684280L;

	private String passo;
	
	private String dataexec;
	
	private InputStream evidencia;
	
	public Step(){}
	
	public Step(String passo, InputStream evid)
	{
		this.passo = passo;
		this.evidencia = evid;
	}	

	public String getPasso() {
		return passo;
	}

	public void setPasso(String passo) {
		this.passo = passo;
	}

	public InputStream getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(InputStream evidencia) {
		this.evidencia = evidencia;
	}

	public String getDataexec() {
		return dataexec;
	}

	public void setDataexec(String dataexec) {
		this.dataexec = dataexec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}