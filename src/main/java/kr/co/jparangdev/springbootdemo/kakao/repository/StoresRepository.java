package kr.co.jparangdev.springbootdemo.kakao.repository;

import kr.co.jparangdev.springbootdemo.kakao.models.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoresRepository extends JpaRepository<Stores, Long> {

}



