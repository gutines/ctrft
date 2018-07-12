package br.com.ctrft.usuario.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.ctrft.usuario.controller.LoginController;
import br.com.ctrft.usuario.domain.dto.Credenciais;

@Path("login")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class LoginResource {


	@POST
	public Response login(Credenciais credenciais) {		
		LoginController login = new LoginController();
		
		return login.efetuarLogin(credenciais);
	}
}
