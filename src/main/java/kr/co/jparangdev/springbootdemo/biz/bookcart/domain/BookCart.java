package kr.co.jparangdev.springbootdemo.biz.bookcart.domain;

import javax.persistence.ManyToOne;

import kr.co.jparangdev.springbootdemo.biz.cart.Cart;
import kr.co.jparangdev.springbootdemo.biz.member.domain.Member;

public class BookCart {

	@ManyToOne
	private Member member;

	@ManyToOne
	private Cart cart;
}
