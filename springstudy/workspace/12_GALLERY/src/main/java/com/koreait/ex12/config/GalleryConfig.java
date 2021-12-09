package com.koreait.ex12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.ex12.service.GalleryService;
import com.koreait.ex12.service.GalleryServiceImpl;

@Configuration
public class GalleryConfig {

	
	@Bean
	public GalleryService service() {
		return new GalleryServiceImpl();
	}
	
	
	// 파일 첨부시 등록해둬야 할 Bean
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSizePerFile(1024 * 1024* 10);  //파일당 최대사이즈
		return multipartResolver; // 등록만 해두면 Spring이 사용한다.
	}
}
