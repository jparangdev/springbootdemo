package kr.co.jparangdev.springbootdemo.biz.member.service;

import kr.co.jparangdev.springbootdemo.biz.member.dto.MemberForm;
import kr.co.jparangdev.springbootdemo.biz.member.repository.MemberRepository;
import kr.co.jparangdev.springbootdemo.biz.member.domain.Member;
import kr.co.jparangdev.springbootdemo.common.constants.ExceptionMessage;
import kr.co.jparangdev.springbootdemo.common.exception.MemberDuplicateException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(MemberForm memberForm) {
        validDuplication(memberForm.getEmail());
        Member member  = Member.from(memberForm);
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    public void validDuplication(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()) {
            throw new MemberDuplicateException(ExceptionMessage.DUPLICATED_MEMBER_BY_EMAIL.getMessage());
        }
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException(ExceptionMessage.NO_MEMBER.getMessage()));
    }

}
