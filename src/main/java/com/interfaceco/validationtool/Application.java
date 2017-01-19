package com.interfaceco.validationtool;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.interfaceco.validationtool.util.storage.StorageProperties;
import com.interfaceco.validationtool.util.storage.StorageService;


@SpringBootApplication
@EnableJpaAuditing
@EnableBatchProcessing
@EnableConfigurationProperties(StorageProperties.class)
@ImportResource("classpath:batch/job.xml")
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    PasswordEncoder encoder = new BCryptPasswordEncoder();
	    return encoder;
	}
//	@Autowired
//	private DataSource dataSource; 
	
	
	// Was already available by spring boot LOL
//	@Bean
//	JdbcTemplate jdbcTemplateInit(DataSource dataSource) { 
//		return new JdbcTemplate(dataSource); 
//	}
}
