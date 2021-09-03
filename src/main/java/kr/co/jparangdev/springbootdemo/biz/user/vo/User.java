package kr.co.jparangdev.springbootdemo.biz.user.vo;

import kr.co.jparangdev.springbootdemo.biz.book.vo.Book;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long seq;

    private String name;
    private String email;
    private String password;
    private String job;

    @OneToMany
    private List<Book> bookList = new ArrayList<Book>();

    @Builder
    public User(String name, String email, String password, String job) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.job = job;
    }


    public User() {

    }
}
