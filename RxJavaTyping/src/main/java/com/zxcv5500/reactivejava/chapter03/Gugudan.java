package com.zxcv5500.reactivejava.chapter03;

import java.util.Scanner;

import io.reactivex.Observable;

public class Gugudan {

	public void plainJava() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		for (int row = 1; row <= 9; ++row) {
			System.out.println(dan + " * " + row + " = " + dan * row);
		}
		in.close();
	}
	
	public void reactiveV1() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		Observable<Integer> source = Observable.range(1, 9);
		source.subscribe(row->System.out.println(dan + " * " + row + " = " + dan * row));
		in.close();
	}
	
	public static void main(String[] args) {
		Gugudan demo = new Gugudan();
		demo.plainJava();
	}

}
