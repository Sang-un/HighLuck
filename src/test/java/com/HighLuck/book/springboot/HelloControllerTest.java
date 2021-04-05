package com.HighLuck.book.springboot;

// import com.HighLuck.book.springboot.web.HelloController;

import com.HighLuck.book.springboot.config.auth.SecurityConfig;
import com.HighLuck.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class) // 스프링부트와 JUnit 사이에 연결자 역할
//@WebMvcTest(controllers = HelloController.class) // controller 위주의 webMVC에 집중하게 하는 어노테이션
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; // 웹 api를 테스트할때 사용
    // 테스트의 시작점
    // 이 클래스가 http get, post 등의 api 테스트를 할수있게 해줌
    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 http get 요청을 함
        // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언 가능
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())         // 결과를 검증, 200인지 검증
                .andExpect(content().string(hello)); // hello로 결과를 받는지 아닌지 검사
    }
    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
