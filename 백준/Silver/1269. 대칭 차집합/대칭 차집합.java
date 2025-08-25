import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int a = ab[0], b = ab[1], temp = 0;
		
		int[] aInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] bInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
		HashSet<Integer> list = new HashSet<>();
		
		for(int i=0; i<a; i++) {
			list.add(aInput[i]);
		}
		
		for(int i=0; i<b; i++) {
			if(list.contains(bInput[i])) {
				temp++;
			}
		}
		
		int answer = (a+b) - (temp*2);
		
		System.out.print(answer);
		
		br.close();
	}
}