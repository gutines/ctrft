package br.com.ctrft.aluno.domain.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ctrft.aluno.domain.dto.DadosAluno;

@NamedQueries({
	@NamedQuery(name = "ConsultarPorCpfDoAluno", query = "SELECT aluno FROM Alunos aluno WHERE aluno.cpf = :pCpf") })

@Entity
public class Alunos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAluno;
	private String nomeCompleto;

	@Temporal(TemporalType.DATE)
	private Calendar dataDeNascimento;
	private String rg;
	@Column(unique = true)
	private String cpf;
	private String telefone;
	private String contato;
	private String email;
	
	public Alunos() {
		
	}
	
	public Alunos(DadosAluno dadosAluno) {
		this.nomeCompleto = dadosAluno.getNomeCompleto();
		this.dataDeNascimento = dadosAluno.getDataDeNascimento();
		this.rg = dadosAluno.getRg();
		this.cpf = dadosAluno.getCpf();
		this.telefone = dadosAluno.getTelefone();
		this.contato = dadosAluno.getTelefoneContato();
		this.email = dadosAluno.getEmail();		
	}

	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
