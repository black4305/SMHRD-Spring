package kr.cloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//수많은 기능을 내포하고 있는 어노테이션
// 그 중에서 중요한 몇가지 기능 
// 1) @ComponentScan : @Controller, @RestController,
//                     @Service, @Repository클래스 파일들을
//                      자동으로 스캔해서 메모리에 저장하는 역할
// 2) @SpringBootConfiguration : 스프링 부트 환경설정해주는 역할
//      --> Application.properties
// 3) @EnableAutoConfiguration : 일반 환경설정이 아니라
//            추가적으로 필요한 다른 역할(파일 업로드)을 하는 
//             클래스 파일을 설치함
//     ex) 파일 업로드 시, multipartRequest등
@SpringBootApplication
public class SpringBoot1Application {
	// @SpringBootApplication 어노테이션 + 메인 메서드
	//  실행 -> 내장된 톰캣 실행!
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

}
