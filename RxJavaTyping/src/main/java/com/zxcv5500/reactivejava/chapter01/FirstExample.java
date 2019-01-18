package com.zxcv5500.reactivejava.chapter01;

import io.reactivex.Observable;

public class FirstExample {
	
	
	/**
	 * 어떤 것을 내보내다라는 뜻
	 */
	public void emit() {
		Observable.just("Hello", "RxJava 2!!")
				.subscribe(System.out::println);
	}
	
	public static void main(String[] args) {
		FirstExample demo = new FirstExample();
		demo.emit();
	}

}
