package kr.co.jparangdev.springbootdemo.biz.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UpdateMemberForm {

	private long id;

	@Email
	private String email;

	@NotBlank
	private String name;

	@NotBlank
	private String jobCode;

}
