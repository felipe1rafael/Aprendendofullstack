package com.back.Felipe.security.jwt;

import com.back.Felipe.Enum.ProfileEnum;
import com.back.Felipe.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    private  JwtUserFactory (){

    }

    public static JwtUser create(User user
    ){
        return  new JwtUser(
                user.getId(),
                user.getGmail(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getProfile())

        );
    }

    private  static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        return  authorities;
    }
    
}
