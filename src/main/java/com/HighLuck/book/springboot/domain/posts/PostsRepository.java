package com.HighLuck.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// post class 로 database 에 접근시켜주는 Interface

// <entity type, pk class>
public interface PostsRepository extends JpaRepository<Posts, Long> {

    // 조회 할때 querydsl 을 추천함
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
