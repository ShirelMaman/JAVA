import java.util.ArrayList;
import java.util.Date;

import Enums.Gender;
import Enums.Rank;

public class SpecialAgent extends PoliceOfficer {
	
	//Class features
	private double totalArrestsByAssistants;
	private double successLevel;
	private ArrayList<PoliceAssistant> assistants;
	
	//C'tor
	public SpecialAgent(String cid, String fullName, Date birthDate, boolean militaryService, Gender gender, String pid,
			Date startedService, Rank rank,double totalArrestsByAssistants,double successLevel) {
		super(cid, fullName, birthDate, militaryService, gender, pid, startedService, rank);
		setTotalArrestsByAssistants(totalArrestsByAssistants);
		setSuccessLevel(successLevel);
		assistants = new ArrayList<PoliceAssistant> ();
	}
	
	//setters
	public void setTotalArrestsByAssistants(double totalArrestsByAssistants) {
		if(totalArrestsByAssistants >= 0)
			this.totalArrestsByAssistants = totalArrestsByAssistants;
	}
	public void setSuccessLevel (double successLevel) {
		if (successLevel >= 0)
			this.successLevel = successLevel;
	}
	
	//getters
	public double getTotalArrestsByAssistants() {
		return totalArrestsByAssistants;
	}
	public double getSuccessLevel() {
		return successLevel;
	}
	
	//equals
	public boolean equals(SpecialAgent other) {
		return super.equals(other);
	}
	
	//print method
	public String toString () {
		return super.toString()+"\nSpecialAgent: \nTotal awards: "+ totalArrestsByAssistants + "\nSuccess level: "+ successLevel;
	}
	
	//implements the abstract method
	public void calculateSuccessLevel() {
		successLevel = (double) totalArrestsByAssistants / assistants.size();
	}
	
	//Calculations
	public void updatetotalArrestsByAssistants() {
		int counter =0;
		for(PoliceAssistant pa:assistants) {
			counter+= pa.getArrestsCount(); 
		}
		totalArrestsByAssistants = counter;
	}
	
	public boolean hasAssistant(PoliceAssistant po) {
		return assistants.contains(po);
	}
	
	public int getNumberOfActualAssistants() {
		return assistants.size();
	}
	
	//add method
	public void addPoliceAssistant(PoliceAssistant po) {
		if (! assistants.contains(po)) {
			assistants.add(po);
			calculateSuccessLevel();
		}
	}
}