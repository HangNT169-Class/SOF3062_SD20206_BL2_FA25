package com.poly.server.security.service;

import com.poly.server.entity.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    /**
     * Spring security:
     * - authen: username & password: SELECT * FROM users WHERE username = ? AND password = ?
     * => 1 entity: TaiKhoan tuy nhien Srping security khong lam viec voi doi tuong trong entity: UserDetail
     * CHUYEN DOI TU: TAI KHOAN(TRONG CSDL -ENTITY) -> USERDETAIL (CAI CO SAN CUA SPRING SECURITY)
     * Khong muon dung truc tiep UserDetail => CustomerUserDetail
     * logic => service trong Security
     * Spring boot: ma hoa mat khau kieu bcry...
     */
//    123 -> abcdd => luu doan ma nay vao CSDL(doan mat khau da duoc ma hoa)

    @Autowired
    private PasswordEncoder passwordEncoder;

    // fake data
    private final List<TaiKhoan> listTaiKhoan = List.of(
            new TaiKhoan("user", "123456", "USER"),
            new TaiKhoan("admin", "123456", "ADMIN")
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // B1: Tim kiem tai khoan theo username: dung for thuong cung duoc
        TaiKhoan tk = listTaiKhoan.stream()
                .filter(s -> s.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Tai khoan khong ton tai"));
        // B2: Chuyen tai khoan -> UserDetails
        UserDetails userDetails = User.withUsername(tk.getUsername())
                .password(passwordEncoder.encode(tk.getPassword()))
                .roles(tk.getRole())
                .build();
        return userDetails;
    }
}
