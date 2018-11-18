package com.zxcv5500.reactivejava.chapter03;


import com.zxcv5500.reactivejava.common.CommonUtils;
import com.zxcv5500.reactivejava.common.Log;
import com.zxcv5500.reactivejava.common.MarbleDiagram;

import static com.zxcv5500.reactivejava.common.Shape.RED;
import static com.zxcv5500.reactivejava.common.Shape.YELLOW;
import static com.zxcv5500.reactivejava.common.Shape.GREEN;
import static com.zxcv5500.reactivejava.common.Shape.BLUE;
import static com.zxcv5500.reactivejava.common.CommonUtils.toInt;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapExample implements MarbleDiagram {
	@Override
	public void marbleDiagram() {
		String[] balls = { "1", "2", "3", "4", "5" };
		Observable<String> source = Observable.fromArray(balls)
				.map(ball->ball + "<>");
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	public void mapFunction() {
		Function<String, String> getDiamond = ball->ball + "<>";
		
		String[] balls = {RED, YELLOW, GREEN, BLUE};
		Observable<String> source = Observable.fromArray(balls)
				.map(getDiamond);
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	public void mappingType() {
		Function<String, Integer> getIndex = ball ->{
			switch(ball) {
			case "RED":		return toInt(RED);
			case "YELLOW":		return toInt(YELLOW);
			case "GREEN":		return toInt(GREEN);
			case "BLUE":		return toInt(BLUE);
			default:			return -1;
			}
		};
		
		String[] balls = {"RED", "YELLOW", "GREEN", "BLUE"};
		Observable<Integer> source = Observable.fromArray(balls)
				.map(getIndex);		// 명시적인 타입 변환없이 바로 사용할 수 있음.
		source.subscribe(Log::i);
		CommonUtils.exampleComplete();
	}
	
	public static void main(String[] args) {
		MapExample demo = new MapExample();
		demo.marbleDiagram();
		demo.mapFunction();
		demo.mappingType();
	}

}
