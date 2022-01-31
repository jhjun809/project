package com.bitc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bitc.interceptor.LoginCheckInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor())
		.addPathPatterns("/")
		.excludePathPatterns("teamTwo/**");
//		addPathPatterns("패턴") : 인터셉터를 사용할 컨트롤러 선택
//		excludePathPatterns("주소") : 인터셉터를 미적용할 컨트롤러 선택

	}

	// 사진
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);
		return commonsMultipartResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		사진 경로 지정하기
		//집                              										             		`       
//		registry.addResourceHandler("/newsImages/**").addResourceLocations("file:///C:/workspace/teamTw00/newsImages/");
//		registry.addResourceHandler("/goodsImages/**").addResourceLocations("file:///C:/workspace/teamTw00/goodsImages/");
//		registry.addResourceHandler("/boardImages/**").addResourceLocations("file:///C:/workspace/teamTw00/boardImages/");
//		registry.addResourceHandler("/noticeImages/**").addResourceLocations("file:///C:/workspace/teamTw00/noticeImages/");
//		registry.addResourceHandler("/squadImages/**").addResourceLocations("file:///C:/workspace/teamTw00/squadImages/");
		registry.addResourceHandler("/newsImages/**").addResourceLocations("file:///C:/Users/ki612/Documents/카카오톡 받은 파일/01241835/newsImages/");
		registry.addResourceHandler("/goodsImages/**").addResourceLocations("file:///C:/Users/ki612/Documents/카카오톡 받은 파일/01241835/goodsImages/");
		registry.addResourceHandler("/boardImages/**").addResourceLocations("file:///C:/Users/ki612/Documents/카카오톡 받은 파일/01241835/boardImages/");
		registry.addResourceHandler("/noticeImages/**").addResourceLocations("file:///C:/Users/ki612/Documents/카카오톡 받은 파일/01241835/noticeImages/");
		registry.addResourceHandler("/squadImages/**").addResourceLocations("file:///C:/Users/ki612/Documents/카카오톡 받은 파일/01241835/squadImages/");
		
		
		/*
		 * registry.addResourceHandler("/images/**").addResourceLocations(
		 * "file:///C:/workspace/TeamTwo/images/");
		 */
		
		//학원
		/*
		 * registry.addResourceHandler("/images/**").addResourceLocations(
		 * "file:///C:/java/spring/TeamTwo/images/");
		 */
		// registry.addResourceHandler("/image/**").addResourceLocations("file:///C:/image/");
		// registry.addResourceHandler("/web/images/**").addResourceLocations("file:///C:/web/images/");
	}
}
