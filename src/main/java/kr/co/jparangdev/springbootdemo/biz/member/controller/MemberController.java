package kr.co.jparangdev.springbootdemo.biz.member.controller;

import kr.co.jparangdev.springbootdemo.biz.member.dto.MemberForm;
import kr.co.jparangdev.springbootdemo.biz.member.dto.SearchMemberDto;
import kr.co.jparangdev.springbootdemo.biz.member.service.MemberService;
import kr.co.jparangdev.springbootdemo.biz.member.domain.Member;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Long> joinMember(@Valid @RequestBody MemberForm memberForm) {
        Long joinMemberId = memberService.join(memberForm);
        return ResponseEntity.ok(joinMemberId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchMemberDto> findMemberById(@PathVariable("id") Long id) {
        Member findMember = memberService.findById(id);
        SearchMemberDto result = SearchMemberDto.from(findMember);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateMember(@RequestBody MemberForm memberForm) {
        Long updatedMemberId = memberService.update(memberForm);
        return ResponseEntity.ok(updatedMemberId);
    }
}
