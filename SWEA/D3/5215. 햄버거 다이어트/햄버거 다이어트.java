import java.util.*;

class Solution
{
    static int maxKcal, maxNum, answer;
    static int[][] ingredients;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] temp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            maxNum = temp[0];
            maxKcal = temp[1];
            
            answer = 0;
            ingredients = new int[2][maxNum];
            
            // 입력값 저장
            for(int i=0; i<maxNum; i++){
            	temp = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                
                ingredients[0][i] = temp[0]; //맛 점수
                ingredients[1][i] = temp[1]; //칼로리
            }
            
            backtracking(0, 0, 0);
            
            String output = "#"+test_case+" "+answer+"\n";
            System.out.print(output);
		}
        
        sc.close();
	}
    
    public static void backtracking(int row, int score, int kcal){
        // 종료 조건 1 : 인덱스 끝에 도달했을 경우 
        // 종료 조건 2 : 칼로리가 기준점을 넘을 경우
        if( maxNum <= row ){
            if(answer < score) { answer = score; }
            return;
        }
        
        // 방문한 재료를 선택하는 경우
       	if (kcal + ingredients[1][row] <= maxKcal) {
    		backtracking(row + 1, score + ingredients[0][row], kcal + ingredients[1][row]);
		}
        
        //선택하지 않는 경우
        backtracking(row+1, score, kcal);
    }
}