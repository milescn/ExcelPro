package com.miles.dp.test;

import java.util.Map;
import java.util.Set;

import com.miles.dp.model.BpBusiModel;
import com.miles.dp.util.DbConnector;


public class BpModelTest {
	public static void main(String[] args) {
		DbConnector dc = new DbConnector();
		Map<String,String> result = dc.getLvlValue();
		
		Set<Map.Entry<String, String>> set = result.entrySet();
//
//		for(Map.Entry<String,String> s:set){
//			System.out.println(s.getKey()+":"+result.get(s.getKey()));
//		}
//		BaseIndex bi = new BaseIndex("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
//		BpIndexs bis = bi.getBpIndexs();
//		
//		List<IndexDes> allIndex = bis.getAllIndex();
//		int i =0;
//		int j =1;
//		for(IndexDes id : allIndex){
//			System.out.println("*******第 "+ j +" 个指标*****");
//			System.out.println("indexid："+ id.getIndexId());
//			System.out.println("indextype："+ id.getIndexType());
//			System.out.println("indexname："+ id.getIndexName());
//			System.out.println("formula："+ id.getFormula());
//			System.out.println("indicators："+ id.getIndicators());
//			System.out.println("indexorder："+ id.getIndexOrder());
//			System.out.println("iscity："+ id.getIsCity());
//			System.out.println("callvl："+ id.getCalLvl());
//			j++;
//			i++;
//		}
//
//		System.out.println("指标总数："+i);
//		System.out.println(bis.getMinLvl());
//		System.out.println(bis.getMaxLvl());
		 new BpBusiModel().getAllIndex("201212");
		// System.out.println("1".equals(String.valueOf(1)));
	}

}
