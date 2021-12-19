package kr.co.jparangdev.springbootdemo.biz.member.service;

import kr.co.jparangdev.springbootdemo.biz.member.dto.MemberForm;
import kr.co.jparangdev.springbootdemo.biz.member.repository.MemberRepository;
import kr.co.jparangdev.springbootdemo.biz.member.domain.Member;
import kr.co.jparangdev.springbootdemo.common.constants.ExceptionMessage;
import kr.co.jparangdev.springbootdemo.common.exception.MemberDuplicateException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    void 조인() {
        MemberForm memberForm = new MemberForm();
        memberForm.setEmail("japrangdev_jpa@gmail...com");
        memberForm.setName("테스트 이메일");
        memberForm.setPassword("ssss");
        memberForm.setJobCode("JB001");

        Long joinMemberId = memberService.join(memberForm);

        Member findMember = memberRepository.findById(joinMemberId).orElseThrow(IllegalAccessError::new);
        assertThat(joinMemberId).isEqualTo(findMember.getId());
    }

    @Test
    void 조인_중복() {
        MemberForm memberForm = new MemberForm();
        memberForm.setEmail("japrangdev_jpa@gmail...com");
        memberForm.setName("테스트 이메일");
        memberForm.setPassword("ssss");
        memberForm.setJobCode("JB001");

        MemberForm memberForm2 = new MemberForm();
        memberForm2.setEmail("japrangdev_jpa@gmail...com");
        memberForm2.setName("중복 이메일");
        memberForm2.setPassword("ssss");
        memberForm2.setJobCode("JB001");

        memberRepository.save(Member.from(memberForm));

        assertThatThrownBy(() -> memberService.join(memberForm2))
            .isInstanceOf(MemberDuplicateException.class)
            .hasMessageContaining(ExceptionMessage.DUPLICATED_MEMBER_BY_EMAIL.getMessage());

    }




}