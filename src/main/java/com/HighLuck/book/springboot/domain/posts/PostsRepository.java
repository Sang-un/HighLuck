package com.HighLuck.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// post class 로 database 에 접근시켜주는 Interface

// <entity type, pk class>
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
