package org.zeksa.springcore.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreAppServer {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringCoreAppServer.class, args);
	}
}