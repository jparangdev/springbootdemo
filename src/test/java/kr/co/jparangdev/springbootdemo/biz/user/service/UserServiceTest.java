package kr.co.jparangdev.springbootdemo.biz.user.service;

import kr.co.jparangdev.springbootdemo.biz.user.repository.UserRepository;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void saveTest() {
        User user = new User("jparangdev","jpd@email.com","JB099");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
        long result = userRepository.count();
        assertEquals(5l,result);
    }

    @Test
    void findByEmailTestNoMember() {
        Optional<User> user = userRepository.findByEmail("jpd@email.com");
        assertTrue(user.isEmpty());
    }


}