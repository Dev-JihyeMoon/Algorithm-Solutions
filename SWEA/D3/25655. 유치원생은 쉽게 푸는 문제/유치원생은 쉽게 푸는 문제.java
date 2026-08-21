import java.util.*;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int num = sc.nextInt();
            bw.write(setValue(num)+"\n");
		}
        
        sc.close();
        bw.close();
        
	}
    
    public static String setValue(int num){
        if(num == 0) { return "1"; }
        if(num == 1) { return "0"; }
        
        
        String answer = "";
        if(num%2 == 1){ answer = "4"; }
        
        for(int i=0; i < num/2; i++){
            answer += "8";
        }
        
        return answer;
    }
                
   
}