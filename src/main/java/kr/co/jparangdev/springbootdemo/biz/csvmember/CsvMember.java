package kr.co.jparangdev.springbootdemo.biz.csvmember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Getter
public class CsvMember {


  private String name;
  private List<String> hobby = new ArrayList<>();
  private String desc;

  public static CsvMember from(String line) {
    String[] info = line.split(",");
    String name = info[0].trim();
    String desc = info[2].trim();
    List<String> hobby = Arrays.stream(info[1].split(":")).map(s -> s.trim())
        .collect(Collectors.toList());
    return new CsvMember(name, hobby, desc);
  }

  public int searchKeywordCount(String keyword) {
    if (this.desc == null || this.desc.equals("")) {
      return 0;
    }
    int len = this.desc.length();
    int diffLen = this.desc.replaceAll(keyword, "").length();
    return (len - diffLen) / keyword.length();
  }


}
