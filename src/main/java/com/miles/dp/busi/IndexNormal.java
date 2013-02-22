package com.miles.dp.busi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miles.dp.entity.IndexDes;
import com.miles.dp.util.BaseIndex;
import com.miles.dp.util.DataToDb;

public class IndexNormal extends IndexCalculator {

	@Override
	public Map<String,String> indexCal(String dataId,IndexDes index) {
		// 算法方法
		Map<String,String> results = new HashMap<String,String>(); 
		List<String> citys = new ArrayList<String>();
		BaseIndex bi= new BaseIndex("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
		//求变量的值	并放入结果集	
			citys = bi.getCitys(index.getIsCity());
			for (Object city:citys){
				results.put(index.getIndexId()+","+ (String) city,bi.getExpValue(dataId, index,(String) city) );
			}		
		DataToDb.inDb(dataId, results);
		return results;
	}
}
