package kr.co.jparangdev.springbootdemo.biz.book.vo;

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
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long seq;

    private String name;
    private long publisher_seq;
    private int price;

    @Builder
    public Book(String name, long publisher_seq, int price) {
        Assert.hasText(name,"name must be not empty");

        this.name = name;
        this.publisher_seq = publisher_seq;
        this.price = price;
    }


}
