import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 어린이 수 입력
        int childCnt = Integer.parseInt(br.readLine());

        // 줄 정보 입력
        int DP[] = new int[childCnt+1];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int r=0; r<childCnt; r++) {
            // 번호 차례 입력
            int order = Integer.parseInt(st.nextToken());
            // 해당 번호 앞 자리 연속 여부 확인
            DP[order] = DP[order-1] + 1;
            // 최장 길이 갱신
            result = Math.max(result,DP[order]);
        }
        
        // 결과 출력
        System.out.println(childCnt-result);
    }
}