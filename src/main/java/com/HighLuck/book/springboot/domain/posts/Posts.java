package com.HighLuck.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // lombok
@Entity // jpa
        // Entity class 에서 절대로 setter 함수를 만들지 않는다.
        // setter 로 값을 바꾸지 않고 새로운 함수를 만들어서 바꾼다.
public class Posts {
    @Id // Primary Key(=PK)필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id; // pk 는 보통 long type 으로 사용

    @Column(length = 500, nullable = false) // table column 의 값을 정의하기 위해서 (안써도됨)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
