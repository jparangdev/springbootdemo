package kr.co.jparangdev.springbootdemo.biz.user.repository;

import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
