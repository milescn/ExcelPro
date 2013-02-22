package com.miles.dp.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.miles.dp.busi.IndexNormal;
import com.miles.dp.entity.IndexDes;
import com.miles.dp.util.BaseIndex;

public class IndexNormalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IndexDes index = new IndexDes();
		index.setCalLvl("1");
		index.setFormula("#BP44004#/#BP44001#");
		index.setIndexId("BP44008");
		index.setIndexName("2G移动电话用户出账率");
		index.setIndexOrder("8");
		index.setIndexType("1");
		index.setIndicators("BP44004,BP44001");
		index.setIsCity("1");
		
//		IndexNormal in = new IndexNormal();
//		in.indexCal("201212", index);
		
		BaseIndex bi= new BaseIndex("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
		Map<String,String> index_values =  new HashMap<String,String>();
		index_values = bi.getSortIndex("201212", index);
		int i =1;
		for(String s :index_values.keySet()){
			System.out.println(i+". "+"key:"+s+" value:"+index_values.get(s));
			i++;
		}
		System.out.println("**********排序ing********");
		i=1;
		Map<Object,Object> target_values = sortByValue(index_values);
		index_values.clear();
		for(Object s :target_values.keySet()){
			index_values.put(index.getIndexId()+","+(String)s, String.valueOf(i));
			//System.out.println(i+". "+"key:"+(String)s+" value:"+(String)target_values.get(s));
			i++;
		}
		System.out.println("**********最终********");
		for(String s :index_values.keySet()){
			System.out.println("key:"+s+" value:"+index_values.get(s));
			i++;
		}
	}
	
	public  static Map sortByValue(Map map) { 

		//将键值赌赢的entryset放到链表中
		 List<String> list = new LinkedList(map.entrySet());
		 Collections.sort(list, new Comparator() { 
		 //将链表按照值得从大到小进行排序 
			 public int compare(Object o1, Object o2) { 
				 return ((Comparable)((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue()); 
				 } 
			 }); 
		  
		 Map result = new LinkedHashMap();  
		 for (Iterator it = list.iterator(); it.hasNext();) {
			 Map.Entry entry = (Map.Entry) it.next();
			 result.put(entry.getKey(), entry.getValue()); 
			 } 
		 return result; 
		 } 

}
