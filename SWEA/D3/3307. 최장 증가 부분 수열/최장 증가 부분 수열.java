import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 수열의 길이 입력
            int numSetLen = Integer.parseInt(br.readLine());
            int numSet[] = new int[numSetLen];
            int DP[] = new int[numSetLen];

            // 수열의 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<numSetLen; n++) {
                numSet[n] = Integer.parseInt(st.nextToken());
            }

            // 최장 증가 수열 길이 계산
            DP[0] = 1;
            for(int a=1; a<numSet.length; a++) {
                int curLen = 1;
                int curNum = numSet[a];
                for(int b=a-1; b>=0; b--) {
                    // 자신보다 작은 수를 찾은 경우
                    if(curNum>numSet[b]) {
                        curLen = Math.max(DP[b]+1,curLen);
                    }
                }
                // 더 많은 길이 저장
                DP[a] = Math.max(DP[a],curLen);
            }

            // 결과 저장
            Arrays.sort(DP);
            sb.append("#"+(caseIdx+1)+" "+DP[DP.length-1]+"\n");

        }
        // 결과 출력
        System.out.println(sb.toString());
    }
}