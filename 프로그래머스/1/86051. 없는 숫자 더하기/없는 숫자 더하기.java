class Solution {
	public int solution(int[] numbers) {
		int[] answers = new int[10];
		int answer = 0;
		
		for(int i=0;i<numbers.length;i++) {
			//numbers의 배열 값을 인덱스 값으로 사용하여 numbers에 들어있는 값을 1로 체크
			answers[numbers[i]] = 1;
		}
		
		for(int i=0;i<answers.length;i++) {
			if(answers[i]==0) {
				answer += i;
			}
		}
		
		return answer;
		
	}
}