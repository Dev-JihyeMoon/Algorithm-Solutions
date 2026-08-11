class Solution {
 
	public static String solution(String s) {

		int count = 0;
		String output="";
		
		for(int i=0; i<s.length(); i++) {
			
			if(s.charAt(i) == ' ') {
				output += " ";
				count = 0;
				continue;
			} 
			
			int now = (int)s.charAt(i);
			
			// 소문자인데 짝수일 경우
			if(now > 96 && count%2 == 0) {
				output += Character.toString(s.charAt(i)).toUpperCase();
			} 
			// 대문자인데 홀수일 경우
			else if(now <= 96 && count%2 != 0) {
				output += Character.toString(s.charAt(i)).toLowerCase();
			}
			else {
				output += Character.toString(s.charAt(i));
			}
			
			count++;
			
		}
		return output;
	}
}