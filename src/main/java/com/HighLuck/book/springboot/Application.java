package com.HighLuck.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 메인 클래스
// 가장먼저 읽어오기 때문에 프로젝트 최상단에 위치함
// Web Application Server 를 사용하는 것은 '언제 어디섯나 같은 환경에서 스프링부트를 배포할 수 있다.'
@EnableJpaAuditing // JAP Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
