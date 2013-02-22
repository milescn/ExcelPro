package com.miles.dp.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputDate = "201212";
		//SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");


//		Calendar ca = Calendar.getInstance();
//	      int year = ca.get(Calendar.YEAR);//获取年份
//	      int month=ca.get(Calendar.MONTH);//获取月份 
//	      int day=ca.get(Calendar.DATE);//获取日
//	      int minute=ca.get(Calendar.MINUTE);//分 
//	      int hour=ca.get(Calendar.HOUR);//小时 
//	      int second=ca.get(Calendar.SECOND);//秒
//	      int WeekOfYear = ca.get(Calendar.DAY_OF_WEEK); 
//	      
//	      
//	      System.out.println("用Calendar.getInstance().getTime()方式显示时间: " + ca.getTime());
//	      System.out.println("用Calendar获得日期是：" + year +"年"+ month +"月"+ day + "日");
//	      
//	      System.out.println("用Calendar获得时间是：" + hour +"时"+ minute +"分"+ second +"秒");
//	      System.out.println(WeekOfYear);//显示今天是一周的第几天（我做的这个例子正好是周二，故结果显示2，如果你再周6运行，那么显示6）
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.MONTH, -1);
//		Date date = calendar.getTime();
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
//		String sDateSuffix = dateformat.format(date);
//		//System.out.println(calendar.get(Calendar.MONTH));
//		System.out.println("[+]sDateSuffix:"+sDateSuffix);
//		System.out.println("[+]return:"+sDateSuffix.substring(0,6));
//		Calendar calendar = Calendar.getInstance();
//		     calendar.add(Calendar.DATE, -1);    //得到前一天
//		     calendar.add(Calendar.MONTH, -1);    //得到前一个月
//		     int year = calendar.get(Calendar.YEAR);
//		     int month = calendar.get(Calendar.MONTH)+1; 
		
		
//		Date now = new Date(); 
//	      Calendar cal = Calendar.getInstance(); 
//	      
//	      DateFormat d1 = DateFormat.getDateInstance(); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
//	      String str1 = d1.format(now);
//	      DateFormat d2 = DateFormat.getDateTimeInstance(); 
//	      String str2 = d2.format(now); 
//	      DateFormat d3 = DateFormat.getTimeInstance(); 
//	      String str3 = d3.format(now); 
//	      DateFormat d4 = DateFormat.getInstance(); //使用SHORT风格显示日期和时间
//	      String str4 = d4.format(now);
//
//	      DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，时间（精确到秒）
//	      String str5 = d5.format(now);
//	      DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
//	      String str6 = d6.format(now);
//	      DateFormat d7 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，时间（精确到分）
//	      String str7 = d7.format(now);
//	      DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）
//	      String str8 = d8.format(now);//与SHORT风格相比，这种方式最好用
//
//	 
//
//
//	      
//	      System.out.println("用Date方式显示时间: " + now);//此方法显示的结果和Calendar.getInstance().getTime()一样
//	      
//	      
//	      System.out.println("用DateFormat.getDateInstance()格式化时间后为：" + str1);
//	      System.out.println("用DateFormat.getDateTimeInstance()格式化时间后为：" + str2);
//	      System.out.println("用DateFormat.getTimeInstance()格式化时间后为：" + str3);
//	      System.out.println("用DateFormat.getInstance()格式化时间后为：" + str4);
//	      
//	      System.out.println("用DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL)格式化时间后为：" + str5);
//	      System.out.println("用DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG)格式化时间后为：" + str6);
//	      System.out.println("用DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT)格式化时间后为：" + str7);
//	      System.out.println("用DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM)格式化时间后为：" + str8);
//
//		DateFormat sdf=new SimpleDateFormat("yyyyMM");
//		Date date=null;
//		try {
//			date = sdf.parse("201301");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(date);
		
//		Calendar c = Calendar.getInstance();  
//	     Date date = null;  
//	        try {  
//	         date = new SimpleDateFormat("yyyyMM").parse("201301");  
//	       } catch (ParseException e) {  
//	           e.printStackTrace();  
//	       }  
//	        System.out.println(date);
//	       c.setTime(date);  
//	       c.add(Calendar.MONTH, -1); 
//	       String monthBefore = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
//	       System.out.println(monthBefore.substring(0,6)  ); 
	       
	       Calendar c = Calendar.getInstance();  
		     Date date = null;  
		        try {  
		         date = new SimpleDateFormat("yyyyMM").parse("201301");  
		       } catch (ParseException e) {  
		           e.printStackTrace();  
		       }  
		        //System.out.println(date); 
		       c.setTime(date);  
		       //c.add(Calendar.MONTH, 0); 
		       String monthBefore = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
		       System.out.println(monthBefore.substring(0,4)+"01"  );
		
	}

}
