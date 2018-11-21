package com.zxcv5500.reactivejava.chapter05;

import com.zxcv5500.reactivejava.common.CommonUtils;
import com.zxcv5500.reactivejava.common.Log;
import com.zxcv5500.reactivejava.common.MarbleDiagram;
import com.zxcv5500.reactivejava.common.Shape;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static com.zxcv5500.reactivejava.common.Shape.RED;
import static com.zxcv5500.reactivejava.common.Shape.YELLOW;
import static com.zxcv5500.reactivejava.common.Shape.GREEN;
import static com.zxcv5500.reactivejava.common.Shape.star;
import static com.zxcv5500.reactivejava.common.Shape.triangle;
import static com.zxcv5500.reactivejava.common.Shape.pentagon;

public class FlipExample implements MarbleDiagram {

	@Override
	public void marbleDiagram() {
		String[] objs = {star(RED), triangle(YELLOW), pentagon(GREEN) };
		Observable<String> source = Observable.fromArray(objs)
				.doOnNext(data->Log.v("Original data="+data))
				.subscribeOn(Schedulers.newThread())
				.observeOn(Schedulers.newThread())
				.map(Shape::flip);
		source.subscribe(Log::i);
		CommonUtils.sleep(1000);
		CommonUtils.exampleComplete();
	}
	
	/**
	 * 위 코드에서 observeOn 부분을 제거해본 메서드
	 */
	public void observeOnRemoved() {
		String[] objs = {star(RED), triangle(YELLOW), pentagon(GREEN)};
		Observable<String> source = Observable.fromArray(objs)
				.doOnNext(data->Log.v("Original data = " + data))
				.subscribeOn(Schedulers.newThread())
				//removed .observeOn(Schedulers.newThread())
				.map(Shape::flip);
		source.subscribe(Log::i);
		CommonUtils.sleep(500);
	}

	public static void main(String[] args) {
		FlipExample demo = new FlipExample();
//		demo.marbleDiagram();
		demo.observeOnRemoved();
	}

}
