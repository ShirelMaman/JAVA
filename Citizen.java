import java.util.Date;

import Enums.Gender;

public class Citizen {
	
	private String cid; //number ID
	private String fullName;
	private Date birthDate;
	private boolean militaryService;
	private Gender gender;
	
	//C'tor
	public Citizen(String cid,String fullName,Date birthDate,boolean militaryService,Gender gender) {
		setCid(cid);
		setFullName(fullName);
		setBirthDate(birthDate);
		setMilitaryService(militaryService);
		setGendet(gender);
	}
	
	//setters
	public void setCid (String cid) {
		if (cid.length() == 9)
			this.cid = cid;
		else System.out.println("The ID you enter is incorrect");
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate =birthDate;
	}
	public void setMilitaryService(boolean militaryService) {
		this.militaryService = militaryService;
	}
	public void setGendet(Gender gender) {
		this.gender = gender;
	}
	
	//getters
	public String getCid () {
		return cid;
	}
	public String getFullName() {
		return fullName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public boolean getMilitaryService() {
		return militaryService;
	}
	public Gender getGender () {
		return gender;
	}
	
	//equals
	public boolean equals (Citizen other) {
		return cid.equals(other.cid);
	}
	
	//print method
	public String toString () {
		return "Citizen: \nID: " +cid +"\nFullName: " +fullName+"\nDate: "+birthDate+"\nGender: "+gender;
	}
}
