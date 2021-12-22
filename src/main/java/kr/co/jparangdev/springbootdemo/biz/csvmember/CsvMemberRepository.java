package kr.co.jparangdev.springbootdemo.biz.csvmember;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvMemberRepository {

  public List<CsvMember> findAll() throws IOException {
    Path path = Paths.get("src/test/resources/stream_exam.csv");
    BufferedReader bufferedReader = Files.newBufferedReader(path);
    List<CsvMember> result = bufferedReader.lines().skip(1).map(l -> CsvMember.from(l))
        .collect(Collectors.toList());

    return result;
  }

}
