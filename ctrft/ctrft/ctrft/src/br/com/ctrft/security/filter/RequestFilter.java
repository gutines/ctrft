package br.com.ctrft.security.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.ctrft.database.DatabaseUtil;
import br.com.ctrft.security.TokenUtil;
import io.jsonwebtoken.SignatureException;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		if (isLoginRequest(requestContext)) {
			createEntityManager();
			return;
		}

		String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (token == null || token.trim().isEmpty()) {
			throw new NotAuthorizedException(Response.status(Response.Status.UNAUTHORIZED));
		}

		try {
			TokenUtil.decode(token);
			createEntityManager();
			return;

		} catch (SignatureException e) {
			throw new NotAuthorizedException(Response.status(Response.Status.UNAUTHORIZED));

		} catch (Exception e) {
			throw new InternalServerErrorException();
		}

	}

	private boolean isLoginRequest(ContainerRequestContext requestContext) {
		return requestContext.getUriInfo().getRequestUri().toString().endsWith("/ctrft/rest/login");
	}
	
	private void createEntityManager() {
		try {
			DatabaseUtil.getEntityManager();
		} catch (Exception e) {
			Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	

}
