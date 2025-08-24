
import java.util.Scanner;

public class Main {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			
			int a = scan.nextInt(), b = scan.nextInt();
			
			double div = (double)a/(double)b;
			
			System.out.print(div);
		}
	}