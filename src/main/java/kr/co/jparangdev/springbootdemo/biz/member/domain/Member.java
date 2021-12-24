package kr.co.jparangdev.springbootdemo.biz.member.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import kr.co.jparangdev.springbootdemo.biz.cart.Cart;
import kr.co.jparangdev.springbootdemo.biz.member.dto.CreateMemberForm;
import kr.co.jparangdev.springbootdemo.biz.member.dto.UpdateMemberForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private JobCode jobCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Cart cart;

    @Builder
    public Member(String name, String email, String password,
        JobCode jobCode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.jobCode = jobCode;
    }

    public static Member from(CreateMemberForm memberForm) {
        return Member.builder()
            .name(memberForm.getName())
            .email(memberForm.getEmail())
            .password(memberForm.getPassword())
            .jobCode(JobCode.valueOf(memberForm.getJobCode()))
            .build();
    }

    public void modifyMember(UpdateMemberForm memberForm) {
        if(!name.equals(memberForm.getName())) {
            name = memberForm.getName();
        }
        if(!email.equals(memberForm.getEmail())) {
            email = memberForm.getEmail();
        }
        if(jobCode != JobCode.valueOf(memberForm.getJobCode())) {
            jobCode = JobCode.valueOf(memberForm.getJobCode());
        }
    }

}
