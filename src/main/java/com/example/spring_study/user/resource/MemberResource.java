package com.example.spring_study.user.resource;

import com.example.spring_study.user.MemberEntity;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
public class MemberResource extends RepresentationModel<MemberResource> {

    @JsonUnwrapped
    private MemberEntity memberEntity;

    public MemberResource(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }
}
