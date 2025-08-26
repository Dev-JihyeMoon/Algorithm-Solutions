import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
	
		String s = sc.next();
		
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<s.length(); i++) {
			list.add(s.substring(i, s.length()));
		}
		
		Collections.sort(list);
		
		for(String i:list) {
			System.out.println(i);
		}
		
		sc.close();
	}
}
