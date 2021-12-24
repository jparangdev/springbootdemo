package kr.co.jparangdev.springbootdemo.biz.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateMemberForm {

	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank(message = "{message.test}")
	private String name;

	@NotBlank
	private String jobCode;

}
