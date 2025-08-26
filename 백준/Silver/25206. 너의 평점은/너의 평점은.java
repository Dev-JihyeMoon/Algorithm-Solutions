import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		float subjectSum = 0, creditSum = 0;
		
		for(int i=0; i<20; i++) {
			String[] input = br.readLine().split(" ");
			
			float score = 0.0F;
			
			switch(input[2].charAt(0)) {
			case'A':
				score+=4.0;
				if(input[2].charAt(1) == '+')
					score+=0.5;
				break;
			case'B':
				score+=3.0;
				if(input[2].charAt(1) == '+')
					score+=0.5;
				break;		
			case'C':
				score+=2.0;
				if(input[2].charAt(1) == '+')
					score+=0.5;
				break;		
			case'D':
				score+=1.0;
				if(input[2].charAt(1) == '+')
					score+=0.5;
				break;		
			case'F':case'P':
				break;				
			}
			
			if(input[2].charAt(0) != 'P') {
				float credit = Float.parseFloat(input[1]);
				
				creditSum += credit; // 학점의 총합
				subjectSum += score*credit; //전공과목 별 합				
			}		
			
		}
		
		System.out.print(subjectSum/creditSum);
		
	}
}