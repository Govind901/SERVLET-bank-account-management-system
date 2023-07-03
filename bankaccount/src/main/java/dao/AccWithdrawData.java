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
import pojo.AccWithdrawPojo;

public class AccWithdrawData {
	String validateaccid="SELECT * FROM accountnum ";
	String balancecheck="SELECT balance FROM account WHERE accountid=?";
	String update ="UPDATE account SET balance=? WHERE accountid=?";
	String trans="INSERT INTO transaction (account_id, transactiontype, amount, date) VALUES(?,?,?,?)";
	List<Integer> list=new ArrayList<Integer>();

	int ac;
	int i;
	int x;
	String str="debited";
	public String withdraw(AccWithdrawPojo a,Connection conn) throws SQLException {
		PreparedStatement pstmt=conn.prepareStatement(validateaccid);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			 i=rs.getInt("accountid");
			ac=rs.getInt("Accountnum");
			list.add(i);
		}
		pstmt.close();
		rs.close();
		if(list.contains(a.getAccountid())) {
			PreparedStatement pstmt1=conn.prepareStatement(balancecheck);
			 pstmt1.setInt(1, a.getAccountid());
			 ResultSet rs1=pstmt1.executeQuery();
			 while(rs1.next()){
				 x=rs1.getInt("balance");
			 }
			 
			 if(x>a.getAmount() || x==a.getAmount() ) {
				 PreparedStatement pstmt2=conn.prepareStatement(update);
				 int z=x-a.getAmount();
				 System.out.println(z);
				 pstmt2.setInt(1, z);
				 pstmt2.setInt(2, a.getAccountid());
				 pstmt2.execute();
				 Date date = Date.valueOf(LocalDate.now());
				 PreparedStatement pstmt3=conn.prepareStatement(trans);
				 pstmt3.setInt(1, a.getAccountid());
				 pstmt3.setString(2, str);
				 pstmt3.setInt(3, a.getAmount());
				 pstmt3.setDate(4, date);
				 pstmt3.execute();
				 pstmt2.close();
				 pstmt3.close();
				 return "amount withdrawed";
			 }
			 else if(a.getAmount()<0){
				 return "amount entered is invalid";
			 }
			 else if(x<a.getAmount()){
				 return "amount not sufficient";
			 }
			 pstmt1.close();
			 rs1.close();
		}
		else {
		return null;
		}
		return null;
}
}
