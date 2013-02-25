package com.miles.dp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.miles.dp.busi.IndexAccu;
import com.miles.dp.busi.IndexAccuAver;
import com.miles.dp.busi.IndexNormal;
import com.miles.dp.busi.IndexSort;
import com.miles.dp.entity.BpIndexs;
import com.miles.dp.entity.IndexDes;
import com.miles.dp.util.BaseIndex;

public class BpBusiModel {
	public void getAllIndex(String dataId){
		BaseIndex bi = new BaseIndex("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
		BpIndexs bis = bi.getBpIndexs();
		Map<String, String> result_tmp = new HashMap<String,String>();
		Map<String, String> result = new HashMap<String,String>();
		List<IndexDes> allIndex = bis.getAllIndex();
		for(int i = bis.getMinLvl();i<= bis.getMaxLvl();i++){
			for(IndexDes index:allIndex){
				//System.out.println("index.getCalLvl()："+index.getCalLvl());
				if(index.getCalLvl().equals(String.valueOf(i))){
					switch(index.getIndexType()){
					case "1":
						System.out.println("case:1");
						result_tmp = new IndexNormal().indexCal(dataId,index);
						break;
					case "2":
						result_tmp = new IndexAccu().indexCal(dataId, index);
						break;
					case "3":
						result_tmp = new IndexAccuAver().indexCal(dataId, index);
						break;
					case "4":
						result_tmp = new IndexSort().indexCal(dataId, index);
						break;
					}
					result.putAll(result_tmp);
				}
			}	 
		}
		int i = 1;
		for(Map.Entry<String, String> data_row:result.entrySet()){
			System.out.println("第 "+ i +" 行数据："+" Key：" + data_row.getKey()+";Value: " + data_row.getValue());
			i++;
		}
		System.out.println("共 "+i+" 行数据！！");
	}

}
