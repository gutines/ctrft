package br.com.ctrft.usuario.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.ctrft.usuario.domain.model.Perfil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioLogado {

	private String usuario;
	private Perfil perfil;

	public UsuarioLogado() {

	}

	public UsuarioLogado(String usuario, Perfil perfil) {
		this.usuario = usuario;
		this.perfil = perfil;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
