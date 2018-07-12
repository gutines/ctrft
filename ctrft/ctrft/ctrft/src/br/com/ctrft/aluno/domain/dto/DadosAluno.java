package br.com.ctrft.aluno.domain.dto;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.ctrft.aluno.domain.model.Alunos;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DadosAluno {

	private String nomeCompleto;
	private Calendar dataDeNascimento;
	private String rg;
	private String cpf;
	private String telefone;
	private String telefoneContato;
	private String email;

	public DadosAluno() {

	}
	
	public DadosAluno(Alunos aluno) {
		this.nomeCompleto = aluno.getNomeCompleto();
		this.dataDeNascimento = aluno.getDataDeNascimento();
		this.rg = aluno.getRg();
		this.cpf = aluno.getCpf();
		this.telefone = aluno.getTelefone();
		this.telefoneContato = aluno.getContato();
		this.email = aluno.getEmail();
	}

	public DadosAluno(String nomeCompleto, Calendar dataDeNascimento, String rg, String cpf, String telefone,
			String telefoneContato, String email) {
		this.nomeCompleto = nomeCompleto;
		this.dataDeNascimento = dataDeNascimento;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.telefoneContato = telefoneContato;
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
