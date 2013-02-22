package com.miles.dp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getCylm(String dataId){
		
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -1); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,6) ; 
	}
	
	public static String getLycm(String dataId){
	
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -12); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,6) ; 
	}
	
	public static String getLye(String dataId){
		
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -12); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,4)+"12" ; 
	}
	
	public static String getCyf(String dataId){
		
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       //c.add(Calendar.MONTH, 0); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,4)+"01" ; 
	}
	
	public static String getCyflm(String dataId){  
	       return getCyf(dataId)+" and "+ getCylm(dataId) ; 
	}
	
	public static String getCyfcm(String dataId){  
	       return getCyf(dataId)+" and "+ dataId ; 
	}
	
	public static String getLyflycm(String dataId){  
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -12); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,4)+"01"+" and "+ getLycm(dataId) ;        
	}
	
	public static String getLlye(String dataId){
		
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -24); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,4)+"12" ; 
	}
	
	public static String getLylm(String dataId){
		
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -13); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,6) ; 
	}
	
	public static String getLyflylm(String dataId){
		
		Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yyyyMM").parse(dataId);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	        //System.out.println(date); 
	       c.setTime(date);  
	       c.add(Calendar.MONTH, -12); 
	       String result = new SimpleDateFormat("yyyyMMdd").format(c.getTime());  
	       return result.substring(0,4)+"01"+" and "+ getLylm(dataId) ;     
	}
	/** 
	    * 获得指定日期的前一天 
	    *  
	    * @param specifiedDay 
	     * @return 
	   * @throws Exception 
     */  

	public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数  
	      Calendar c = Calendar.getInstance();  
	     Date date = null;  
	        try {  
	         date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	       c.setTime(date);  
	        int day = c.get(Calendar.DATE);  
	        c.set(Calendar.DATE, day - 1);  
	 
	       String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c  
	               .getTime());  
	       return dayBefore;  
	   }  
	 
	   /** 
	    * 获得指定日期的后一天 
	    *  
	    * @param specifiedDay 
	    * @return 
	    */  
	   public static String getSpecifiedDayAfter(String specifiedDay) {  
	       Calendar c = Calendar.getInstance();  
	       Date date = null;  
	       try {  
	           date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
	       } catch (ParseException e) {  
	           e.printStackTrace();  
	       }  
	       c.setTime(date);  
	       int day = c.get(Calendar.DATE);  
	       c.set(Calendar.DATE, day + 1);  
	 
	       String dayAfter = new SimpleDateFormat("yyyy-MM-dd")  
	               .format(c.getTime());  
	       return dayAfter;  
	   }  


}
