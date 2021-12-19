package kr.co.jparangdev.springbootdemo.biz.member.dto;

import kr.co.jparangdev.springbootdemo.biz.bookcart.domain.BookCart;
import kr.co.jparangdev.springbootdemo.biz.member.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchMemberDto {

	private String email;
	private String name;
	private String jobCode;

	public SearchMemberDto(String email, String name, String jobCode) {
		this.email = email;
		this.name = name;
		this.jobCode = jobCode;
	}

	public static SearchMemberDto from(Member member){
		return new SearchMemberDto(member.getEmail(), member.getName(), member.getJobCode().name());
	}

}
