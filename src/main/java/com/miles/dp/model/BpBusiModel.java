package com.miles.dp.model;

import java.util.Map;

import com.miles.dp.util.DbConnector;

public class BpBusiModel {
	public void getAllIndex(){
		DbConnector dc = new DbConnector();
		Map<String,String> lvl = dc.getLvlValue();
	}

}
