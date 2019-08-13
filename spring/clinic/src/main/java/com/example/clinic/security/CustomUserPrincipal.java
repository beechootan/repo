// package com.example.clinic.security;

// import java.util.Collection;

// import com.example.clinic.entities.Employee;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// @SuppressWarnings("serial")
// public class CustomUserPrincipal implements UserDetails {
// private Employee employee;

// public CustomUserPrincipal(Employee employee) {
// this.employee = employee;
// }

// @Override
// public String getUsername() {
// return user.getEmail();
// }

// @Override
// public Collection<? extends GrantedAuthority> getAuthorities() {
// return null;
// }

// public User getUser() {
// return employee;
// }

// @Override
// public String getPassword() {
// return employee.getPassword();
// }

// @Override
// public boolean isEnabled() {
// return true;
// }

// @Override
// public boolean isAccountNonExpired() {
// return true;
// }

// @Override
// public boolean isAccountNonLocked() {
// return true;
// }

// @Override
// public boolean isCredentialsNonExpired() {
// return true;
// }

// }