package com.HighLuck.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // get method 를 만들어줌
@RequiredArgsConstructor // final 들의 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
