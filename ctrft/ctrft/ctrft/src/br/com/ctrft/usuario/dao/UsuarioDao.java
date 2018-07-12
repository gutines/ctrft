package br.com.ctrft.usuario.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.ctrft.database.DatabaseUtil;
import br.com.ctrft.usuario.domain.dto.Credenciais;
import br.com.ctrft.usuario.domain.model.Usuario;

public class UsuarioDao{

	private static EntityManager em = DatabaseUtil.getEntityManager();
	
	public static Usuario consultarUsuario(long id) {
		
		return null;
	}

	public static Usuario consultarUsuarioPorNome(String usuario) {
		Usuario usuarioConsultado;

		TypedQuery<Usuario> tq = em.createNamedQuery("ConsultaPorNomeDeUsuario", Usuario.class);
		tq.setParameter("pUsuario", usuario);
		usuarioConsultado = tq.getSingleResult();

		return usuarioConsultado;
	}

	public static Usuario autenticarUsuario(Credenciais loginUsuario) {
		TypedQuery<Usuario> tq = em.createNamedQuery("AutenticarUsuario", Usuario.class);
		tq.setParameter("pUsuario", loginUsuario.getUsuario());
		tq.setParameter("pSenha", loginUsuario.getSenha());

		Usuario usuarioAutenticado = tq.getSingleResult();

		return usuarioAutenticado;
	}

	public static void inserir(Usuario usuario) {
		em.getTransaction().begin();

		try {
			em.persist(usuario);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
			em.getTransaction().rollback();
		}
	}

}
