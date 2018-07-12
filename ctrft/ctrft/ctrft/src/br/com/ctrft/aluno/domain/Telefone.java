package br.com.ctrft.aluno.domain;

public class Telefone {

	private String ddi;
	private String ddd;
	private String numero;

	public Telefone(String ddi, String ddd, String numero) {
		this.ddi = ddi;
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdi() {
		return ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

}
