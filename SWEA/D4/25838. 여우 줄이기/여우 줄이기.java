import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	
    public static void main(String args[]) throws Exception {
    	BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(bReader.readLine());
    	
    	for(int t=0; t<T; t++) {
    		int size = Integer.parseInt(bReader.readLine());
    		String word = bReader.readLine();
    		
    		Stack<Character> stack = new Stack<>();
    		
    		for(int i=0; i<size; i++) {
    			stack.add(word.charAt(i));
    			
    			int len = stack.size();
    			
    			if(3 <= len && 
    					stack.get(len - 3) == 'f' && 
    					stack.get(len - 2) == 'o' && 
    					stack.get(len - 1) == 'x' ) {
    				stack.pop();
    				stack.pop();
    				stack.pop();
    			}
    		}
    		
    		bWriter.write(stack.size() + "\n");
    	}
    	
    	bWriter.close();
    	bReader.close();
    }
}
