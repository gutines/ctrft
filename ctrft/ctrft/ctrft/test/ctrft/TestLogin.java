package ctrft;

import java.util.Calendar;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import br.com.ctrft.aluno.domain.dto.DadosAluno;
import br.com.ctrft.security.TokenUtil;
import br.com.ctrft.usuario.dao.UsuarioDao;
import br.com.ctrft.usuario.domain.dto.Credenciais;
import br.com.ctrft.usuario.domain.dto.DadosUsuario;
import br.com.ctrft.usuario.domain.dto.UsuarioLogado;
import br.com.ctrft.usuario.domain.model.Perfil;
import br.com.ctrft.usuario.domain.model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TestLogin {

	// @Test
	// void test() {
	//
	// String uri = "http://localhost:8080";
	//
	// Client cliente = ClientBuilder.newClient();
	// WebTarget target = cliente.target(uri);
	// String conteudo =
	// target.path("/ctrft/rest/login/1").request().get(String.class);
	//
	// Assert.assertTrue(Boolean.valueOf(conteudo));
	// }

	private static final String uri = "http://localhost:8080";
	private Client cliente;
	private WebTarget target;

	@Before
	void criarClient() {
		cliente = ClientBuilder.newClient();
		target = cliente.target(uri);
	}

	@Test
	@Disabled
	void criarUsuario() {
		String user = "Augusto";
		String senha = "123456";
		Perfil perfil = Perfil.ADMIN;
		Usuario usuario = new Usuario(user, senha, perfil);
		UsuarioDao.inserir(usuario);

	}

	// @Test
	// @Disabled
	// void ConsultarUsuario() {
	// String user = "Augusto";
	// String senha = "123456";
	// Perfil perfil = Perfil.ADMIN;
	// UsuarioDao dao = new UsuarioDao();
	//
	//
	//// dao.inserirUsuario(usuario)
	// Usuario usuario = dao.consultarUsuario(user);
	//
	// Assert.assertEquals(user, usuario.getUsuario());
	//
	// }

	// @Test
	// @Disabled
	// void ConsultarSessao() {
	// long token = 1527722415557L;
	// SessaoDao dao = new SessaoDao();
	//
	// Sessao sessao = dao.consultar(token);
	//
	// System.out.println("Sessao: " + sessao.getToken());
	// Assert.assertEquals(token, sessao.getToken());
	//
	// }

	
	@Test
	void test1() { // Cadastrar
		System.out.println("test1");
		
		criarClient();
		Response response = null;	
		String token = efetuarLogin();

		if (token != "") {
			Entity<DadosAluno> dadosAluno = Entity.entity(obterAlunoTeste(), MediaType.APPLICATION_XML);
			response = target.path("/ctrft/rest/aluno").request().header(HttpHeaders.AUTHORIZATION, token)
					.post(dadosAluno);
		}

		Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
	}

	
	@Test
	void test2() { // Consultar
		System.out.println("test2");
		
		criarClient();
		Response response = null;
		String token = efetuarLogin();

		if (token != "") {
			String cpfAluno = "36421882811";
			response = target.path("/ctrft/rest/aluno/consultar/" + cpfAluno).request()
					.header(HttpHeaders.AUTHORIZATION, token).get();
			DadosAluno dadosAluno = response.readEntity(DadosAluno.class);
			System.out.println("Aluno: " + dadosAluno.getNomeCompleto());
		}
		Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
	}

	
	@Test
	void test3() { // Alterar
		System.out.println("test3");
		
		criarClient();
		Response response = null;
		String token = efetuarLogin();

		if (token != "") {
			DadosAluno alunoAlterado = obterAlunoTeste();
			alunoAlterado.setNomeCompleto("Aline Santesso de Alvarenga");
			Entity<DadosAluno> dadosAluno = Entity.entity(alunoAlterado, MediaType.APPLICATION_XML);
			response = target.path("/ctrft/rest/aluno/alterar").request().header(HttpHeaders.AUTHORIZATION, token)
					.put(dadosAluno);
		}

		Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
	}

	
	@Test  
	void test4() { // Excluir
		System.out.println("test4");
		
		criarClient();
		Response response = null;
		String token = efetuarLogin();

		if (token != "") {
			String cpfAluno = "36421882811";
			response = target.path("/ctrft/rest/aluno/excluir/" + cpfAluno).request()
					.header(HttpHeaders.AUTHORIZATION, token).delete();
			System.out.println(response.readEntity(String.class));
		}
		Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
	}

	@Test
	@Disabled
	void testLogin() {
		criarClient();
		Credenciais cred = new Credenciais("Augusto", "123456");
		Entity<Credenciais> entity = Entity.entity(cred, MediaType.APPLICATION_XML);
		Response response = target.path("/ctrft/rest/login").request().post(entity);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			System.out.println("Token:  " + response.getHeaderString(HttpHeaders.AUTHORIZATION));
		}
		
		Assert.assertTrue(response.getStatusInfo() == Response.Status.OK);
	}

	private String efetuarLogin() {
		Credenciais cred = new Credenciais("Augusto", "123456");
		Entity<Credenciais> entity = Entity.entity(cred, MediaType.APPLICATION_XML);
		Response response = target.path("/ctrft/rest/login").request().post(entity);

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			return response.getHeaderString(HttpHeaders.AUTHORIZATION);
		}

		return "";
	}

	private DadosAluno obterAlunoTeste() {
		Calendar dataDeNascimento = Calendar.getInstance();
		String nome = "Augusto Santesso de Alvarenga";
		dataDeNascimento.set(Calendar.YEAR, 1987);
		dataDeNascimento.set(Calendar.MONTH, Calendar.JULY);
		dataDeNascimento.set(Calendar.DAY_OF_MONTH, 14);
		String rg = "344925031";
		String cpf = "36421882811";
		String telefone = "11988258650";
		String contato = "11989004848";
		String email = "augusto.alvarenga@";

		return new DadosAluno(nome, dataDeNascimento, rg, cpf, telefone, contato, email);
	}

}
