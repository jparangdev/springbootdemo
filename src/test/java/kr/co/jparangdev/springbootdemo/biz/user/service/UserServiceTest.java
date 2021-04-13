package kr.co.jparangdev.springbootdemo.biz.user.service;

import kr.co.jparangdev.springbootdemo.biz.user.repository.UserRepository;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import kr.co.jparangdev.springbootdemo.common.annotation.TimeCheck;
import kr.co.jparangdev.springbootdemo.common.constants.TimeEnum;
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
        User user = new User("jparangdev","jpd@email.com","JB099");
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }


}