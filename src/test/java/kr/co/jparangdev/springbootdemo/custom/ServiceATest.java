package kr.co.jparangdev.springbootdemo.custom;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceATest {

	@InjectMocks
	ServiceA serviceA;

	@Mock
	ServiceB serviceB;

	@Test
	void 널포인터_확인() {
		given(serviceB.plus(any(), anyLong())).willReturn("2L");

		String answer = serviceA.methodA("String", 1L);

		assertThat(answer)
			.isEqualTo("2L Test");
	}

}