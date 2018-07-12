package br.com.ctrft.usuario.controller;

import javax.persistence.NoResultException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import br.com.ctrft.security.TokenUtil;
import br.com.ctrft.usuario.dao.UsuarioDao;
import br.com.ctrft.usuario.domain.dto.Credenciais;
import br.com.ctrft.usuario.domain.dto.UsuarioLogado;
import br.com.ctrft.usuario.domain.model.Usuario;

public class LoginController {

	public Response efetuarLogin(Credenciais credenciais) {
		Response response = null;

		try {
			Usuario usuario = UsuarioDao.autenticarUsuario(credenciais);
	//		novaSessao(usuario);

			String token = gerarToken(usuario);
			response = Response.ok().header(HttpHeaders.AUTHORIZATION, token).entity("Acesso Autorizado!").build();

		} catch (NoResultException erro) {
			response = Response.status(Response.Status.UNAUTHORIZED).entity("Acesso não autorizado!").build();

		} catch (Exception erro) {
			response = Response.serverError().entity("Erro interno no servidor").build();
		}

		return response;
	}

/*	private Sessao novaSessao(Usuario usuario) {
		Sessao sessao = new Sessao();
		sessao.setIdUsuario(usuario.getId());
		sessao.setInicioSessao(Calendar.getInstance());
		sessao.setUltimaRequisicao(Calendar.getInstance());

		return sessao;
	}*/

	private String gerarToken(Usuario usuario) {

		return TokenUtil.generateToken(new UsuarioLogado(usuario.getUsuario(), usuario.getPerfil()));
	}

}
