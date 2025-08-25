import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int hour = scan.nextInt(), minute = scan.nextInt();
		int cookingTime = scan.nextInt();
		
		scan.close();
		
		minute += cookingTime;
		
		if(minute >= 60) {
			hour += minute/60;
			minute %= 60;
			if(hour > 23) {
				hour -= 24;
			}
		}
		
		System.out.print(hour+" "+minute);
	}
}