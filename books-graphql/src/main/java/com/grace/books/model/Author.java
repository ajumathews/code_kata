package com.grace.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author{

    private Integer id;
    private String firstName;
    private String lastName;

}
