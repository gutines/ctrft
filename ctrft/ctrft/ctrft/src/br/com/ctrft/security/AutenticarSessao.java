package br.com.ctrft.security;

import java.util.Calendar;

import br.com.ctrft.usuario.dao.UsuarioDao;
import br.com.ctrft.usuario.domain.dto.Sessao;
import br.com.ctrft.usuario.domain.model.Usuario;

public class AutenticarSessao {

	private Usuario usuario;
	private Sessao sessao;
	
	public AutenticarSessao(Sessao sessao, String token) {
		this.sessao = sessao;
		carregarUsuario(sessao.getIdUsuario());
	}
	public boolean sessaoValida() {
		if (isUsuarioValido() && isTokenValido() && isSessaoAtiva()) {
			return true;
		} else
			return false;

	}

	private boolean isSessaoAtiva() {
		Calendar expiraEm = sessao.getUltimaRequisicao();
		expiraEm.add(Calendar.MINUTE, 10);

		return sessao.getUltimaRequisicao().before(expiraEm);
	}

	private boolean isTokenValido() {
		return true;
	}

	private boolean isUsuarioValido() {
		return usuario != null;
	}

	private void carregarUsuario(long idUsuario) {		
		UsuarioDao.consultarUsuario(idUsuario);
	}

}
