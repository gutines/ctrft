package br.com.ctrft.security;

import java.util.Date;

import br.com.ctrft.security.dto.PayloadDados;
import br.com.ctrft.security.listeners.ConfigServer;
import br.com.ctrft.usuario.domain.dto.UsuarioLogado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtil {

	public static String generateToken(UsuarioLogado usuarioLogado) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		PayloadDados payload = obterNovoPayload();

		JwtBuilder builder = Jwts.builder()
				.setIssuedAt(payload.getIssuerAt())
				.setSubject(usuarioLogado.getUsuario())
				.claim("perfil", usuarioLogado.getPerfil())
				.setIssuer(payload.getIssuer())
				.signWith(signatureAlgorithm, ConfigServer.getServerKey());

		return builder.compact();
	}

	public static Jws<Claims> decode(String token) {
		return Jwts.parser().setSigningKey(ConfigServer.getServerKey()).parseClaimsJws(token);
	}

	private static PayloadDados obterNovoPayload() {
		PayloadDados payload = new PayloadDados();
		payload.setIssuer("CTRFT Service App");

		long atualMillis = System.currentTimeMillis();
		payload.setIssuerAt(new Date(atualMillis));

		// TODO Tratar tempo para expirar

		return payload;
	}
}
