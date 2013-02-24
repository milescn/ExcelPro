package com.miles.dp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
 

public class DbConnector {
	private String url ;
	private String userName = "";
	private String passWord = "";
 
    /**
 		从sqlserver 导出数据，将数据入库到oracle
     * 
 
     */
 
//    public static void main(String[] args) {
//    	//导出文件名
//        String fileName = "e:\\SqlServer.txt";
//        //分隔符
//        String separator = "|";
//        //导出数据的sql语句
//        String sql = "SELECT  id ,area,sb_code,sb_name,sb_port,customer_type,"+
//					          "customer_id,customer_name,qos_rank,speed_rate,"+
//					          "service_id,vlan,ip_net,ip_mask,ip_gateway,max_mac,"+
//					          "u_net,u_net_id,bas_ip,bas_int,epon_sn,port_tcp,people,"+
//					          "update_time,tip_1,tip_2,tip_3,tip_4,tip_5,tip_6,action,stat"+
//					 "  FROM  dbo.lan";
//        SqlServerToOracle sto= new SqlServerToOracle();
//        //数据导出到txt文本
//        boolean Success = false;
//        Success = sto.outdb(sql,fileName,separator);
//        //导入txt文本数据到ORACLE的sql语句
//        sql =  "insert into dbo.lan  (id,area,sb_code,sb_name,sb_port,customer_type,"+
//					 "customer_id,customer_name,qos_rank,speed_rate,"+
//					 "service_id,vlan,ip_net,ip_mask,ip_gateway,max_mac,"+
//					 "u_net,u_net_id,bas_ip,bas_int,epon_sn,port_tcp,people,"+
//					 "update_time,tip_1,tip_2,tip_3,tip_4,tip_5,tip_6,action,stat) " +
//					 "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
//        if(Success){
//        	 //数据导入到oracle数据库
//        	Success = sto.indb(sql, fileName, separator);
//        }else{
//        	System.out.println("SQLSERVER数据出库失败！！！！");
//        	return ;
//        }
//        if(Success){
//        	System.out.println("数据导入ORACLE成功！！！！");
//        }else{
//        	System.out.println("数据导入ORACLE失败！！！！");
//        }   
//    }
 
    public  Connection getConnection(String dbType,String url,String userName,String userPwd) 

    {
        Connection con = null;
        try {
			switch (dbType){
				case "Oracle":
					 Class.forName("oracle.jdbc.driver.OracleDriver"); 
					 break;
				case "MySql" :
					 Class.forName("com.mysql.jdbc.Driver");
					 break;	
				default :
					throw new RuntimeException("dbtype is not support or input wrong!");
			}
			con = DriverManager.getConnection(url,userName,userPwd);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        // 2、获得连接 
        if(con==null){
            throw new RuntimeException("Connection is null!");
        }
        return con;
    }
    
    public double getValue(String sql,String dbType,String url,String userName,String userPwd){
    	Connection con = null;  	
    	PreparedStatement ps = null;
        ResultSet rs = null;
        
        String result =null;     
        StringBuffer sb = new StringBuffer(); 
        sb.append(sql);            
        con = getConnection(dbType,url,userName,userPwd);
        try {
			ps = con.prepareStatement(sb.toString());
			rs =ps.executeQuery();
	        while(rs.next()){
	        	result = rs.getString(1);
	        }
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
            cleanup(con,ps,rs);
		}
        System.out.println("Connector链接数据库取值:"+sb.toString());
    	return Double.parseDouble(result);
    }
    
    public Map<String,String> getLvlValue(){
    	Connection con = null;  	
    	PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,String> result = new HashMap<String,String>();
        int result_tmp = 0;     
        con = getConnection("MySql","jdbc:mysql://localhost:3306/mysql","miles","12345");
        try {
			ps = con.prepareStatement("SELECT MIN(CONVERT(cal_lvl,DECIMAL(8,0))) FROM mysql.dp_code_calreport_param");
			rs =ps.executeQuery();
	        while(rs.next()){
	        	result_tmp = rs.getInt(1);
	        }
	        result.put("MIN", String.valueOf(result_tmp));
	        System.out.println("Connector链接数据库取得最低计算层级:"+result_tmp);
	        ps = con.prepareStatement("SELECT MAX(CONVERT(cal_lvl,DECIMAL(8,0))) FROM mysql.dp_code_calreport_param");
			rs =ps.executeQuery();
	        while(rs.next()){
	        	result_tmp = rs.getInt(1);
	        }
	        result.put("MAX", String.valueOf(result_tmp));
	        System.out.println("Connector链接数据库取得最高计算层级:"+result_tmp);
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
            cleanup(con,ps,rs);
		}
    	return result;
    	
    }
    
 
    public  void cleanup(Connection con, Statement stmt, ResultSet rs)
     {
        if (rs != null) {
            try {
            	rs.close();
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        }
        if (stmt != null) { 
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
