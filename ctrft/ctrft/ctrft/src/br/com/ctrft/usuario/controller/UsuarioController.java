package br.com.ctrft.usuario.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import br.com.ctrft.security.TokenUtil;
import br.com.ctrft.usuario.domain.dto.UsuarioLogado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class UsuarioController {
	
	public Response usuarioLogado(HttpServletRequest servletRequest) {
		String token = servletRequest.getHeader(HttpHeaders.AUTHORIZATION);
		Jws<Claims> jws = TokenUtil.decode(token);
		System.out.println("Decode: " + jws.getBody().getSubject());
		UsuarioLogado ul = new UsuarioLogado();
		
		ul.setUsuario(jws.getBody().getSubject());		
		
		return null;
	}
	
}
