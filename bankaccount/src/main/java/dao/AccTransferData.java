package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import pojo.AccTransferPojo;

public class AccTransferData {
	int aid;
	int sbal;
	int dbal;
	String t="credit";
	String ty="debited";
	Date date = Date.valueOf(LocalDate.now());
	List<Integer> list=new ArrayList<Integer>();
	String validatesid="SELECT * FROM accountnum";
	String getBal="SELECT balance FROM account WHERE accountid=?";
	String updatesbal="UPDATE account SET balance=? WHERE accountid=?";
	String transaction="INSERT INTO transaction (account_id, transactiontype, amount, date) VALUES (?,?,?,?)";
	public String transferBal(AccTransferPojo a,Connection conn) throws SQLException {
		PreparedStatement pstmt=conn.prepareStatement(validatesid);
		PreparedStatement pstmt1=conn.prepareStatement(getBal);
		PreparedStatement pstmt2=conn.prepareStatement(getBal);
		PreparedStatement pstmt3=conn.prepareStatement(updatesbal);
		PreparedStatement pstmt4=conn.prepareStatement(updatesbal);
		PreparedStatement pstmt5=conn.prepareStatement(transaction);
		PreparedStatement pstmt6=conn.prepareStatement(transaction);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			aid=rs.getInt("accountid");
			list.add(aid);
		}
		pstmt1.setInt(1, a.getSourcrAid());
		ResultSet rs1=pstmt1.executeQuery();
		while(rs1.next()) {
			sbal=rs1.getInt("balance");
		}
		pstmt2.setInt(1, a.getDestAid());
		ResultSet rs2=pstmt2.executeQuery();
		while(rs2.next()) {
			dbal=rs2.getInt("balance");
		}
		if(list.contains(a.getDestAid()) && list.contains(a.getSourcrAid())) {
			if(sbal==0 && sbal<a.getAmount()) {
				String b=Integer.toString(a.getSourcrAid());
				return b+" id's funds are not sufficient";
			}
			else if(sbal!=0 && sbal>a.getAmount() || sbal==a.getAmount()) {
				int ball=sbal-a.getAmount();
				pstmt3.setInt(1, ball);
				pstmt3.setInt(2,a.getSourcrAid());
				pstmt3.execute();
				int ball1=dbal+a.getAmount();
				pstmt4.setInt(1, ball1);
				pstmt4.setInt(2, a.getDestAid());
				pstmt4.execute();
				pstmt5.setInt(1, a.getSourcrAid());
				pstmt5.setString(2, t);
				pstmt5.setInt(3,a.getAmount());
				pstmt5.setDate(4, date);
				pstmt5.execute();
				pstmt6.setInt(1, a.getDestAid());
				pstmt6.setString(2, ty);
				pstmt6.setInt(3, a.getAmount());
				pstmt6.setDate(4,date);
				pstmt6.execute();
				pstmt.close();
				pstmt1.close();
				pstmt2.close();
				pstmt3.close();
				pstmt4.close();
				pstmt5.close();
				pstmt6.close();
				rs.close();
				rs1.close();
				rs2.close();
				return "transfered successfully";
			}
			else {
				return null;
			}
		}
		else {
			return "id entered is invalid";
		}
		
	}
}
