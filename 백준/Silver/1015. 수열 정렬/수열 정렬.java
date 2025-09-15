import java.util.Arrays;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[2][N]; 
		for(int i = 0; i < arr[0].length; ++i)
		{
			arr[0][i] = sc.nextInt();
			arr[1][i] = arr[0][i]; 
		}
		Arrays.sort(arr[1]); 
		for(int i = 0; i < N; ++i)
		{
			for(int j = 0; j < N; ++j)
			{
				if(arr[0][i] == arr[1][j])
				{
					System.out.print(j + " ");
					arr[1][j] = -1;
					break;
				}
			}
		}
	}
}