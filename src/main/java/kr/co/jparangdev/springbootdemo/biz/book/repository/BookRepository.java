package kr.co.jparangdev.springbootdemo.biz.book.repository;

import kr.co.jparangdev.springbootdemo.biz.book.vo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
