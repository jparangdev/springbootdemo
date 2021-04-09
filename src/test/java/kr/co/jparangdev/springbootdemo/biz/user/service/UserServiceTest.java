package kr.co.jparangdev.springbootdemo.biz.user.service;

import kr.co.jparangdev.springbootdemo.biz.user.repository.UserRepository;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void saveTest() {
        User user = new User("카카로트","kakro@email.com","JB099");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }
}