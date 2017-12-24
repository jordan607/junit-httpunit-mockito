package com.nt.service;

public class ArithmeticServiceImpl implements ArithmeticService {

	@Override
	public int add(int x, int y) {
		if(x==0 ||y==0)
			throw new IllegalArgumentException();
		return x+y;
	}

}
