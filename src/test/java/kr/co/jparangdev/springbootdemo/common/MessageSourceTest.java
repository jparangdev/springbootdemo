package kr.co.jparangdev.springbootdemo.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.FieldError;
import org.springframework.validation.MessageCodesResolver;

@SpringBootTest
public class MessageSourceTest {

	@Autowired
	MessageSource messageSource;

	@Test
	void testMessage() {
		assertThat(messageSource.getMessage("NotBlank.createMemberForm.name",null,null)).isEqualTo("이름1");
	}


	@Test
	void messageReloadTest() throws InterruptedException {
		System.out.println(messageSource.getMessage("NotBlank.name",null,null));
		Thread.sleep(20000);
		System.out.println(messageSource.getMessage("NotBlank.name",null,null));
		Thread.sleep(20000);
		System.out.println(messageSource.getMessage("NotBlank.name",null,null));

	}
}
