package com.back.Felipe.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class JwtUser implements UserDetails {
  private  static  final long serialVersionUID =-77712847812809L;

  private  final String id;
  private final String username;
  private final String passoword;
  private final Collection<? extends  GrantedAuthority> authorities;


    public JwtUser(String id, String username, String passoword, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.passoword = passoword;
        this.authorities = authorities;
    }

    @JsonIgnore
    @Override
    public  boolean isAccountNonExpired(){
        return  true;
    }

    @JsonIgnore
    @Override
    public  boolean isAccountNonLocked (){
        return true;
    }
    @JsonIgnore
    public boolean isCredetialNonExpired(){
        return  true;
    }

    public boolean isEnable(){
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
