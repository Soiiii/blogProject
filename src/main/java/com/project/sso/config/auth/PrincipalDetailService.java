package com.project.sso.config.auth;

import com.project.sso.model.User;
import com.project.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PrincipalDetailService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    //스프링이 로그인 요청을 가로챌때 username, password 변수 2개를 가로채는데
    //password부분 처리는 알아서 함
    //username이 DB에 있는지만 확인해주면 됨 ->loadUserByUsername 함수에서 함
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자를 찾을수 없음:" + username);
                });
        //시큐리티 세션에 유저 정보가 저장이 됨
        return new PrincipalDetail(principal); //id:user, password:console창
    }

}
