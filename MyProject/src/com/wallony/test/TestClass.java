package com.wallony.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;


	public class TestClass {

		
		
		public static void main(String[] args){
			
			Calendar cal01JAN = Calendar.getInstance();
			Calendar cal31DEC = Calendar.getInstance();
			cal01JAN.set(Calendar.MONTH, 0);
			cal01JAN.set(Calendar.DAY_OF_MONTH, 1);
			cal31DEC.set(Calendar.MONTH, 11);
			cal31DEC.set(Calendar.DAY_OF_MONTH, 31);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
			for(int i = 2012;i>1997; i--){
				cal01JAN.set(Calendar.YEAR, i);
				cal31DEC.set(Calendar.YEAR, i);
				System.out.println("select count(*) from ja_news where creation_date BETWEEN (sysdate-"+dayBefore(cal01JAN)+") AND (sysdate-"+dayBefore(cal31DEC)+"); -- "+dateFormat.format(cal01JAN.getTime())+" TO "+dateFormat.format(cal31DEC.getTime())+"");
			}
			
			long a =  58602;
				 a+= 215686;
				 a+= 185813;
				 a+= 131345;
				 a+= 121043;
				 a+= 139694;
				 a+= 144561;
				 a+= 151730;
				 a+=  74429;
				 System.out.println(a);
		}
		
		private static long dayBefore(Calendar calendar){
			
			long fark = System.currentTimeMillis()-calendar.getTimeInMillis();
			long oneday = 1000*60*60*24;
			
			
			return (fark/oneday)+1;
		}
	}   
/*
 * */
 