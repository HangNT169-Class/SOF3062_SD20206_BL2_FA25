package com.poly.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaiKhoan {

    private String username;

    private String password;

    private String role; // ADMIN/ USER

}
