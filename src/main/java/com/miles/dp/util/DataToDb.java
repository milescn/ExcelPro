package com.miles.dp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DataToDb {
	public static void inDb(String dataId,Map<String,String> map){
		DbConnector dc = new DbConnector();
		Connection con = dc.getConnection("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
		PreparedStatement ps = null;
        
		String sql =  "insert into mysql.dp_fact_calreport_data_test(timest,index_id,city_code,city_name,index_value)"
				+ "values(?,?,?,?,?)";
		System.out.println("DATATODB:"+sql);
		try {
			ps = con.prepareStatement(sql);
			for(String s:map.keySet()){
				ps.setString(1, dataId);
				ps.setString(2, s.split(",")[0]);
				ps.setString(3, s.split(",")[1]);
				ps.setString(4, "");
				ps.setString(5, map.get(s));
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
