package kr.co.jparangdev.springbootdemo.biz.user.service;

import kr.co.jparangdev.springbootdemo.biz.user.repository.UserRepository;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> searchByName(String keyword){
        return userRepository.findByNameContaining(keyword);
    }

}
