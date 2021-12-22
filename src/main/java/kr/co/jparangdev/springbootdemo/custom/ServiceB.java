package kr.co.jparangdev.springbootdemo.custom;

import org.springframework.stereotype.Service;

@Service
public class ServiceB {

	public String plus(String arg1, long arg2) {
		return arg1+arg2;
	}
}
