package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.AccBalancePojo;

public class AccBalanceData {
	String getaccId="SELECT * FROM account";
	String getBalance="SELECT balance FROM account WHERE accountid=?";
	int i,accBalance;
	public String retriveBalance(AccBalancePojo a,Connection conn) throws SQLException {
		PreparedStatement pstmt=conn.prepareStatement(getaccId);
		ResultSet rs=pstmt.executeQuery(); 
		while(rs.next()){
			i=rs.getInt("accountid");
		}
		pstmt.close();
		rs.close();
		if(i==a.getAccountid()) {
			PreparedStatement pstmt1=conn.prepareStatement(getBalance);
			pstmt1.setInt(1, a.getAccountid());
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next()) {
				accBalance=rs1.getInt("balance");
			}
			pstmt1.close();
			rs1.close();
			String ac=Integer.toString(accBalance);
			return ac;
		}
		else {
			return "Entered accountid is invalid";
		}
	}
}
