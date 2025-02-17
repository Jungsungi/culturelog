package jsg.culturelog.controller;

import jsg.culturelog.domain.Member;
import jsg.culturelog.domain.dto.MemberDto;
import jsg.culturelog.domain.form.MemberAddForm;
import jsg.culturelog.domain.form.MemberEditForm;
import jsg.culturelog.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<String> addMember(@RequestBody @Validated MemberAddForm form, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("error", HttpStatusCode.valueOf(400));
        }

        Member addMember = memberService.addMember(form);
        if (addMember.getId() != null) {
            return new ResponseEntity<>("success", HttpStatusCode.valueOf(200));
        }

        return new ResponseEntity<>("fail" ,HttpStatusCode.valueOf(400));
    }

    @GetMapping("/{memberId}")
    public MemberDto getMember(@PathVariable("memberId") Long memberId) {
        return memberService.getMemberInfo(memberId);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable("memberId") Long memberId) {
        memberService.deleteMember(memberId);
        MemberDto member = memberService.getMemberInfo(memberId);
        if (member.getUseAt().equals("Y")) {
            return new ResponseEntity<>("fail", HttpStatusCode.valueOf(400));
        }

        return new ResponseEntity<>("success" , HttpStatusCode.valueOf(200));
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editMember(@RequestBody @Validated MemberEditForm form, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("error", HttpStatusCode.valueOf(400));
        }
        Member member = memberService.editMember(form);
        return new ResponseEntity<>("success", HttpStatusCode.valueOf(200));
    }
}
