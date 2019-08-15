// package com.example.clinic.security;

// import com.example.clinic.entities.Employee;
// import com.example.clinic.repositories.EmployeeRepository;
// import com.example.clinic.security.CustomUserPrincipal;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContext;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// /**
// * UserDetailsService
// */
// @Service
// public class CustomUserDetailsService implements UserDetailsService {

// @Autowired
// private EmployeeRepository repository;

// // have to use the name loadUserByUsername due to old naming conventions
// @Override
// public EmployeeDetails loadUserByUsername(String email) {
// Employee employee = repository.findByEmail(email);

// if (user == null) {
// throw new UsernameNotFoundException(email);
// }
// return new CustomUserPrincipal(user);
// }

// public User getCurrentUser() {
// Object principal =
// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
// User currentUser = null;

// if (principal instanceof String) {
// String email = (String) principal;
// currentUser = repository.findByEmail(email);
// } else if (principal instanceof CustomUserPrincipal) {
// CustomUserPrincipal customPrincipal = (CustomUserPrincipal) principal;
// currentUser = customPrincipal.getUser();
// }

// return currentUser;
// }
// }
