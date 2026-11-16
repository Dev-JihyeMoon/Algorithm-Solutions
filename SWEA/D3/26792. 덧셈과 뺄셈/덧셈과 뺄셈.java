
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

            boolean check = false;
            for(int i=-100; i<=100; i++){
            	for(int j=-100; j<=100; j++){
                 	if(i+j == arr[0] && i-j==arr[1]){
                        check = true;
                        bw.write(i+" "+j+"\n");
                        
                        break;   
                    }
                }
                
                if(check){
                 	break;   
                }
            }
		}
        
        bw.close();
        br.close();
	}
}