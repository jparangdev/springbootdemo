package kr.co.jparangdev.springbootdemo.biz.csvmember;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvMemberService {

  CsvMemberRepository repository = new CsvMemberRepository();

  public void checkHobbyMember() throws IOException {
    List<CsvMember> members = repository.findAll();

    Map<String, Long> countMap = members.stream()
        .flatMap(m -> m.getHobby().stream())
        .collect(groupingBy(h -> h, counting()));
    countMap.entrySet().stream().forEach(c -> countMap.get(c).toString());

  }

  public void checkKeyword() throws IOException {
    List<CsvMember> members = repository.findAll();

    int result = members.stream()
        .mapToInt(m -> m.searchKeywordCount("좋아"))
        .sum();

    System.out.println(result);
  }
}
