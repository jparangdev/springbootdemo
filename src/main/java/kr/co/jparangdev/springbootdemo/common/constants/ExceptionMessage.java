package kr.co.jparangdev.springbootdemo.common.constants;

import org.springframework.http.HttpStatus;

public enum ExceptionMessage {
	DUPLICATED_MEMBER_BY_EMAIL("중복되는 이메일이 존재합니다.", HttpStatus.BAD_REQUEST),
	NO_MEMBER("고객 정보가 없습니다.",HttpStatus.NOT_FOUND);

	private final String message;
	private final HttpStatus status;

	ExceptionMessage(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
