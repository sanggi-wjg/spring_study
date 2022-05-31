package com.example.spring_study.example.valid;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
public class Something {

    int id;

    @Min(value = 0)
    int limit;

    @NotEmpty
    String name;

    @Email
    String email;


}
