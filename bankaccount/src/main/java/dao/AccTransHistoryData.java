package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.AccDepositPojo;
import pojo.AccTransHistoryPojo;

public class AccTransHistoryData {
	int id;
	List<Integer> list1=new ArrayList<>();
	List<Object> list=new ArrayList<>();
	List<Object> list2=new ArrayList<>();
	String accountid="SELECT * FROM account";
	String acctrans="SELECT * FROM transaction WHERE account_id=?";
	public List<Object> transactionHistory(AccDepositPojo a,Connection conn) throws SQLException{
		list1.clear();
		list.clear();
		PreparedStatement pstmt=conn.prepareStatement(accountid);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			
			id=rs.getInt("accountid");
			list1.add(id);
		}
		pstmt.close();
		rs.close();
		System.out.println(list1);
		if(list1.contains(a.getAccountid())) {
			PreparedStatement pstmt1=conn.prepareStatement(acctrans);
			pstmt1.setInt(1, a.getAccountid());
			ResultSet rs1=pstmt1.executeQuery();
			while(rs1.next()) {
				
				AccTransHistoryPojo ap=new AccTransHistoryPojo(rs1.getInt("transactionid"),rs1.getInt("account_id"),rs1.getInt("amount"),rs1.getString("transactiontype"),rs1.getDate("date"));
				list.add(ap);
			}
			pstmt1.close();
			rs1.close();
			return list;
		}
		else {
			list2.clear();
			String strt="entered id is invalid";
			list2.add(strt);
			return list2;
		}
		
	}
}
