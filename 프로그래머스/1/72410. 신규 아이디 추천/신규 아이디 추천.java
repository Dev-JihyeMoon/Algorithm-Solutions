import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
public static String solution(String new_id) {
		
		String answer = new_id;
		
		answer = step01(answer);
		answer = step02(answer);
		answer = step03(answer);
		answer = step04(answer);
		if(answer.length() == 0) {
			answer = step05(new_id.length());
		} 
		if(answer.length() >= 16) {
			answer = step06(answer);
		} 
		if (answer.length() <= 2) {
			answer = step07(answer);
		}
		
		
        return answer;
    }
	
	public static String step01(String id) {
		return id.toLowerCase();
	}
	
	public static String step02(String id) {
		String deleteCode = "~!@#$%^&*()=+[{]}:?,<>/";
		String temp = "";
		
		for(int i=0; i<id.length(); i++) {
			String now = Character.toString(id.charAt(i));
			
			if(!deleteCode.contains(now)) {
				temp+=now;
			}
		}
		return temp;
	}
	
	public static String step03(String id) {
		while(true) {
			if(!id.contains("..")) {
				break;
			}
			id = id.replace("..", ".");
		}
		
		return id;
	}
	
	public static String step04(String id) {
		StringBuilder temp = new StringBuilder(id);
		if(id.charAt(0) == '.') {
			temp.deleteCharAt(0);
		}
		if(temp.length() != 0 && id.charAt(id.length()-1) == '.') {
			temp.deleteCharAt(temp.length()-1);
		}
		
		return temp.toString();
	}
	
	public static String step05(int i) {
		return "a";
	}
	
	public static String step06(String id) {
		id = id.substring(0, 15);
		
		for(int i=id.length()-1; i>0; i--) {
			if(id.charAt(i) != '.') {
				break;
			}
			id = id.substring(0, i);
		}
		
		return id;
	}
	
	public static String step07(String id) {
		while(true) {
			id += Character.toString(id.charAt(id.length()-1));
			
			if(id.length() == 3) {
				break;
			}
		}
		
		return id;
	}
}