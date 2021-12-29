package kr.co.jparangdev.springbootdemo.biz.member.controller;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.jparangdev.springbootdemo.biz.member.dto.CreateMemberForm;
import kr.co.jparangdev.springbootdemo.biz.member.service.MemberService;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	MemberService memberService;

	ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}

	@Test
	void 맴버생성_빈벨리데이션_메세지() throws Exception {
		//given
		CreateMemberForm form = new CreateMemberForm();
		form.setEmail("j@j.j");
		form.setName("");
		form.setJobCode("JB001");
		form.setPassword("test");

		//when
		ResultActions res = mockMvc.perform(post("/member")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(form))
			.locale(Locale.KOREA));

		//then
		res.andDo(print())
			.andExpect(r->assertThat(r.getResolvedException())
				.isInstanceOf(MethodArgumentNotValidException.class)
			)
			.andExpect(jsonPath("$",equalTo("이름")));

	}



}
