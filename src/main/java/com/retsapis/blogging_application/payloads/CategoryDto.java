package com.retsapis.blogging_application.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min = 4, message = "Min length of category title is 4")
    private String categoryTitle;

    @Size(min = 10, message = "Min length of category description is 10")
    private String categoryDescription;


}
