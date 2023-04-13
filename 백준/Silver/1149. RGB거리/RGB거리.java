import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집의 수 입력
        int houseCnt = Integer.parseInt(br.readLine());

        // 기본 셋팅
        int house[][] = new int[houseCnt+1][3];

        // 각 집의 페인트 비용 입력
        for(int h=1; h<houseCnt+1; h++) {
            st = new StringTokenizer(br.readLine());
            house[h][0] = Integer.parseInt(st.nextToken());
            house[h][1] = Integer.parseInt(st.nextToken());
            house[h][2] = Integer.parseInt(st.nextToken());
        }

        // 페인트 칠하기
        int result = Integer.MAX_VALUE;
        
        // 각 첫 집을 색칠할 색을 위해 반복문 3번
        for(int rgb=0; rgb<3; rgb++) {
            
            // 각 색깔별로 DP 테이블 생성
            int DP[][] = new int[houseCnt+1][3];
            // 해당 색깔 첫 집 칠하기 (나머지는 임의의 많은 값으로 설정)
            for(int a=0; a<3; a++) {
                if(rgb==a)
                    DP[1][a] = house[1][a];
                else
                    DP[1][a] = (int)1e9;
            }

            // 비용을 더 싸게 칠하기
            for(int b=2; b<=houseCnt; b++) {
                DP[b][0] = house[b][0] + Math.min(DP[b-1][1],DP[b-1][2]);
                DP[b][1] = house[b][1] + Math.min(DP[b-1][0],DP[b-1][2]);
                DP[b][2] = house[b][2] + Math.min(DP[b-1][0],DP[b-1][1]);
            }

            // 최소 비용 갱신
            int curResult = Math.min(DP[houseCnt][0],Math.min(DP[houseCnt][1],DP[houseCnt][2]));
            result = Math.min(result,curResult);
        }

        // 결과 출력
        System.out.println(result);
    }
}