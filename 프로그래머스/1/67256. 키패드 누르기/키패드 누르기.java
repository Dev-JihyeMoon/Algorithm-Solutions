class Solution {
   public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int leftPoint = 10;
        int rightPoint = 12;
        
        for(int i:numbers) {
        	
        	if(i==1 || i==4 || i==7) {
        		leftPoint = i;
        		answer += "L";
        		continue;
        	} else if (i==3 || i==6 || i==9) {
        		rightPoint = i;
        		answer += "R";
        		continue;
        	} else if (i==0) { 
        		i = 11;
        	}
        	
        	
        	
        	int leftMove = move(leftPoint, i);
        	int rightMove = move(rightPoint, i);
        	
        	if(leftMove < rightMove) {
        		leftPoint = i;
        		answer += "L";
        	} else if (leftMove > rightMove) {
        		rightPoint = i;
        		answer += "R";
        	} else {
        		
        		
        		if(hand.equals("left")) {
        			leftPoint = i;
            		answer += "L";
        		} else {
        			rightPoint = i;
            		answer += "R";
        		}
        	}
        	   
        }
        
        return answer;
        
    }
	
	public static int move(int point, int goal) {
		
		return  Math.abs(((point-goal)/3 ) + ( (point-goal)%3));
	}
}