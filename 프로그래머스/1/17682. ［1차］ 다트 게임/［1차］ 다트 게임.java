class Solution {
    public static int solution(String dartResult) {
		
		int[] score = new int[3];
		String[] bonus = new String[3];
		String[] option = new String[3];
		
		int point = 0, answer = 0;
		String temp = "";
		
        //score, bonus, option 저장
		for(int i=0; i<dartResult.length(); i++) {
			String now = Character.toString(dartResult.charAt(i));

			if("SDT".contains(now)) {
				bonus[point] = now;
				score[point] = Integer.parseInt(temp);
				temp = "";
			} else if("*#".contains(now)) {
				option[point] = now;
			} else {
				if(bonus[point] != null) {
					point++;
				} 
				temp += now;
			}
			
			
		}
		
		//보너스 점수 계산
		for(int i=0; i<3; i++) {
			
			if(bonus[i].equals("D")) {
				score[i] = (int) Math.ceil(Math.pow(score[i], 2));
			} else if(bonus[i].equals("T")) {
				score[i] = (int) Math.ceil(Math.pow(score[i], 3));
			}
			
		}
		
		
		//옵션 계산
		for(int i=0; i<3; i++) {
			if(option[i] != null) {
				
				if(option[i].equals("*")) {
					score[i] =score[i]* 2;

					if(i != 0) {
						score[i-1] = score[i-1] *2;
					}
				} else if(option[i].equals("#")){
					score[i] = score[i] * (-1);
					
				}

			}
		}
		
		
		//총 점수 계산
		for(int i=0; i<3; i++) {
			answer += score[i];
		}
        
        return answer;
    }
}