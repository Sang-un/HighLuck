package com.HighLuck.book.springboot.web;

import com.HighLuck.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 json을 반환하는 컨트롤러로 만들어줌
public class HelloController {
    @GetMapping("/hello") // http 메소드인 get의 요청을 받을 수 있는 api
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto") // localhost:8080/hello/dto?name=test&amount=123
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
