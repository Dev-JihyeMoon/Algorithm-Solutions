import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		double sum=0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		
		Arrays.sort(arr);
		
		int count=0, max=-1, mod=arr[0];
		boolean check = false;
		
		for(int i=0; i<N-1; i++) {
			if(arr[i] == arr[i+1]) {
				count++;
			} else {
				count=0;
			}
			
			if(max < count) {
				max = count;
				mod = arr[i];
				check = true;
			} else if(max == count && check == true) {
				mod = arr[i];
				check = false;
			}
		}
		
		System.out.println(Math.round(sum / N));
		System.out.println(arr[(N - 1) / 2]);
		System.out.println(mod);
		System.out.println(arr[N - 1] - arr[0]);
		
		br.close();
	}
}