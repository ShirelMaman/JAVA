import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class PoliceForce implements Serializable {

	//Class features
	private ArrayList<BadGuy>badGuy;
	private ArrayList<PoliceOfficer>polices;
	private ArrayList<CityZone>zones;

	//C'tor
	public PoliceForce() {
		badGuy = new ArrayList<BadGuy> ();
		polices = new ArrayList<PoliceOfficer> ();
		zones = new  ArrayList<CityZone> ();
	}

	//Add method
	public void addPoliceOfficer(PoliceOfficer po) throws IllegalPoliceOfficer {
		if (! polices.contains(po)) {
			polices.add(po); 
		}
		else { throw new IllegalPoliceOfficer ("This Police Officer is already exists in the system!"); 
		}
	}
	public void addZone(CityZone zone) throws IllegalZone {
		if (! zones.contains(zone)) {
			zones.add(zone); 
		}
		else { throw new IllegalZone ("This Zone is already exists in the system!"); 
		}
	}

	public void addBadGuy(BadGuy badguy) {
		if (! badGuy.contains(badguy)) 
			badGuy.add(badguy);
	}

	//arrests
	public void arrestBadGuy(ArrestDetails arrest) {
		BadGuy bad_guy = arrest.getBadGuy();
		bad_guy.addArrest(arrest);

		PoliceAssistant police_Assistant = arrest.getPoliceAssistant();
		police_Assistant.addArrest(arrest);
	}

	public void addCrimeToCityZone(Crime crime, int zoneCode) throws IllegalCrime {
		boolean zoneFalide = false;
		CityZone zone = null;
		for(CityZone zn : zones) {
			if(zn.getZoneCode() == zoneCode) {
				zone = zn;
				zone.addCrime(crime);
				zoneFalide= true;
			}
		}
			if(! zoneFalide) {
				throw new IllegalCrime("The zone is not fuond in the list!");
			}
	}
	
	//Replacements
	private boolean swapPoliceOfficers(PoliceOfficer p1, PoliceOfficer p2) {
		PoliceAssistant P1;
		PoliceAssistant P2;
		if((p1.getClass().getName()).equals("PoliceAssistant") && (p2.getClass().getName()).equals("PoliceAssistant")) {
			P1=(PoliceAssistant)p1;
			P2=(PoliceAssistant)p2;
			P1.setSpecialAgent(P2.getSpecialAgent());
			P2.setSpecialAgent(P1.getSpecialAgent());
			return true;
		}
		return false;
	}
	//Searching for crimes
	public ArrayList<BadGuy> getAllBGuysThatCommitedCrimesInZone(int zoneCode){
		ArrayList<BadGuy> badGuy = new ArrayList<BadGuy> ();
		for(CityZone zone : zones) {
			if (zone.getZoneCode() == zoneCode)
				for (Crime crime : zone.getCrimes()) {
					for (ArrestDetails arrestDetails : crime.getArrests()) {
						badGuy.add(arrestDetails.getBadGuy());
					}
				}
		}
		return badGuy;
	}
	
	//Sorting with the compareTo method
	public ArrayList<Crime> getCrimesSortedByCode(){
		ArrayList<Crime> crimes = new ArrayList<Crime>();
		for (Crime crime : crimes) {
			crime.getArrests();
			crimes.add(crime);
		}
		Collections.sort(crimes); 
		return crimes; 
	}
	
	//Write into file
	public static void savePoliceForceData(ArrayList<PoliceForce> pForces) {
		ArrayList<PoliceForce> pForces2 = new ArrayList<PoliceForce> ();
		if(pForces != null) {
			pForces2.addAll(pForces);
		}
		if(pForces.size() > 0) {
			try {
				FileOutputStream fos = new FileOutputStream ("police_force.bn");
				ObjectOutputStream out = new ObjectOutputStream (fos);
				out.writeObject(pForces2);
				out.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	//read from file
	public static PoliceForce loadPoliceForceData() {
		if("police_force.bn" != null) {
			try {
				FileInputStream fis = new FileInputStream ("police_force.bn");
				ObjectInputStream in = new ObjectInputStream(fis);
				Object o =  in.readObject();
				if(o instanceof PoliceForce) {
					return ((PoliceForce)o);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		return null;
	}
}
