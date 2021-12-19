package kr.co.jparangdev.springbootdemo.common.exception;

public class MemberDuplicateException extends RuntimeException {
	public MemberDuplicateException(String message) {
		super(message);
	}
}
