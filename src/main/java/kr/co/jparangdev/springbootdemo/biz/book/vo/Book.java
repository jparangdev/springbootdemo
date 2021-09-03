package kr.co.jparangdev.springbootdemo.biz.book.vo;

import kr.co.jparangdev.springbootdemo.biz.user.vo.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;


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

    @ManyToOne(optional = false)
    @JoinTable(name="USER_BOOK",joinColumns = @JoinColumn(name = "seq"),inverseJoinColumns = @JoinColumn(name="seq"))
    private User user;

    @Builder
    public Book(String name, long publisher_seq, int price) {
        Assert.hasText(name,"name must be not empty");

        this.name = name;
        this.publisher_seq = publisher_seq;
        this.price = price;
    }


}
