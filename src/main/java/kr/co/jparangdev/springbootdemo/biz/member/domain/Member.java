package kr.co.jparangdev.springbootdemo.biz.member.domain;

import kr.co.jparangdev.springbootdemo.biz.bookcart.domain.BookCart;
import kr.co.jparangdev.springbootdemo.biz.member.dto.MemberForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    BookCart bookCart;

    @Builder
    public Member(String name, String email, String password,
        JobCode jobCode) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.jobCode = jobCode;
    }

    public static Member from(MemberForm memberForm) {
        return Member.builder()
            .name(memberForm.getName())
            .email(memberForm.getEmail())
            .password(memberForm.getPassword())
            .jobCode(JobCode.valueOf(memberForm.getJobCode()))
            .build();
    }
}
