package com.uiframe.samples;

public class TryAndCatch_return {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isTrue());
	}
	static boolean isTrue(){
		boolean frag = true;
		try{
			int i = 5/0;
		}catch(Exception e){
			frag = false;
		}
		return frag;
	}
}
