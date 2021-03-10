
public class Question1 {

	public static void main(String[] args) {

		/**
		 * First loop --> Short loop
		 * Second loop --> Long loop
		 * Theerd loop --> Longer loop
		 * That's how we catch all the combinations between 0 to 2
		 */

		System.out.println("All combinations are: ");
		for(int i=0 ; i<=2 ; i++) {
			for(int j=0 ; j<=2 ; j++) {
				for(int k=0 ; k<=2 ; k++) {
					System.out.println(i+","+j+","+k);
				}
			}
		}
	}
}	
