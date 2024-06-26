package com.jd.basicauth.service;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jd.basicauth.entity.User;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String userid;

  private String email;

  @JsonIgnore
  private String pw;

  public UserDetailsImpl(Long id, String userid, String email, String pw
      ) {
    this.id = id;
    this.userid = userid;
    this.email = email;
    this.pw = pw;
  }

  public static UserDetailsImpl build(User user) {
  

    return new UserDetailsImpl(
        user.getId(), 
        user.getUserid(), 
        user.getEmail(),
        user.getPw()
        );
  }


  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return pw;
  }
  

  @Override
  public String getUsername() {
    return userid;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}
}