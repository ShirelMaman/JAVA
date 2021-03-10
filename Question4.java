import java.util.Scanner;
public class Question4 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);

		/**
		 * We use the whole program in the same variables
		 * and update them according to user input
		 */

		String [] str = {"First","Second"}; // Players

		System.out.print("Maximum step size is (K) ");
		int max_num = input.nextInt(); // K

		System.out.print("Counter value is (N) ");
		int Counter =input.nextInt(); // N

		while (max_num>0 || max_num<Counter) { // Until Player win
			max_num = input.nextInt(); // First player
			System.out.println(str[0] +" player turn: "+max_num);
			Counter -= max_num;
			System.out.println("Counter value is "+Counter);
			if (Counter==0) { 
				System.out.println(str[1] +" player Win!");
				return;
			}
			if (Counter <0) {
				break;
			}
			max_num = input.nextInt(); // Second player
			System.out.println(str[1] +" player turn: "+max_num);
			Counter -= max_num;
			System.out.println("Counter value is "+Counter);
			if (Counter==0) { 
				System.out.println(str[0] +" player Win!");
				return;
			}
			if (Counter <0) {
				break;
			}
		}
		System.out.println("Illegal move!"); // Notification to user of illegality
		
		input.close();
	}
}