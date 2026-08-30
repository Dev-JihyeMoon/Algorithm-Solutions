import java.util.*;
import java.io.FileInputStream;
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
            int num = sc.nextInt();
            int answer = num*num;
		
            bw.write("#"+test_case+" "+answer+"\n");
		}
        
        bw.close();
        sc.close();
	}
}