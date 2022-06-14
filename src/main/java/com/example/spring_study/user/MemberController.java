package com.example.spring_study.user;

import com.example.spring_study.user.dto.MemberDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void initMember() {
        if (!memberService.isExistMemberByUsername("snow")) {
            MemberEntity newMember = memberService.createUser("snow", "123");
        }
        if (!memberService.isExistMemberByUsername("test")) {
            MemberEntity newMember = memberService.createUser("test", "123");
        }
    }

    @PostMapping("/members")
    public MemberEntity createUser(@RequestBody MemberEntity member) {
        return member;
    }


    @GetMapping("/members")
    public ResponseEntity<?> getUser(Pageable pageable, PagedResourcesAssembler<MemberDTO> assembler) {
        Page<MemberDTO> memberDTOS = memberService.findAllByPage(pageable);
        PagedModel<EntityModel<MemberDTO>> entityModels = assembler.toModel(memberDTOS);
        return ResponseEntity.ok(entityModels);
    }

}
