package com.example.spring_study.member.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "이름은 필수 입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String password;

}
