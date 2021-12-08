package com.koreait.ex10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.ex10.repository.NoticeRepository;
import com.koreait.ex10.service.NoticeService;
import com.koreait.ex10.service.NoticeServiceImple;

@Configuration
public class NoticeConfig {

	@Bean    // bean으로 등록을 해두어야 Autowired를 통해서 메소드를 사용할 수 있다
			// bean으로 생성되면 singleton 사용 가능..?
	public NoticeRepository repository() {  // using for service
		return new NoticeRepository();
	}
	
	
	@Bean   //NoticeService는 객체 생성이 안되기 때문에
			// NoticeService를 구현한 Imple을 반환.
	public NoticeService service() {  // using for controller 
		return new NoticeServiceImple();
	}
	
}
