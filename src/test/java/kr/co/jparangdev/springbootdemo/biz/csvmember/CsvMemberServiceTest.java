package kr.co.jparangdev.springbootdemo.biz.csvmember;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CsvMemberServiceTest {

  @Test
  void 취미별() throws IOException {
    CsvMemberService service = new CsvMemberService();

    service.checkHobbyMember();
  }

  @Test
  void 좋아수() throws IOException {
    CsvMemberService service = new CsvMemberService();

    service.checkKeyword();
  }

  @ParameterizedTest
  @CsvSource(value = {
      "좋아_좋아,,,좋아!!!,키키키키키:3"
      , " :0"
      , "ssssssssssss:0"
      , "좋좋좋아아아:1"
      , "whgdk    좋아        w아좋아:2"
      , "1좋아:1"
      , "11좋아:1"
      , "좋아좋아좋아:3"
  }, delimiterString = ":")
  void 문자열검색(String test, int result) {

    String keyword = "좋아";
    int answer = 0;
    if (test != null && !test.equals("")) {
      int prev = test.length();
      String replace = test.replaceAll(keyword, "");
      int cur = replace.length();
      answer = (prev - cur) / keyword.length();
    }

    assertThat(answer).isEqualTo(result);
  }

}