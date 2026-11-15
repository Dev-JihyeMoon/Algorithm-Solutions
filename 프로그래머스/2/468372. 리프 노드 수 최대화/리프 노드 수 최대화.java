import java.util.*;

class Solution {
    static long standard, answer=1;
    
    public int solution(int dist_limit, int split_limit) {
        standard = split_limit;
        dfs(1, 1, 1, dist_limit);
        
        return (int) answer;
    }
    
    public static void dfs(long split, long totalLeaves, long curNodes, long count) {
        // 지금까지 모인 totalLeaves로 answer 최댓값 갱신
        answer = Math.max(answer, totalLeaves);
        
        // 더 이상 쓸 수 있는 dist_limit이 없거나
        //현재 층에 후보 노드가 없으면(curNodes == 0) 탐색 종료
        if(count == 0 || curNodes==0){
            return;
        }

        // 현재 층 후보 노드(curNodes)와 남은 기회(remainDist) 중 더 작은 값만큼만 분배 노드로 사용 가능
        long use = Math.min(curNodes, count);

        // (다음 층 탐색) 자식 수를 2개 또는 3개로 선택해서 내려가기
        for (int i = 2; i <= 3; i++) {
            long nextSplit = split * i; // 다음 층의 분배도 계산
            
            // (가지치기) 다음 분배도가 standard 이하일 때만 진행
            if (nextSplit <= standard) {
                // 다음 층의 totalLeaves 계산
                long nextLeaves = totalLeaves - use + (use * i);
                // 다음 층의 후보 노드 개수(nextNodes) 계산
                long nextNodes = use * i;

                // 남은 dist_limit(remainDist - use)과 함께 dfs 재귀 호출
                dfs(nextSplit, nextLeaves, nextNodes, count - use);
            }
        }
    }
}