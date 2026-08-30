import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int size = sc.nextInt();
            sc.nextLine();
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            int[] answer = getLevel(size, arr);
            
            bw.write("#"+test_case+" "+answer[0]+" "+answer[1]+"\n");
		}
        
        bw.close();
        sc.close();
	}
    
    public static int[] getLevel(int size, int[] arr){
        int up = 0, down =0;
        
        for(int i=0; i<size-1; i++){
            int now = Math.abs(arr[i] - arr[i+1]);
            
            if(arr[i] < arr[i+1]) { up = up<now?now:up; } 
            else if(arr[i] > arr[i+1]) { down = down<now?now:down; }
        }
        
        return new int[]{up, down};
    }
}