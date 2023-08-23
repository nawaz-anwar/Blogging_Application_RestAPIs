package com.retsapis.blogging_application.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories_data")
@Getter
@Setter
@NoArgsConstructor

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;

    @Column(name = "categoryTitle", length = 100, nullable = false)
    private String categoryTitle;

    private String categoryDescription;


}
