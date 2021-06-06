package model;

public class dto {

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	// member_tbl_02
	private int custno;
	private String custname;
	private String phone;
	private String address;
	private String joindate;
	private String grade;
	private String city;
//	money_tbl_02
	private int salenol;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private String sdate;
//	추가로 
	private int sum_price;

	@Override
	public String toString() {
		return "dto [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + ", salenol=" + salenol + ", pcost="
				+ pcost + ", amount=" + amount + ", price=" + price + ", pcode=" + pcode + ", sdate=" + sdate
				+ ", sum_price=" + sum_price + "]";
	}

	public int getSum_price() {
		return sum_price;
	}

	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
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

	public String getJoindate() {
		return joindate;
	}

	public String getSdate() {
		return sdate;
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

	public int getSalenol() {
		return salenol;
	}

	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

}
