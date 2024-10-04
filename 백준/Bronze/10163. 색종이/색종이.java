import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 평면 배열 생성
        int visited[][] = new int[1002][1002];

        // 색종이 개수
        int paperCnt = Integer.parseInt(br.readLine());

        // 결과 해시 생성
        HashMap<Integer,Integer> area = new HashMap<>();

        // 위치 정보 입력
        for(int i=1; i<=paperCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = startY+Integer.parseInt(st.nextToken());
            int endX = startX+Integer.parseInt(st.nextToken());


            // 색종이 넓이
            int current = 0;

            // 종이 올리기
            for(int j=startY; j<endY; j++) {
                for(int k=startX; k<endX; k++) {

                    // 아무것도 없는 경우
                    if(visited[j][k]!=0)
                        area.put(visited[j][k], area.get(visited[j][k])-1);

                    // 방문 처리
                    visited[j][k] = i;
                    current++;
                }
            }

            // 결과 저장
            area.put(i,current);
        }

        // 결과 출력
        for(int i=1; i<=paperCnt; i++) {
            int result = area.get(i);
            if(result<0) System.out.println(0);
            else System.out.println(result);
        }
    }
}