package com.poly.server.controller;

import com.poly.server.model.request.ProductRequest;
import com.poly.server.model.response.ProductResponse;
import com.poly.server.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product-management")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductResponse> hienThiDanhSach() {
        return service.getAll();
    }

    // C2: Request Param
    @GetMapping("detail")
    public ProductResponse detailCate1(@RequestParam("id2") Long id) {
        return service.detail(id);
    }

    @PostMapping("add")
    // @RequestBody <=> @ModelAttribute
    public void addCate(@Valid @RequestBody ProductRequest request) {
        service.add(request);
    }

    @PutMapping("update/{id}")
    public void updateCate(@Valid @RequestBody ProductRequest request, @PathVariable("id") Long id) {
        service.update(id, request);
    }

    @DeleteMapping("delete")
    public void deleteCate(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @GetMapping("paging")
    public List<ProductResponse> phanTrang(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return service.phanTrang(pageNo, pageSize).getContent();
    }

}