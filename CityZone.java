import java.util.ArrayList;

public class CityZone {
	
	//Class features
	private int zoneCode;
	private String zoneName;
	private ArrayList<Crime> crimes;
	
	//C'tor
	public CityZone (int zoneCode,String zoneName) {
		setZoneCode(zoneCode);
		setZoneName(zoneName);
		crimes = new ArrayList<Crime> ();
	}
	
	//setters 
	public void setZoneCode (int zoneCode) {
		this.zoneCode = zoneCode;
	}
	public void setZoneName (String zoneName) {
		this.zoneName = zoneName;
	}
	
	//getters
	public int getZoneCode() {
		return zoneCode;
	}
	public String getZoneName() {
		return zoneName;
	}
	public ArrayList<Crime> getCrimes(){
		return crimes;
	}
	
	//equals
	public boolean equals (Object other) {
		if(other instanceof CityZone) {
			CityZone cityZone = (CityZone) other;
			return zoneCode == cityZone.zoneCode;
		}
		return false;
	}
	
	//print method
	public String toString() {
		return "CityZone:" + "\nZoneCode: " + zoneCode + "\nZoneName: " + zoneName;
	}
	
	
	//add method
	public void addCrime(Crime crime) {
		if (! crimes.contains(crime))
			crimes.add(crime); 
		else {
			System.out.println("The crime was not committed in this area");
		}
	}
	
	//Calculations
	public int getTotalCrimesCount() {
		return crimes.size();
	}
	
	public boolean hasCrime(Crime crime) {
		return crimes.contains(crime);
	}
}
