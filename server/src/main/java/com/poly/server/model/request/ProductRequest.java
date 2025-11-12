package com.poly.server.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    // add & update

    private Long id;

    private String productCode;

    private String productName;

    private Double price;

    private Long categoryId;

}