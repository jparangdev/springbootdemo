package kr.co.jparangdev.springbootdemo.biz.bookCart.vo;

import kr.co.jparangdev.springbootdemo.biz.book.vo.Book;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor
public class BookCart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long seq;

}
