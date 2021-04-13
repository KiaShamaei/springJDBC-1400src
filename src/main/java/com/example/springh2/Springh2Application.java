package com.example.springh2;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class Springh2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springh2Application.class, args);
	}
//@Bean 
//public DataSource getDataSource() {
//	return DataSourceBuilder.create()
//			.url("jdbc:oracl:thin:@localhost:1521:xe")
//			.username("ZSS")
//			.password("12")
//			.build();
//}
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    driverManagerDataSource.setUsername("ZSS");
	    driverManagerDataSource.setPassword("12");
	    return driverManagerDataSource;
	}

}
