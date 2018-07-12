package br.com.ctrft.usuario.domain.dto;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.ctrft.usuario.domain.model.Perfil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Sessao {

	private long idUsuario;
	private Calendar inicioSessao;
	private Calendar ultimaRequisicao;
	private Perfil perfilUsuario;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Calendar getInicioSessao() {
		return inicioSessao;
	}

	public void setInicioSessao(Calendar inicioSessao) {
		this.inicioSessao = inicioSessao;
	}

	public Calendar getUltimaRequisicao() {
		return ultimaRequisicao;
	}

	public void setUltimaRequisicao(Calendar ultimaRequisicao) {
		this.ultimaRequisicao = ultimaRequisicao;
	}

	public Perfil getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(Perfil perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

}
