package com.poly.server.controller;

import com.poly.server.model.request.CategoryRequest;
import com.poly.server.model.response.CategoryResponse;
import com.poly.server.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// Restfull => JSON
@RequestMapping("/api/category-management")
@CrossOrigin(origins = "*") // cho phep FE truy cap vao cac API
public class CategoryController {
    // GET & POST & PUT & DELETE
    // GET: SELECT
    // POST: ADD
    // PUT: UPDATE
    // DELETE: DELETE
    // https://blog.vietnamlab.vn/restful-api-convention/

    @Autowired
    private CategoryService cateService;

    @GetMapping
    public List<CategoryResponse> hienThiDanhSach() {
        return cateService.getAll();
    }

    // C1: Path Variable
    @GetMapping("{id1}")
    public CategoryResponse detailCate(@PathVariable("id1") Long id) {
        return cateService.detail(id);
    }

    // C2: Request Param
    @GetMapping("detail")
    public CategoryResponse detailCate1(@RequestParam("id2") Long id) {
        return cateService.detail(id);
    }

    @DeleteMapping("remove/{id2}")
    public void removeCate1(@PathVariable("id2") Long id) {
        cateService.remove(id);
    }

    @DeleteMapping("remove")
    public void removeCate(@RequestParam("id2") Long id) {
        cateService.remove(id);
    }

    // Phan trang tu lam not
    @GetMapping("paging")
    public List<CategoryResponse> phanTrang(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return cateService.phanTrang(pageNo, pageSize).getContent();
    }

    // Buoi hom sau: Add & Update & Expection
    @PostMapping("add")
    public void addCate(@Valid @RequestBody CategoryRequest categoryRequest) {
        cateService.addCategory(categoryRequest);
    }
}
