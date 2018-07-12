package br.com.ctrft.aluno.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctrft.aluno.controller.AlunoController;
import br.com.ctrft.aluno.domain.dto.DadosAluno;

@Path("aluno")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class AlunoResource {

	
	@POST
	public Response cadastrarAluno(DadosAluno dadosAluno) {
		return AlunoController.cadastrarAluno(dadosAluno);
	}	
	
	@GET
	@Path("/consultar/{cpf}")
	public Response consultarAluno(@PathParam("cpf") String cpf) {
		return AlunoController.consultarAluno(cpf);
	}
	
	@DELETE
	@Path("/excluir/{cpf}")
	public Response excluirAluno(@PathParam("cpf") String cpf){
		return AlunoController.excluirAluno(cpf);
	}
	
	@PUT
	@Path("/alterar")
	public Response alterarAluno(DadosAluno dadosAluno) {		
		return AlunoController.alterarAluno(dadosAluno);
	}
	
}
