import java.util.Date;

public class MainClass {

	public static void main(String[] args) {

		PoliceForce policeForce = new PoliceForce ();

		Date date1 = new Date (1988,03,22);
		Date date2 = new Date (1991,02,12);
		Date date3 = new Date (1994,01,04);
		Date date4 = new Date (1975,10,31);

		PoliceOfficer police_man1 = new PoliceOfficer("11111111","Shimon_Ben_Hamo",date1,false,"MALE","1",date2,"JUNIOR",5,"SPECIAL_AGENT",2);
		policeForce.addPoliceOfficer(police_man1);

		PoliceOfficer police_man2 = new PoliceOfficer("222222222","Shirel_Maman",date2,true,"FEMALE","2",date3,"JUNIOR",2,"POLICE_ASSISTANT",0); 
		policeForce.addPoliceOfficer(police_man2);

		PoliceOfficer police_man3 = new PoliceOfficer("333333333","Shlomi_Levi",date3,false,"MALE","3",date4,"JUNIOR",10,"SPECIAL_AGENT",6);
		policeForce.addPoliceOfficer(police_man3);

		PoliceOfficer police_man4 = new PoliceOfficer("444444444","Adi_Malka",date4,true,"FEMALE","4",date2,"JUNIOR",7,"POLICE_ASSISTANT",1);
		policeForce.addPoliceOfficer(police_man4);

		System.out.println(police_man1+"\n");
		System.out.println(police_man2+"\n");
		System.out.println(police_man3+"\n");
		System.out.println(police_man4+"\n");

		BadGuy bad_guy1 = new BadGuy ("123456789","Noam_Cohen",date2,true,"MALE","NO","BANK_ROBBER",24.75);
		policeForce.addBadGuy(bad_guy1);

		BadGuy bad_guy2 = new BadGuy ("987654321","Agam_Shtain",date4,false,"FEMALE","GOGa","HITMAN",17.5);
		policeForce.addBadGuy(bad_guy2);

		System.out.println(bad_guy1+"\n");
		System.out.println(bad_guy2+"\n");

		ArrestDetails arrest1 = new ArrestDetails (123456,date1,"UNDERCOVER",police_man1,bad_guy1,100000,1,0);
		policeForce.arrestBadGuy(arrest1);
		
		ArrestDetails arrest2 = new ArrestDetails (234567,date2,"WISEGUY",police_man2,bad_guy2,500000,5,1);
		policeForce.arrestBadGuy(arrest2);
		
		ArrestDetails arrest3 = new ArrestDetails (345678,date3,"UNKNOWN",police_man3,bad_guy2,0,20,0);
		policeForce.arrestBadGuy(arrest3);
		
		ArrestDetails arrest4 = new ArrestDetails (456789,date4,"UNDERCOVER",police_man4,bad_guy1,8000000,0,0);
		policeForce.arrestBadGuy(arrest4);
		
		System.out.println(arrest1+"\n");
		System.out.println(arrest2+"\n");
		System.out.println(arrest3+"\n");
		System.out.println(arrest4+"\n");
	}
}