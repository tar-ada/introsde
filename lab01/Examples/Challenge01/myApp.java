import java.util.HashMap;
import java.util.Map;

import pojos.HealthProfile;
import pojos.Person;


public class myApp {
	
	//public static Map<String,Person> database = new HashMap<String,Person>();
	
	/**
	 * The health profile reader gets information from the command line about
	 * weight and height and calculates the BMI of the person based on this 
	 * parameters
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//initializeDatabase();
		HealthProfileReader hpr = new HealthProfileReader();
		
		int argCount = args.length;
		if (argCount<1 || argCount == 2 || argCount > 4) {
			System.out.println("we need 1, 3 or 4 arguments");
		} else if (argCount == 4) {
			Long id = Long.parseLong(args[0]);
			String fname = args[1];
			String lname = args[2];
			String bday = args[3];
			Person p = hpr.createPerson(id,fname,lname,bday);
			if (p!=null) { 
				System.out.println(fname+" "+lname+"'s health profile is: "+p.gethProfile().toString());
			} else {
				System.out.println(fname+" "+lname+" is not in the database");
			}
		} else if (argCount == 1) {
			Long id = Long.parseLong(args[0]);
			// read the person from the DB
			HealthProfile hp = hpr.displayHealthProfile(id);
			if (hp!=null) { 
				System.out.println("'s health profile is: "+hp.toString());
			} else {
				System.out.println(id+" is not in the database");
			}
		} else if (argCount == 3) {
			Long id = Long.parseLong(args[0]);
			Double height = Double.parseDouble(args[1]);
			Double weight = Double.parseDouble(args[2]);
			
			HealthProfile hp = hpr.updateHealthProfile(id,height,weight);
			if (hp!=null) { 
				System.out.println(id+"'s health profile is: "+hp.toString());
			} else {
				System.out.println(id+" is not in the database");
			}
		}
	}
}