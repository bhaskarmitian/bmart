package com.bmart.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmartApplication {

//	@Value("{server.port}")
//	String httpsPort;
//	
//	@Value("{app.server.port}")
//	String httpPort;

	public static void main(String[] args) {
		SpringApplication.run(BmartApplication.class, args);
	}

	/*
	 * @Bean public ServletWebServerFactory servletContainer() { // Enable SSL
	 * Trafic TomcatServletWebServerFactory tomcat = new
	 * TomcatServletWebServerFactory() {
	 * 
	 * @Override protected void postProcessContext(Context context) {
	 * SecurityConstraint securityConstraint = new SecurityConstraint();
	 * securityConstraint.setUserConstraint("CONFIDENTIAL"); SecurityCollection
	 * collection = new SecurityCollection(); collection.addPattern("/*");
	 * securityConstraint.addCollection(collection);
	 * context.addConstraint(securityConstraint); } };
	 * 
	 * // Add HTTP to HTTPS redirect
	 * tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
	 * 
	 * return tomcat; }
	 * 
	 * private Connector httpToHttpsRedirectConnector() { Connector connector = new
	 * Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
	 * connector.setScheme("http"); // connector.setPort(8082);
	 * connector.setPort(8443); connector.setSecure(false);
	 * connector.setRedirectPort(8444); return connector; }
	 */
}
