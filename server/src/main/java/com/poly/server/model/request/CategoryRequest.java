package com.poly.server.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequest {

    // validate o request
    @NotBlank(message = "Code k duoc de trong")
    private String categoryCode;

    @NotBlank(message = "Name khong duoc de trong ")
    private String categoryName;

    // 400, 500(logic) => custom ma loi cua rieng minh
    // Ma code : 400
    // Mess code : Bad request
}
