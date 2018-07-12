package br.com.ctrft.aluno.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;

import br.com.ctrft.aluno.domain.model.Alunos;
import br.com.ctrft.database.DatabaseUtil;

public class AlunoDao {

	private static EntityManager em = DatabaseUtil.getEntityManager();

	public static void inserir(Alunos aluno) throws Exception {
		em.getTransaction().begin();

		try {
			em.persist(aluno);
			em.flush();
			em.getTransaction().commit();
			
		}catch (Exception e) {
			Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, "", e);
			em.getTransaction().rollback();
			throw new Exception("CPF já cadastrado!");
		}
		
	}

	public static Alunos consultarAlunoPorCpf(String cpf) {
		Alunos alunoEncontrado = new Alunos();

		TypedQuery<Alunos> tq = em.createNamedQuery("ConsultarPorCpfDoAluno", Alunos.class);
		tq.setParameter("pCpf", cpf);
		alunoEncontrado = tq.getSingleResult();
		
		

		return alunoEncontrado;
	}

	public static void excluir(String cpf) {
		em.getTransaction().begin();

		try {
			em.remove(consultarAlunoPorCpf(cpf));
			em.getTransaction().commit();

		} catch (PersistenceException px) {
			log(px);
			throw new PersistenceException(px.getMessage());

		} catch (Exception e) {
			log(e);
			em.getTransaction().rollback();
		}
	}

	public static void alterar(Alunos aluno) {
		em.getTransaction().begin();

		try {
			em.merge(aluno);
			em.getTransaction().commit();

		} catch (Exception e) {
			log(e);
			em.getTransaction().rollback();
		}

	}

	private static void log(Exception erro) {
		Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, erro);
	}

}
