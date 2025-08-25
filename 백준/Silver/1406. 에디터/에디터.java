import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		Stack<String> strL = new Stack<>();
		Stack<String> strR = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			strL.add(String.valueOf(str.charAt(i)));
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] command = br.readLine().split(" ");
			
			switch(command[0]) {
			case "L": 
				if(!strL.isEmpty()) {
					strR.add(strL.pop());
				}
				break;
			case "D":
				if(!strR.isEmpty()) {
					strL.add(strR.pop());
				}
				break;
			case "B":
				if(!strL.isEmpty()) {
					strL.pop();
				}
				break;
			case "P":
				strL.add(command[1]);
				break;
			}
		}
		
		while(!strL.isEmpty()) {
			strR.add(strL.pop());
		}
		
		while(!strR.isEmpty()) {
			bw.write(strR.pop());
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}