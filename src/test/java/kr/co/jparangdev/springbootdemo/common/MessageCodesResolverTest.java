package kr.co.jparangdev.springbootdemo.common;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.FieldError;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

	MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();


	@Test
	void MessageCodeResolversObject() {
		String[] messageCodes = messageCodesResolver.resolveMessageCodes("NotBlank","createMemberForm");
		for (String messageCode : messageCodes) {
			System.out.println("messageCode = " + messageCode);
		}
	}


	@Test
	void MessageCodesResolverField() {
		String[] messageCodes = messageCodesResolver.resolveMessageCodes("NotBlank", "createMemberForm", "name",String.class);
		for (String messageCode : messageCodes) {
			System.out.println("messageCode = " + messageCode);
		}


	}
}
