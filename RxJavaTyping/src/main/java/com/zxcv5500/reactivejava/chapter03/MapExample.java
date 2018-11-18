package com.zxcv5500.reactivejava.chapter03;


import com.zxcv5500.reactivejava.common.CommonUtils;
import com.zxcv5500.reactivejava.common.Log;
import com.zxcv5500.reactivejava.common.MarbleDiagram;

import io.reactivex.Observable;

public class MapExample implements MarbleDiagram {
	@Override
	public void marbleDiagram() {
		String[] balls = { "1", "2", "3", "4", "5" };
		Observable<String> source = Observable.fromArray(balls)
				.map(ball->ball + "<>");
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
