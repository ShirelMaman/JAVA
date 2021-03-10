import java.util.Scanner;
public class Question3 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		/**
		 * print with request the user that input only integers numbers
		 */
		System.out.print("Plaese enter min temp: (Only Integers) " );
		int min_temp = input.nextInt();
		System.out.print("Plaese enter max temp: (Only Integers)" );
		int max_temp = input.nextInt();
		System.out.print("Plaese enter range of jump: (Only Integers)" );
		int jump = input.nextInt();

		if (min_temp<max_temp) {  // Checking integrity
			System.out.println();

			System.out.println("fahrenheit | celsius"); // just print to get a table 
			System.out.println("---------------------");

			while(min_temp<=max_temp) {   // Until the connection jump coming to the max_temp
				int celsius = 5*(min_temp-32)/9; // The Formula to pass from fahrenheit to celsius
				System.out.println("\t "+ min_temp+ "|" + celsius );
				min_temp+=jump; 
			}
		}
		else {
			System.out.println("Illegal min temp"); // Notification to user of illegality
		}
		input.close();
	}
}