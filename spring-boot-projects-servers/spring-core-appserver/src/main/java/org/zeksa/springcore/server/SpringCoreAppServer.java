package org.zeksa.springcore.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.zeksa.springcore"})
public class SpringCoreAppServer {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringCoreAppServer.class, args);
	}
}