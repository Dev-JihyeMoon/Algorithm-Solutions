import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

class Solution {
 public static int solution(String[] want, int[] number, String[] discount) {
		
		//step 01. 품목이 있는지 확인
		List<String> list = Arrays.asList(discount);
		
		for(String i:want) {
			if(!list.contains(i)) {
				//System.out.println("품목이 없음.");
				return 0;
			}
		}
		
		int count = 0;
		for(int i=0; i<discount.length-9; i++) {
			String[] now = Arrays.copyOfRange(discount, i, i+10);
			
			//System.out.println("f:"+now[0]+"/l:"+now[9]);
			if(check(now, want, number)){
				count++;
			}
		}
		
		return count;
	}
	
	public static boolean check(String[] discount, String want[], int[] number){
	
		for(int i=0; i<want.length; i++) {
			String nowWant = want[i];
			int nowNumber = number[i];
			
			int count = 0;
			boolean checkDiscount = false;
					
			for(int j=0; j<10; j++) {
				if(nowWant.equals(discount[j])) {
					count++;
					
					if(count == nowNumber) {
						checkDiscount = true;
						break;
					}
				}
			}
			
			if(!checkDiscount) {
				return false;
			}
			
		}
		return true;
	}
}