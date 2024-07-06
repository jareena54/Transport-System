package managerCreation;

import java.sql.Date;
import java.time.LocalDate;

public class Managerbean {
	private String branch;
	private String username;
	private int password;
	private LocalDate date_of_joining;
	private LocalDate date_of_birth;
	private Double sal;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public LocalDate getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(LocalDate localDate) {
		this.date_of_joining = localDate;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate localDate) {
		this.date_of_birth = localDate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	
	

}
