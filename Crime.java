import java.util.ArrayList;
import java.util.Arrays;

public class Crime  implements Comparable<Crime>{
	
	//Class features
	private String crimeCode;
	private CityZone cityZone;
	private ArrayList<ArrestDetails> arrests;
	private double dangerLevel;
	
	//C'tor
	public Crime(String crimeCode,double dangerLevel) {
		setCrimeCode(crimeCode);
		setDangerLevel(dangerLevel);
		arrests = new ArrayList<ArrestDetails> ();
	}
	
	//setters
	public void setCrimeCode(String crimeCode) {
		this.crimeCode = crimeCode;
	}
	public void setCityZone(CityZone cityZone) {
		this.cityZone = cityZone;
	}
	public void setDangerLevel(double dangerLevel) {
		this.dangerLevel = dangerLevel;
	}
	
	//getters 
	public String getCrimeCode () {
		return crimeCode;
	}
	public CityZone getCityZone() {
		return cityZone;
	}
	public double getDangerLevel() {
		return dangerLevel;
	}
	public ArrayList<ArrestDetails> getArrests(){
		return arrests;
	}
	
	//equals
	public boolean equals(Object other) {
		if(other instanceof Crime) {
			Crime crime = (Crime)other;
			return crimeCode.equals(crime.crimeCode);
		}
		return false;
	}
	
	//print method
	public String toString() {
		return "Crime" +"/nCrimeCode: "+crimeCode +"\nDangerLevel: "+dangerLevel;
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
		dangerLevel= cnt_drug*0.25 + cnt_arms*0.5 + cnt_many*0.25;
	}
	
	public void addArrestDetails(ArrestDetails arrest) {
		if (! arrests.contains(arrest))
			arrests.add(arrest);
			updteDangerLevel();
	}
	
	public ArrayList<BadGuy> getAllBadGuys(){
		ArrayList<BadGuy> badGuy = new ArrayList<BadGuy> ();
		for (ArrestDetails arrestDetails : arrests) {
			badGuy.add(arrestDetails.getBadGuy());
		}
		return badGuy;
	}
	
	public int compareTo(Crime other) {
		return crimeCode.compareTo(other.crimeCode);
	}
}
