package kr.co.jparangdev.springbootdemo.biz.csvmember;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CsvMemberRepositoryTest {


  @Test
  void 읽기확인() throws IOException {

    CsvMemberRepository repository = new CsvMemberRepository();

    List<CsvMember> list = repository.findAll();

    list.forEach(System.out::println);

  }


}