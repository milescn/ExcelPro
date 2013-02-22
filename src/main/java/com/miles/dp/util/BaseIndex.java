package com.miles.dp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.miles.dp.entity.IndexDes;


public class BaseIndex {
	private String dbType;
	private String url;
	private String userName;
	private String userPwd;


	public BaseIndex(String dbType,String url,String userName,String userPwd){
		setDbType(dbType);
		setUrl(url);
		setUserName(userName);
		setUserPwd(userPwd);
	}


	public String getExpValue(String dataId,IndexDes index,String cityCode){
		String[] indicators = index.getIndicators().split(",");
		Map<String,String> indi_vals = new HashMap<String,String>(); 
		for(int i =0;i<indicators.length;i++){
			indi_vals.put(indicators[i], String.valueOf(getBaseIndex(dataId,indicators[i],cityCode)));
		}
		String[] fs = index.getFormula().split("#");
		StringBuffer sb = new StringBuffer();
		for (int i =0 ;i<fs.length;i++){			
			for (Object r:indi_vals.keySet()){
				if(fs[i].equals(r.toString())){
					fs[i] = (String)indi_vals.get(r);			
				}			
			}
			sb.append(fs[i]);
			//System.out.print(fs[i]);	
		}
		FormulaParser fp = new FormulaParser(sb.toString());
		System.out.println("数值表达式:"+sb.toString());
		return String.valueOf(fp.getResult());		
	}


	public String getAccuExpValue(String dataId,IndexDes index,String cityCode){
		String[] indicators = index.getIndicators().split(",");
		Map<String,String> indi_vals = new HashMap<String,String>(); 
		for(int i =0;i<indicators.length;i++){
			indi_vals.put(indicators[i], String.valueOf(getBaseIndexAccu(dataId,indicators[i],cityCode)));
		}
		String[] fs = index.getFormula().split("#");
		StringBuffer sb = new StringBuffer();
		for (int i =0 ;i<fs.length;i++){			
			for (Object r:indi_vals.keySet()){
				if(fs[i].equals(r.toString())){
					fs[i] = (String)indi_vals.get(r);			
				}			
			}
			sb.append(fs[i]);
			//System.out.print(fs[i]);	
		}
		FormulaParser fp = new FormulaParser(sb.toString());
		System.out.println("数值表达式:"+sb.toString());
		return String.valueOf(fp.getResult());		
	}


	public String getAccuAverExpValue(String dataId,IndexDes index,String cityCode){
		String[] indicators = index.getIndicators().split(",");
		Map<String,String> indi_vals = new HashMap<String,String>(); 
		for(int i =0;i<indicators.length;i++){
			indi_vals.put(indicators[i], String.valueOf(getBaseIndexAccuAver(dataId,indicators[i],cityCode)));
		}
		String[] fs = index.getFormula().split("#");
		StringBuffer sb = new StringBuffer();
		for (int i =0 ;i<fs.length;i++){			
			for (Object r:indi_vals.keySet()){
				if(fs[i].equals(r.toString())){
					fs[i] = (String)indi_vals.get(r);			
				}			
			}
			sb.append(fs[i]);
			//System.out.print(fs[i]);	
		}
		FormulaParser fp = new FormulaParser(sb.toString());
		System.out.println("数值表达式:"+sb.toString());
		return String.valueOf(fp.getResult());		
	}


	public Double getBaseIndex(String dataId,String Singelindex,String cityCode){
		double result ;
		if(Singelindex.contains("@")){
			result = getIndexValueWithDim(dataId,Singelindex,cityCode);
		}else{
			result = getIndexValueNoDim(dataId,Singelindex,cityCode);
		}
		return result;
	}


	public Double getBaseIndexAccu(String dataId,String Singelindex,String cityCode){
		 double result ;
		if(Singelindex.contains("@CYLM")&&"01".equals(dataId.substring(4, 6))){
			result = 0d;
			return result;
		}
		if(Singelindex.contains("@")){
			result = getIndexValueWithDim(dataId,Singelindex,cityCode);
		}else{
			result = getIndexValueNoDim(dataId,Singelindex,cityCode);
		}
		return result;
	}


	public Double getBaseIndexAccuAver(String dataId,String Singelindex,String cityCode){
		 double result ;
		if(Singelindex.contains("@CYFLM")&&"01".equals(dataId.substring(4, 6))){
			result = 0d;
			return result;
		}
		if(Singelindex.contains("@")){
			result = getIndexValueWithDim(dataId,Singelindex,cityCode);
		}else{
			result = getIndexValueNoDim(dataId,Singelindex,cityCode);
		}
		return result;
	}


	public double getIndexValueNoDim(String dataId,String index,String cityCode){


		DbConnector dc = new DbConnector();


		StringBuffer sb = new StringBuffer();
		sb.append("select index_value from mysql.dp_fact_calreport_data where timest = '"
					+ dataId +"' and index_id = '" + index + "' and city_code = '" +
					cityCode +"'");
		//dc.getValue(sb.toString(), dbType, url, userName, userPwd);
		System.out.println("取数SQL："+sb.toString());
		return dc.getValue(sb.toString(), dbType, url, userName, userPwd);
	}


	public double getIndexValueWithDim(String dataId,String index,String cityCode){
		DbConnector dc = new DbConnector();	
		String[] index_content = index.split("@");
		StringBuffer sb = new StringBuffer();
		sb.append("select index_value from mysql.dp_fact_calreport_data where index_id = '" + index + "' and city_code = '" +
				cityCode +"'"+getTimest(dataId,index_content[1]));


		return dc.getValue(sb.toString(), dbType, url, userName, userPwd);
	}


	public List<String> getCitys(String isCity){
		List<String> citys = new ArrayList<String>();
		DbConnector dc = new DbConnector();
		Connection con = null;  	
    	PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        if("1".equals(isCity)){
        	sql = "SELECT city_code FROM mysql.dp_code_city WHERE city_code <> '0001' ORDER BY sort_id";
        }else {
        	sql = "SELECT city_code FROM mysql.dp_code_city WHERE city_code = '0000' ORDER BY sort_id";
        }      
        StringBuffer sb = new StringBuffer(); 
        sb.append(sql);            
        con = dc.getConnection(dbType,url,userName,userPwd);
        try {
			ps = con.prepareStatement(sb.toString());
			rs =ps.executeQuery();
	        //SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
	        while(rs.next()){
	        	citys.add(rs.getString(1));
	        }
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
            dc.cleanup(con,ps,rs);
		}
		return citys;
	}


	public Map<String,String> getSortIndex(String dataId,IndexDes index){
		Map<String,String> results = new HashMap<String,String>();
		DbConnector dc =  new DbConnector();
		Connection con = null;  	
      	PreparedStatement ps = null;
        ResultSet rs = null;
        StringBuffer sb = new StringBuffer("SELECT city_code,index_value FROM mysql.dp_fact_calreport_data WHERE timest = '"+dataId+"' AND city_code <> '0000' and index_id = '"+
               index.getIndicators()+"'");
        con = dc.getConnection(dbType,url,userName,userPwd);
        try {
			ps = con.prepareStatement(sb.toString());
			rs =ps.executeQuery();
			while (rs.next()){
				results.put(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            dc.cleanup(con,ps,rs);
		}
		return results;
	}


	public String getTimest(String dataId,String symbol){
		StringBuffer sb = new StringBuffer();
		switch(symbol.toUpperCase()){
		case "CYLM":
			sb.append(" and timest = "+"'"+DateUtil.getCylm(dataId)+"'");
			break;
		case "LYCM":
			sb.append(" and timest = "+"'"+DateUtil.getLycm(dataId)+"'");
			break;
		case "LYE":
			sb.append(" and timest = "+"'"+DateUtil.getLye(dataId)+"'");
			break;
		case "CYF":
			sb.append(" and timest = "+"'"+DateUtil.getCyf(dataId)+"'");
			break;	
		case "CYFLM":
			sb.append(" and timest between "+"'"+DateUtil.getCyflm(dataId)+"'");
			break;
		case "CYFCM":
			sb.append(" and timest between "+"'"+DateUtil.getCyfcm(dataId)+"'");
			break;
		case "LYFLYCM":
			sb.append(" and timest between "+"'"+DateUtil.getLyflycm(dataId)+"'");
			break;
		case "LLYE":
			sb.append(" and timest = "+"'"+DateUtil.getLlye(dataId)+"'");
			break;
		case "LYFLM":
			sb.append(" and timest = "+"'"+DateUtil.getLyflylm(dataId)+"'");
			break;
		case "LYLM":
			sb.append(" and timest = "+"'"+DateUtil.getLylm(dataId)+"'");
			break;
		case "CYCM":
			sb.append(" and timest = "+"'"+dataId+"'");
			break;
		}


		return sb.toString();
	}


	public  Map<Object,Object> sortByValue(Map<Object,Object> map) { 


		//将键值赌赢的entryset放到链表中
		 List<Object> list = new LinkedList<Object>(map.entrySet());
		 Collections.sort(list, new Comparator() { 
		 //将链表按照值得从大到小进行排序 
			 public int compare(Object o1, Object o2) { 
				 return ((Comparable)((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue()); 
				 } 
			 }); 


		 Map<Object,Object> result = new LinkedHashMap<Object,Object>();  
		 for (Iterator it = list.iterator(); it.hasNext();) {
			 Map.Entry entry = (Map.Entry) it.next();
			 result.put(entry.getKey(), entry.getValue()); 
			 } 
		 return result; 
		 } 


	public String getDbType() {
		return dbType;
	}


	public void setDbType(String dbType) {
		this.dbType = dbType;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
}