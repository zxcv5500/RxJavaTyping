package com.zxcv5500.reactivejava.chapter02;

import java.util.concurrent.Callable;

import com.zxcv5500.reactivejava.common.CommonUtils;

import io.reactivex.Observable;

public class ObservableFromCallable {
	
	public void basic() {
		Callable<String> callable = ()->{
			Thread.sleep(1000);
			return "Hello Callable";
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
		CommonUtils.exampleComplete();
	}
	
	public void withoutLambda() {
		Callable<String> callable = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				return "Hello Callable2";
			}
		};
		
		Observable<String> source = Observable.fromCallable(callable);
		source.subscribe(System.out::println);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		ObservableFromCallable demo = new ObservableFromCallable();
		demo.basic();
		demo.withoutLambda();
	}

}
