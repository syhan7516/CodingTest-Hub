import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 하늘의 가로, 세로 길이 입력
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 트랜펄린 크기 입력
        int toolSize = Integer.parseInt(st.nextToken());

        // 별의 개수 입력
        int starCnt = Integer.parseInt(st.nextToken());

        // 별의 위치 입력
        int starPoint[][] = new int[starCnt][2];
        for (int s= 0; s < starCnt; s++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            starPoint[s][0] = x;
            starPoint[s][1] = y;
        }

        // 각 x에 대해 각 y로 트랜펄린 위치 놓기
        int result = Integer.MIN_VALUE;
        for (int a = 0; a < starCnt; a++) {
            for (int b = 0; b < starCnt; b++) {
                int count = 0;
                int toolX = starPoint[a][0];
                int toolY = starPoint[b][1];

                // 모든 별의 위치 확인
                for(int s=0; s<starCnt; s++) {
                    int pointX = starPoint[s][0];
                    int pointY = starPoint[s][1];
                    if(pointX>=toolX && pointX<=toolX+toolSize && pointY>=toolY && pointY<=toolY+toolSize)
                        count += 1;
                }

                // 별의 개수 갱신
                result = Math.max(result, count);
            }
        }

        // 결과 출력
        System.out.println(starCnt-result);
    }
}