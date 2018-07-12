package br.com.ctrft.usuario.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import br.com.ctrft.usuario.controller.UsuarioController;
import br.com.ctrft.usuario.domain.dto.CadastroUsuario;

@Path("usuario")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class UsuarioResource {
	
	@POST
	public Response cadastrarUsuario(CadastroUsuario cadastroUsuario) {
//		CadastroController controller = new CadastroController();
//		
		return null;		
	}
	
	
	@GET
	@Path("/usuarioLogado")
	public Response usuarioLogado(@Context HttpServletRequest servletRequest) {		
		return new UsuarioController().usuarioLogado(servletRequest);		
	}
}
