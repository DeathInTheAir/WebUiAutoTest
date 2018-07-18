package com.uiframe.samples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ggg {

	public static void main(String[] args) {
//		pri("aaa");
//		pri();
		pri("aaa","bbb");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        System.out.println(dateStr);
	}
	
	public static void pri(String... name){
//		for(String n:name)
			System.out.println(name[1]);
	}

}
