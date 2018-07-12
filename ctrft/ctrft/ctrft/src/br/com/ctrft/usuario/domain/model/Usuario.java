package br.com.ctrft.usuario.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.ctrft.usuario.domain.dto.DadosUsuario;

@NamedQueries({
		@NamedQuery(name = "ConsultaPorNomeDeUsuario", query = "SELECT user FROM Usuario user WHERE user.usuario = :pUsuario"),
		@NamedQuery(name = "AutenticarUsuario", query = "SELECT user FROM Usuario user WHERE user.usuario = :pUsuario AND user.senha = :pSenha") })

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 4599846334115363593L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String usuario;
	private String senha;

	@Enumerated(EnumType.STRING)
	private Perfil perfil;

//	@OneToMany(mappedBy = "usuario")
//	private List<Sessao> sessao;

	public Usuario() {

	}
	

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario(String usuario, String senha, Perfil perfil) {
		this.usuario = usuario;
		this.senha = senha;
		this.perfil = perfil;
	}
	
	public Usuario(DadosUsuario dadosUsuario) {
		this.usuario = dadosUsuario.getUsuario();
		this.senha = dadosUsuario.getSenha();
		this.perfil = dadosUsuario.getPerfil();
	}

	public long getId() {
		return id;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

//	public List<Sessao> getSessao() {
//		return sessao;
//	}
//
//	public void setSessao(List<Sessao> sessao) {
//		this.sessao = sessao;
//	}

}
