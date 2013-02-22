package com.miles.dp.busi;

import com.miles.dp.entity.IndexDes;

public class DpContext {
	IndexCalculator ic;
	IndexDes index;
	String dataId;
	
	public DpContext(IndexCalculator ic,IndexDes index){
		this.ic = ic;
		this.index = index;
	}
	
	public void DpContextInterface(){
		ic.indexCal(dataId,index);
	}

}
