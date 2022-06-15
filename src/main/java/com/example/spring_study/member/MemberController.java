package com.example.spring_study.member;

import com.example.spring_study.member.dto.MemberDTO;
import com.example.spring_study.member.form.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm memberForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/createMemberForm";
        }

        memberService.createUser(memberForm.getUsername(), memberForm.getUsername());
        return "redirect:/members";
    }


    @GetMapping("/members")
    public String list(Pageable pageable, Model model) {
        Page<MemberDTO> members = memberService.findAllByPage(pageable);
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
