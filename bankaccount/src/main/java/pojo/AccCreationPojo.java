package pojo;

public class AccCreationPojo {
int user_id;
String username,phonenum,password,email;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getPhonenum() {
	return phonenum;
}
public void setPhonenum(String phonenum) {
	this.phonenum = phonenum;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public AccCreationPojo(int user_id, String phonenum, String username, String password, String email) {
	super();
	this.user_id = user_id;
	this.phonenum = phonenum;
	this.username = username;
	this.password = password;
	this.email = email;
}

}
