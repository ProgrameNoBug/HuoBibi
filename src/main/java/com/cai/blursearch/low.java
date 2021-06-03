package com.cai.blursearch;

import java.util.Comparator;

public class low implements Comparator<infor> {
	@Override
	public int compare(infor o1, infor o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getprice()-o2.getprice());
	}
}
