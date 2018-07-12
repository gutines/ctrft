package br.com.ctrft.util;

import javax.ws.rs.core.Response;

public class ResponseUtil {

	public static final Response serverError = Response.serverError().entity("Erro interno no servidor").build();
	public static final Response dataNotFound = Response.status(Response.Status.NOT_FOUND).entity("Dados não encontrado").build();
}
