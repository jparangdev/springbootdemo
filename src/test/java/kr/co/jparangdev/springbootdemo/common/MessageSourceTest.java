package kr.co.jparangdev.springbootdemo.common;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
public class MessageSourceTest {

	@Autowired
	MessageSource messageSource;

	@Test
	void testMessage() {
		assertThat(messageSource.getMessage("message.test",null,null)).isEqualTo("??뭘까?");
	}

}
