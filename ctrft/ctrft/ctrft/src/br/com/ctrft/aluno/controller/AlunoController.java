package br.com.ctrft.aluno.controller;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;

import br.com.ctrft.aluno.dao.AlunoDao;
import br.com.ctrft.aluno.domain.dto.DadosAluno;
import br.com.ctrft.aluno.domain.model.Alunos;
import br.com.ctrft.util.ResponseUtil;

public class AlunoController {

	public static Response cadastrarAluno(DadosAluno dadosAluno) {
		Response response = null;
		Alunos aluno = new Alunos(dadosAluno);

		try {
			AlunoDao.inserir(aluno);
			response = Response.ok().entity("Aluno cadastrado com sucesso").build();
		} catch (Exception erro) {
			response = Response.serverError().entity(erro.getMessage()).build();
		}
		
		return response;
	}

	public static Response consultarAluno(String cpf) {
		Response response = null;

		try {
			DadosAluno dadosAluno = new DadosAluno(AlunoDao.consultarAlunoPorCpf(cpf));
			response = Response.ok().entity(dadosAluno).build();

		} catch (NoResultException erro) {
			response = ResponseUtil.dataNotFound;

		} catch (Exception erro) {
			response = ResponseUtil.serverError;
		}
		
		return response;
	}

	public static Response excluirAluno(String cpf) {
		Response response = null;

		try {
			AlunoDao.excluir(cpf);			
			response = Response.ok().entity("Cpf " + cpf + " excluido!").build();

		} catch (NoResultException erro) {
			response = ResponseUtil.dataNotFound;

		} catch (Exception erro) {
			response = ResponseUtil.serverError;
		}
		
		return response;
	}

	public static Response alterarAluno(DadosAluno dadosAluno) {
		Response response = null;
		
		try {
			Alunos aluno = AlunoDao.consultarAlunoPorCpf(dadosAluno.getCpf());
			Alunos alunoAlterado = new Alunos(dadosAluno);
			alunoAlterado.setIdAluno(aluno.getIdAluno());
			aluno = alunoAlterado;
			AlunoDao.alterar(aluno);
			
			response = Response.ok().entity(aluno).build(); 
			
		} catch (NoResultException erro) {
			response = ResponseUtil.dataNotFound;

		} catch (Exception erro) {
			response = ResponseUtil.serverError;
		}

		return response;
	}

}
