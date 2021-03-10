import java.util.ArrayList;
import java.util.Date;

import Enums.Gender;
import Enums.Rank;

public class PoliceAssistant extends PoliceOfficer{

	//Class features
	private int totalExcellenceAwards;
	private double successLevel;
	private ArrayList<ArrestDetails> arrests;
	private SpecialAgent specialAgent;
	
	//C'tor
	public PoliceAssistant (String cid,String fullName,Date birthDate,boolean militaryService,Gender gender,String pid,Date startedService,Rank rank,
			int totalExcellenceAwards,double successLevel) {
		super (cid,fullName,birthDate,militaryService,gender,pid,startedService,rank);
		setTotalExcellenceAwards(totalExcellenceAwards);
		setSuccessLevel(successLevel);
		arrests = new ArrayList<ArrestDetails> ();
	}
	//setters
	public void setTotalExcellenceAwards(int totalExcellenceAwards) {
		if(totalExcellenceAwards >= 0)
			this.totalExcellenceAwards = totalExcellenceAwards;
	}
	public void setSuccessLevel(double successLevel) {
		if (successLevel >= 0)
			this.successLevel = successLevel;
	}
	public void setSpecialAgent(SpecialAgent specialAgent) {
		this.specialAgent = specialAgent;
	}
	
	//getters
	public int getTotalExcellenceAwards () {
		return totalExcellenceAwards;
	}
	public double getSuccessLevel () {
		return successLevel;
	}
	public SpecialAgent getSpecialAgent () {
		return specialAgent;
	}
	
	//equals
	public boolean equals(PoliceAssistant other) {
		return super.equals(other);
	}
	
	//print method
	public String toString() {
		return super.toString() + "\nPoliceAssistant: \nTotal awards: "+ totalExcellenceAwards + "\nSuccess level: "+ successLevel;
	}
	
	//implements the abstract method
	public void calculateSuccessLevel() {
		successLevel = (double) totalExcellenceAwards / arrests.size();
	}
	
	//Calculations 
	public int getArrestsCount() {
		return arrests.size();
	}
	
	public int getTotalCaughtWeapons() {
		int counter = 0;
		for(ArrestDetails arrest : arrests) {
		    arrest.getWeaponsAmount();
		    counter++;
		}
		return counter;
	}
	
	//Add method
	public void addArrest(ArrestDetails arrest) {
		if (! arrests.contains(arrest)) {
			arrests.add(arrest);
			calculateSuccessLevel();
		}
	}
}
