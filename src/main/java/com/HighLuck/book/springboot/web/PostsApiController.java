package com.HighLuck.book.springboot.web;

import com.HighLuck.book.springboot.service.posts.PostsService;
import com.HighLuck.book.springboot.web.dto.PostsResponseDto;
import com.HighLuck.book.springboot.web.dto.PostsSaveRequestDto;
import com.HighLuck.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // localhost:8080/v1/posts
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // update 는 jpa 의 영속성 덕분에 database 에 접근하지 않아도 transaction 이 끝나는 시점에서 entity 를 저장하고 바꿔주기때문에 필요하지 않다!!! = dirty checking
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
