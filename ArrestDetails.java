import java.util.Date;

import Enums.Genre;

public class ArrestDetails {

	//Class features
	private static int arrestSerial=0;
	private Date dateOfArrest;
	private Genre genre;
	private PoliceAssistant policeAssistant;
	private BadGuy ArrestedBadGuy;
	private int stolenMoneyAmount;
	private int weaponsAmount;
	private double drugsQuantity;
	private Crime crime;

	//C'tor 
	public ArrestDetails (Date dateOfArrest,Genre genre,PoliceAssistant policeAssistant,BadGuy ArrestedBadGuy,
			int stolenMoneyAmount,int weaponsAmount,double drugsQuantity) {
		setDateOfArrest(dateOfArrest);
		setGenre(genre);
		setPoliceAssistant(policeAssistant);
		setBadGuy(ArrestedBadGuy);
		setStolenMoneyAmount(stolenMoneyAmount);
		setWeaponsAmount(weaponsAmount);
		setDrugsQuantity(drugsQuantity);
		arrestSerial++;
	}

	//setters
	public void setDateOfArrest(Date dateOfArrest) {
		this.dateOfArrest = dateOfArrest;
	}
	public void setGenre(Genre genre) {
			this.genre = genre;
	}
	public void setPoliceAssistant(PoliceAssistant policeAssistant) {
		this.policeAssistant = policeAssistant;
	}
	public void setBadGuy(BadGuy ArrestedBadGuy) {
		this.ArrestedBadGuy = ArrestedBadGuy;
	}
	public void setStolenMoneyAmount(int stolenMoneyAmount) {
		if(stolenMoneyAmount >= 0)
			this.stolenMoneyAmount = stolenMoneyAmount;
	}
	public void setWeaponsAmount(int weaponsAmount) {
		if(weaponsAmount >= 0)
			this.weaponsAmount = weaponsAmount;
	}
	public void setDrugsQuantity(double drugsQuantity) {
		if(drugsQuantity >= 0)
			this.drugsQuantity = drugsQuantity;
	}

	//getters
	public int getArrestSerial() {
		return arrestSerial;
	}
	public Date getDateOfArrest() {
		return dateOfArrest;
	}
	public Genre getGenre() {
		return genre;
	}
	public PoliceAssistant getPoliceAssistant() {
		return policeAssistant;
	}
	public BadGuy getBadGuy() {
		return ArrestedBadGuy;
	}
	public int getStolenMoneyAmount() {
		return stolenMoneyAmount;
	}
	public int getWeaponsAmount() {
		return weaponsAmount;
	}
	public double getDrugsQuantity() {
		return drugsQuantity;
	}
	public Crime getCrime() {
		return crime;
	}

	//equals
	public boolean equals (ArrestDetails other) {
		return arrestSerial == other.getArrestSerial();
	}

	//print method
	public String toString() {
		return "ArrestDetails details: \nSerial number: "+ arrestSerial +"\nDate: "+ dateOfArrest + "\nStolen money ammount: "+ stolenMoneyAmount +
				"\nWeapons amount: "+ weaponsAmount +"\nDrugs quantity: "+ drugsQuantity;
	}
	
	//Boot method
	public void addCrime(Crime crime) {
		this.crime = crime;
	}
}
