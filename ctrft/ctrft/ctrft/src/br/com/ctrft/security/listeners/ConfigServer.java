package br.com.ctrft.security.listeners;

import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.ctrft.database.DatabaseUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class ConfigServer implements ServletContextListener {

	private static SecretKey serverKey;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		DatabaseUtil.closeEntityManagerFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		generateServerKey();

	}

	public static SecretKey getServerKey() {
		return serverKey;
	}

	private void generateServerKey() {
		byte[] byteKey = Base64.getEncoder().encode(MacProvider.generateKey().getEncoded());
		serverKey = new SecretKeySpec(byteKey, SignatureAlgorithm.HS512.getJcaName());
	}

}
