package com.opendatadelaware.feede;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
//import java.util.logging.Logger;


@SpringBootApplication
public class FeeDeApplication {
	//private static final Logger LOGGER = Logger.getLogger(FeedeApplication.class.getName());
	@Autowired
	private Environment environment;

	@Bean
	public BasicDataSource dataSource() {

		String url = String.format("jdbc:mysql://%s:%s/%s",
						environment.getProperty("DB_URI"),
						environment.getProperty("DB_PORT"),
						environment.getProperty("MYSQL_DATABASE"));
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(url);
		ds.setUsername(environment.getProperty("MYSQL_USER"));
		ds.setPassword(environment.getProperty("MYSQL_PASSWORD"));
		return ds;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeeDeApplication.class, args);
	}
}
