package com.example.demo.data.product.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateForm {

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private int price;
}
