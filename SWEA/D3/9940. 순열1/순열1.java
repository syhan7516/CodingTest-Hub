import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            String result = "Yes";
            // N 입력
            int N = Integer.parseInt(br.readLine());
            // 순열
            int permutation[] = new int[N];
            // 순열 입력
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<N; idx++)
                permutation[idx] = Integer.parseInt(st.nextToken());
            // 확인
            Arrays.sort(permutation);
            for(int idx=0; idx<N; idx++) {
                if(permutation[idx]!=idx+1)
                    result = "No";
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}