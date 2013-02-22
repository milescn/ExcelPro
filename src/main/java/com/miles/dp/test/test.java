package com.miles.dp.test;

import java.util.HashMap;
import java.util.Map;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String formula = "#a#-(#b#+#c#+#d#)/10000";
		String[] fs = formula.split("#");
		
		String a= "209";
		String b= "308";
		String c= "1234";
		String d= "224";
		Map results = new HashMap();
		results.put("a", a);
		results.put("b", b);
		results.put("c", c);
		results.put("d", d);
		
		
//		for (Object r:results.keySet()){
//			
//				System.out.println("get:"+(String)results.get(r));
//			}			
		
		for (int i =0 ;i<fs.length;i++){
		
				for (Object r:results.keySet()){
					//System.out.println("r:"+r.toString());
					if(fs[i].equals(r.toString())){
						fs[i] = (String)results.get(r);
						//System.out.println("get:"+(String)results.get(r));
					}			
		}
		
				System.out.print(fs[i]);
			
		}		
				
			

	}

}
