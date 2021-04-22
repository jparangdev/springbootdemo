package kr.co.jparangdev.springbootdemo.biz.bookCart.vo;

import kr.co.jparangdev.springbootdemo.biz.book.vo.Book;
import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

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

    private User user;
    private Book book;

    public BookCart(User user, Book book) {
        this.user = user;
        this.book = book;
    }
}
