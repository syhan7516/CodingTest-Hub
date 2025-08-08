import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 땅 개수, 오리 개수
    public static int groundCount, duckCount;

    // 땅 배열
    public static boolean[] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 땅 개수, 오리 개수 입력
        st = new StringTokenizer(br.readLine());
        groundCount = Integer.parseInt(st.nextToken());
        duckCount = Integer.parseInt(st.nextToken());

        // 땅 배열 생성
        ground = new boolean[groundCount+1];

        // 오리 정보 확인
        for(int index=0; index<duckCount; index++) {
            int groundNum = Integer.parseInt(br.readLine());
            int occupiedLand = -1;
            int point = groundNum;

            while(point > 0) {

                // 현재 위치 점유 확인
                if(ground[point]) {
                    occupiedLand = point;
                }

                // 이동
                point /= 2;
            }

            // 이동 가능한 경우
            if(occupiedLand == -1) {
                ground[groundNum] = true;
                sb.append(0).append("\n");
            }

            // 이동 불가능한 경우
            else sb.append(occupiedLand).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}