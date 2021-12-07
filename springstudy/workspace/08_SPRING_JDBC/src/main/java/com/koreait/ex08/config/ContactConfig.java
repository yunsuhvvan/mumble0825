package com.koreait.ex08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.koreait.ex08.repository.ContactRepository;
import com.koreait.ex08.service.ContactService;
import com.koreait.ex08.service.ContactServiceImpl;

@Configuration  // 나는 Bean을 만들어~
public class ContactConfig {

	
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("1111");
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate template() {   // 커넥션풀 정보가 들어가있다.
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		return template;
	}
	
	
	@Bean 
	public ContactRepository repository() { // ContactServiceImpl 에서 사용하기 위해서 bean으로 만듬..
		return new ContactRepository();
	}
	
	@Bean
	public ContactService service() {   // 인터페이스느 어차피 객체 생성안되니깐
		return new ContactServiceImpl(); // 아래 구현한 놈으로 ..!?
	}
}
