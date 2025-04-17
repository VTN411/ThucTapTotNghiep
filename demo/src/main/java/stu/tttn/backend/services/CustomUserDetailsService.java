package stu.tttn.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import stu.tttn.backend.dao.EmployeeRepository;
import stu.tttn.backend.model.Employee;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeRepository nhanVienRepo;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Employee nv = nhanVienRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy nhân viên"));

        return new org.springframework.security.core.userdetails.User(
                nv.getEmail(),
                nv.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + nv.getRole().toUpperCase()))
        );
    }
}

