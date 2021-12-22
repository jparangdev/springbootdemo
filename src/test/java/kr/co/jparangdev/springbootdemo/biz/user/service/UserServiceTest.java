package kr.co.jparangdev.springbootdemo.biz.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import kr.co.jparangdev.springbootdemo.biz.user.repository.UserRepository;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserServiceTest {

  @Autowired
  UserRepository userRepository;

  @Test
  void saveTest() {
    User user = new User("jparangdev", "jpd@email.com", "1234", "JB099");
    userRepository.save(user);
    userRepository.findAll().forEach(System.out::println);
    long result = userRepository.count();
    assertEquals(5l, result);
  }

  @Test
  void findByEmailTestNoMember() {
    Optional<User> user = userRepository.findByEmail("jpd@email.com");
    assertTrue(user.isEmpty());
  }

  @Test
  @DisplayName("이름검색 테스트")
  void searchListByName() {
    List<User> list = userRepository.findByNameContaining("이");
    list.forEach(System.out::println);
    assertEquals(2, list.size());
  }

  @Test
  @DisplayName("페이징 테스트")
  void pagingTest() {
    Pageable pageable = PageRequest.of(1, 5, Sort.by(Sort.Direction.DESC, "email"));
    Page<User> list = userRepository.findAll(pageable);
    list.forEach(System.out::println);
    assertEquals(5l, list.getTotalElements());
  }


}