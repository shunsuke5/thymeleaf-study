package com.example.demo.data.person.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonCreateForm {

    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private int age;
}
