package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.exception.ApiException;
import com.poly.server.model.request.CategoryRequest;
import com.poly.server.model.response.CategoryResponse;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository cateRepository;

    public List<CategoryResponse> getAll() {
        // findAll
        return cateRepository.findAll()
                .stream()
                .map(CategoryResponse::new)
                .toList();
    }

    public void remove(Long id) {
        // id phai ton tai thi moi xoa
        cateRepository.findById(id).orElseThrow(
                () -> new ApiException("Id khong ton tai", "C01")
        );
        cateRepository.deleteById(id);
    }

    public CategoryResponse detail(Long id) {
        Category cate = cateRepository.findById(id).get();
        return new CategoryResponse(cate);
    }

    public Page<CategoryResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Category> pageProduct = cateRepository.findAll(pageable);
        // map tu Product => Product Response
        Page<CategoryResponse> pageResponse = pageProduct.map(CategoryResponse::new);
        return pageResponse;
    }

    public void addCategory(CategoryRequest request) {
        // minh can: Category
        // Co: request
        // => chuyen tu request -> entity
        Category cate = MapperUtil.map(request, Category.class);
        cateRepository.save(cate);
    }
}
