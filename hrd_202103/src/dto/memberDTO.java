package dto;

import java.sql.Date;

public class MemberDTO {
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
	private int Money_tbl_Price;

	@Override
	public String toString() {
		return "MemberDTO [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + ", Money_tbl_Price="
				+ Money_tbl_Price + "]";
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMoney_tbl_Price() {
		return Money_tbl_Price;
	}

	public void setMoney_tbl_Price(int money_tbl_Price) {
		Money_tbl_Price = money_tbl_Price;
	}

}
