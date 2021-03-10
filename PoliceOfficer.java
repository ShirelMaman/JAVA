import java.util.Date;

import Enums.Gender;
import Enums.Rank;

public abstract class PoliceOfficer extends Citizen {

	//Class features
	private String pid;  //personal number
	private Date startedService;
	private Rank rank;

	//C'tor
	public PoliceOfficer (String cid,String fullName,Date birthDate,boolean militaryService,Gender gender,
			String pid,Date startedService,Rank rank) {
		super(cid,fullName,birthDate,militaryService,gender);
		setPid(pid);
		setStartedService(startedService);
		setRank(rank);
	}

	//setters
	public void setPid(String pid) {
		if(pid.length() == 6)
			this.pid = pid;
		else System.out.println("The personal number you enter is incorrect");
	}
	public void setStartedService(Date startedService) {
		this.startedService = startedService;
	}
	public void setRank(Rank rank) { 
			this.rank = rank;
	}

	//getters
	public String getPid () {
		return pid;
	}
	public Date getStartedService () {
		return startedService;
	}
	public Rank getRank () {
		return rank;
	}

	//equals
	public boolean equals (PoliceOfficer other) {
		return super.equals(other) && pid.equals(other.pid);
	}

	//print method
	public String toString() {
		return super.toString() + "\nPoliceOfficer: \nPID: "+ pid +"\nString Date: "+ startedService + "\nRank: "+ rank;
	}
	
	//abstract method
	public abstract void calculateSuccessLevel();
}
