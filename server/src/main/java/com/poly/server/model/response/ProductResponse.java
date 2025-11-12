package com.poly.server.model.response;

import com.poly.server.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    // product Code; product Name, Price, Cate Code, Cate Name
    private String pCode;
    private String pName;
    private Double price;
    private String cateCode;
    private String name;

    public ProductResponse(Product p) {
        this.pCode = p.getProductCode();
        this.pName = p.getProductName();
        this.price = p.getPrice();
        // JOIN
        this.cateCode = p.getCategory().getCategoryCode();
        this.name = p.getCategory().getCategoryName();
    }
}
