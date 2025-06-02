package kr.cloud.web;

import org.springframework.boot.SpringApplication;
/*
 * 수 많은 기능을 내포하고 있는 annotation
 * 그 중에서 중요한 몇 가지 기능들
 * 1) Component Scan : @Controller, @Service @ResetController, @Repository 크래스 파일을 자동으로 스캔해서 메모리에 저장하는 역할
 * 2) SpringBoot Configuration : 스프링부트 환경설정해주는 역할
 * 3) Enable Auto Configuration : 일밚 환경설정이 아니라 추가적으로 필요한 다른 역할(파일 업로드)을 하는 클래스 파일을 설치함
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

}
