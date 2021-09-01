package kr.co.jparangdev.springbootdemo.biz.user.vo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
