package com.poly.server.model.response;

import com.poly.server.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    // liet ke cac truong tra ve
    private Long id;

    private String code;

    private String name;

    // Mapping tu entity -> response
    public CategoryResponse(Category cate) {
        this.id = cate.getId();
        this.code = cate.getCategoryCode();
        this.name = cate.getCategoryName();
    }
}
