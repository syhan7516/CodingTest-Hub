import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 평면 배열 생성
        int visited[][] = new int[1001][1001];

        // 색종이 개수
        int paperCnt = Integer.parseInt(br.readLine());

        // 색종이 넓이 배열 생성
        int area[] = new int[paperCnt+1];

        // 위치 정보 입력
        for(int i=1; i<=paperCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = startX+Integer.parseInt(st.nextToken());
            int endY = startY+Integer.parseInt(st.nextToken());

            // 종이 올리기
            for(int j=startY; j<endY; j++) {
                for(int k=startX; k<endX; k++) {

                    // 아무것도 없는 경우
                    if(visited[j][k]!=0)
                        area[visited[j][k]]--;

                    // 방문 처리
                    visited[j][k] = i;
                    area[i]++;
                }
            }
        }

        // 결과 출력
        for(int i=1; i<=paperCnt; i++) {
            if(area[i]<0) System.out.println(0);
            else System.out.println(area[i]);
        }
    }
}