package com.miles.dp.busi;

import java.util.Map;

import com.miles.dp.entity.IndexDes;

public abstract class IndexCalculator {
	//算法方法
	public abstract Map<String,String>  indexCal(String dataId,IndexDes index);

}
