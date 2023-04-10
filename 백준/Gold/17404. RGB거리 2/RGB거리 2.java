import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집의 수 입력
        int houseCnt = Integer.parseInt(br.readLine());

        // 거리 생성
        int rgbTown[][] = new int[houseCnt+1][3];
        int DP[][] = new int[houseCnt+1][3];

        // RGB 비용 입력
        for(int h=1; h<=houseCnt; h++) {
            st = new StringTokenizer(br.readLine());
            rgbTown[h][0] = Integer.parseInt(st.nextToken());
            rgbTown[h][1] = Integer.parseInt(st.nextToken());
            rgbTown[h][2] = Integer.parseInt(st.nextToken());
        }

        // 집에 색깔 칠하기
        int result = Integer.MAX_VALUE;
        for(int rgb=0; rgb<3; rgb++) {

            // 첫 집의 색 칠하기
            for(int first=0; first<3; first++) {
                // 확인하려는 기준 색깔과 같은 경우
                if(rgb==first) {
                    DP[1][first] = rgbTown[1][first];
                }
                // 다른 경우
                else {
                    DP[1][first] = (int)1e9;
                }
            }

            // 나머짖 집 색 칠하기
            for(int h=2; h<=houseCnt; h++) {
                DP[h][0] = Math.min(DP[h-1][1],DP[h-1][2]) + rgbTown[h][0];
                DP[h][1] = Math.min(DP[h-1][0],DP[h-1][2]) + rgbTown[h][1];
                DP[h][2] = Math.min(DP[h-1][0],DP[h-1][1]) + rgbTown[h][2];
            }

            // 마지막 집 색깔 조건 고려
            for(int h=0; h<3; h++) {
                if(h!=rgb && result>DP[houseCnt][h])
                    result = DP[houseCnt][h];
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}