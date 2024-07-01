package com.example.hilay_app.util.security;

import com.example.hilay_app.entity.Student;
import com.example.hilay_app.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("Student not found");
        }
        return new User(student.getUsername(), student.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}