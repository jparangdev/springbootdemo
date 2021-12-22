package kr.co.jparangdev.springbootdemo.biz.member.repository;

import kr.co.jparangdev.springbootdemo.biz.member.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    List<Member> findByNameContaining(String keyword);

    Page<Member> findAll(Pageable pageable);

    Page<Member> findByNameContaining(Pageable page, String keyword);
}
