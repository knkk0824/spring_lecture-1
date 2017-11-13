package com.test.bean;

import com.test.original.Calc;

public class Calc2 extends Calc{

	@Override
	public int sum(int a, int b) {		
		return super.sum(a, b)+10000;
	}

	@Override
	public int sub(int a, int b) {
		return super.sub(a, b)+10000;
	}

	@Override
	public long multi(long a, int b) {
		return super.multi(a, b)+10000;
	}

	@Override
	public float dev(int a, int b) {
		return super.dev(a, b)+10000;
	}
	
	
}
