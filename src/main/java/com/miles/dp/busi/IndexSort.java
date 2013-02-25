package com.miles.dp.busi;

import java.util.HashMap;
import java.util.Map;

import com.miles.dp.entity.IndexDes;
import com.miles.dp.util.BaseIndex;
import com.miles.dp.util.DataToDb;

public class IndexSort extends IndexCalculator {

	@Override
	public Map<String, String> indexCal(String dataId, IndexDes index) {
		// 排序算法		
		BaseIndex bi= new BaseIndex("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
		Map index_values =  new HashMap();
		index_values = bi.getSortIndex(dataId, index);
		int i=1;
		Map target_values = bi.sortByValue(index_values);
		index_values.clear();
		for(Object s :target_values.keySet()){
			index_values.put(index.getIndexId()+","+(String)s, String.valueOf(i));
			//System.out.println(i+". "+"key:"+(String)s+" value:"+(String)target_values.get(s));
			i++;
		}
		index_values.put(index.getIndexId()+",0000", "-");
		//DataToDb.inDb(dataId, index_values);
		return index_values;
	}

}
