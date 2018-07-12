package br.com.ctrft.usuario.domain.dto;

import br.com.ctrft.usuario.domain.model.Perfil;

public class DadosUsuario {

	private String usuario;
	private String senha;
	private Perfil perfil;
	
	public DadosUsuario() {
		
	}

	public DadosUsuario(String usuario, String senha, Perfil perfil) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.perfil = perfil;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
