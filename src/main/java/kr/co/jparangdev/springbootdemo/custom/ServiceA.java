package kr.co.jparangdev.springbootdemo.custom;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceA {

	private final ServiceB serviceB;

	public String methodA(String arg, long arg2) {
		return serviceB.plus(arg,arg2)+" Test";
	}

}
