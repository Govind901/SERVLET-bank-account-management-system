package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pojo.AccDepositPojo;

public class AccDepositData {
	int ac,i;
	int uid,balanc;
	String type="credit";
	List<Integer> list=new ArrayList<Integer>();
	String validateaccid="SELECT * FROM accountnum ";
	String deposit="UPDATE account SET balance=? WHERE accountid=?";
	String getBal="SELECT balance FROM account WHERE accountid=?";
	String getuesrid="SELECT user_id FROM users WHERE accountid=?";
	String trans="INSERT INTO transaction (account_id, transactiontype, amount, date) VALUES(?,?,?,?)";
	public String Deposits(AccDepositPojo a,Connection conn) throws SQLException {
		list.clear();
		PreparedStatement pstmt=conn.prepareStatement(validateaccid);
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			 i=rs.getInt("accountid");
			ac=rs.getInt("Accountnum");
			list.add(i);
		}
			if(list.contains(a.getAccountid())) {
				PreparedStatement pstmt2=conn.prepareStatement(getuesrid);
				pstmt2.setInt(1, a.getAccountid());
				ResultSet rs2=pstmt2.executeQuery();
				while(rs2.next()){
					uid=rs2.getInt("user_id");
				}
				PreparedStatement pstmt1=conn.prepareStatement(deposit);
				PreparedStatement pstmt5=conn.prepareStatement(getBal);
				pstmt5.setInt(1, a.getAccountid());
				ResultSet rss=pstmt5.executeQuery();
				if(rss.next()) {
					balanc=rss.getInt("balance");
				}
				pstmt1.setInt(1,(balanc+a.getAmount()));
				pstmt1.setInt(2, a.getAccountid());
				
//				pstmt1.setInt(4, uid);
				pstmt1.execute();
				Date date = Date.valueOf(LocalDate.now());
				PreparedStatement pstmt3=conn.prepareStatement(trans);
				pstmt3.setInt(1,a.getAccountid());
				pstmt3.setString(2, type);
				pstmt3.setInt(3, a.getAmount());
				pstmt3.setDate(4, date);
				pstmt3.execute();
				pstmt.close();
				rs.close();
				pstmt2.close();
				rs2.close();
				pstmt1.close();
				pstmt3.close();
				return "deposited sucessfully";
			}
			else {
				return "incorrect account id";
			}
		
	}
}
