package kr.co.jparangdev.springbootdemo.biz.user.repository;

import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByNameContaining(String keyword);

    Page<User> findAll(Pageable pageable);
}
