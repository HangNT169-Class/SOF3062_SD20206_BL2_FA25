package com.poly.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaiKhoanController {

    // He thong gom 2 quyen chinh: Admin & User
    // /public/** => Tat ca moi quyen deu co the truy cap
    // /api/user/** => Quyen truy cap chi danh cho role la User
    // /api/admin/** => Quyen truy cap chi danh cho role la Admin

    @GetMapping("public/hien-thi")
    public String hienThiTatCaQuyen() {
        return "Tat ca quyen deu co the truy cap";
    }

    @GetMapping("api/admin/hien-thi")
    public String helloAdmin() {
        return "Chi admin duoc truy cap";
    }

    @GetMapping("api/user/hien-thi")
    public String helloUser() {
        return "Chi user duoc truy cap";
    }
}
