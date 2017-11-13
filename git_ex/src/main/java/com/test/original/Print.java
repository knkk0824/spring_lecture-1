package com.test.original;

public class Print {
	
	private Calc calc=new Calc();
	
	public String sum(int a,int b){
		return "덧샘결과 : "+calc.sum(a, b);
	}
	public String sub(int a,int b){
		return "뺄샘결과 : "+calc.sub(a, b);
	}
	public String multi(int a,int b){
		return "곱샘결과 : "+calc.multi(a, b);
	}
	public String dev(int a,int b){
		return "나눗샘결과 : "+calc.dev(a, b);
	}
}
