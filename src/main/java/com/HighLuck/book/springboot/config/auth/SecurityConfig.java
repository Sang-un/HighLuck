package com.HighLuck.book.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import com.HighLuck.book.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해서 해당 옵션들을 disable 한다.
                .and()
                    .authorizeRequests()// url 별 권한 관리를 설정하는 옵션의 시작점 && 이것이 있어야 antMatchers 사용 가능
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // antMatchers 는 권한관리 대상을 지정하는 옵
                    .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL들을 나타냄
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 기능에 대한 여러 설정 진입점 + 로그아웃 성공시 "/" 주소로 이동함
                .and()
                    .oauth2Login()// Oauth2 로그인 진입점
                        .userInfoEndpoint()// OAuth2 로그인 성공 이후 사용자 정보를 가져올때의 설정들을 담당함
                            .userService(customOAuth2UserService); // 소셜로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록함
    }

}
// permitAll() 은 "/"등 지정된 URL 들을 전체열람 권한을 줌
// "/api/v1/**" 주소를 가진 API 는 USER 권한을 가진 사람만 가능하도록 함

// authenticated() 를 추가하여 나머지 URL 들은 모두 인증된 사용자들에게만 허용하게 함
