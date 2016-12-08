package org.zeksa.hibernate.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.zeksa.hibernate.labs"})
public class HibernateLabsAppServer {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(HibernateLabsAppServer.class, args);
	}
}