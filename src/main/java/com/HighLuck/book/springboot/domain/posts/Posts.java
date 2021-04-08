package com.HighLuck.book.springboot.domain.posts;

import com.HighLuck.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Entity class 에서 절대로 setter 함수를 만들지 않는다.
// setter 로 값을 바꾸지 않고 새로운 함수를 만들어서 바꾼다.
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    // Primary Key(=PK)필드
    // auto increment
    // pk 는 보통 long type 으로 사용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // table column 의 값을 정의하기 위해서 (안써도됨)
    @Column(length = 500, nullable = false)
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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}