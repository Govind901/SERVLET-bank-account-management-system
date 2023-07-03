package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.validator.routines.EmailValidator;

import pojo.AccCreationPojo;

public class AccCreationData {
	int aid;
	int bal=0;
	EmailValidator validator = EmailValidator.getInstance();
	String insert="INSERT INTO users (username, password, email, phonenum,accountid) VALUES(?,?,?,?,?)";
	String accnum="INSERT INTO accountnum VALUES(?,?)";
	String insertacc="INSERT INTO account VALUES(?,?,?,?)";
	String selectuid="SELECT user_id FROM users WHERE accountid=?";
	public String creation(AccCreationPojo a,Connection conn) throws SQLException {	
		Random rm=new Random();
		int rm1=rm.nextInt(50);
		int rm2=(rm1*100000)+21547854;
		if(a.getUsername()!=null && a.getPassword()!=null && validator.isValid(a.getEmail())) {
			PreparedStatement pstmt=conn.prepareStatement(insert);
			PreparedStatement pstmt1=conn.prepareStatement(accnum);
			PreparedStatement pstmt2=conn.prepareStatement(insertacc);
			PreparedStatement pstmt3=conn.prepareStatement(selectuid);
			
			pstmt.setString(1, a.getUsername());
			pstmt.setString(2, a.getPassword());
			pstmt.setString(3, a.getEmail());
			if(a.getPhonenum().length()==10) {
			pstmt.setString(4, a.getPhonenum());
			}
			pstmt.setInt(5, rm1);
			pstmt.execute();
			pstmt1.setInt(1,rm2); 
			pstmt1.setInt(2,rm1);
			pstmt1.execute();
			pstmt3.setInt(1, rm1);
			ResultSet rs=pstmt3.executeQuery();
			if(rs.next()) {
				aid=rs.getInt("user_id");
			}
			pstmt2.setInt(1,rm1);
			pstmt2.setInt(2,aid);
			pstmt2.setInt(3,rm2);
			pstmt2.setInt(4,bal);
			pstmt2.execute();
			pstmt.close();
			pstmt1.close();
			pstmt3.close();
			rs.close();
			pstmt2.close();
			return "created successfully";
		}
		else {
			return "input type miss match";
		}
	}
	
}
