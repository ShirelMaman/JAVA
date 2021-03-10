import java.util.ArrayList;
import java.util.Date;

import Enums.BadGuy_type;
import Enums.Gender;

public class BadGuy extends Citizen {

	//Class features
	private String nickName;
	private ArrayList<ArrestDetails> arrests;
	private BadGuy_type badguy_type;
	private double dangerLevel;

	//C'tor
	public BadGuy (String cid,String fullName,Date birthDate,boolean militaryService,Gender gender,
			String nickName,BadGuy_type badguy_type,double dangerLevel) {
		super(cid,fullName,birthDate,militaryService,gender);
		setNickName(nickName);
		setBadguy_type(badguy_type);
		setDangerLevel(dangerLevel);
		arrests = new ArrayList<ArrestDetails> ();
	}

	//settrs
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setBadguy_type(BadGuy_type badguy_type) {
			this.badguy_type = badguy_type;
	}
	public void setDangerLevel(double dangerLevel) {
		this.dangerLevel = dangerLevel;
	}

	//getters
	public String getNickName() {
		return nickName;
	}
	public BadGuy_type getBadguy_type() {
		return badguy_type;
	}
	public double getDangerLevel() {
		return dangerLevel;
	}

	//equals
	public boolean equals (BadGuy other) {
		return super.equals(other);
	}

	//print method
	public String toString() {
		return super.toString()+"\nBadGuy: \nNickName: "+nickName+"\nType: "+badguy_type+"\nDanger level: "+dangerLevel;
	}

	//Calculations
	private void updteDangerLevel() {
		double cnt_drug = 0;
		double cnt_arms = 0;
		double cnt_many = 0;

		for(ArrestDetails ar : arrests ) {
			cnt_drug += ar.getDrugsQuantity();
			cnt_arms += ar.getWeaponsAmount();
			cnt_many += ar.getStolenMoneyAmount();
		}
		dangerLevel= (cnt_drug*0.5 + cnt_arms*0.3 + cnt_many*0.2) / arrests.size(); 
	}
	public int getArrestsCount() {
		return arrests.size();
	}
	
	//Add method
	public void addArrest(ArrestDetails arrest) {
		if (! arrests.contains(arrest)) {
			arrests.add(arrest);
			updteDangerLevel();
		}
	}
	
	public ArrayList<PoliceOfficer> getOfficersArrestBy(){
		ArrayList<PoliceOfficer> police = new ArrayList<PoliceOfficer> ();
		for (ArrestDetails arrestDetails : arrests) {
			police.add(arrestDetails.getPoliceAssistant());
		}
		return police;
	}
}
