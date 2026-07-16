import java.util.Arrays;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {        
        Arrays.sort(A);
        B = Arrays.stream(B)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

        int answer = 0;
        for(int i=0; i<A.length; i++){
            answer += A[i]*B[i];
        }
        
        return answer;
    }
}