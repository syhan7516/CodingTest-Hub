import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String answer = "권병장님, 중대장님이 찾으십니다";

        // 인원 입력
        int armyCount = Integer.parseInt(br.readLine());

        // 좌표, 사거리 배열 생성
        int[] points = new int[armyCount];
        int[] distances = new int[armyCount];

        // 전우 좌표 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<armyCount; index++) {
            points[index] = Integer.parseInt(st.nextToken());
        }

        // 2명 이상인 경우
        if(armyCount >= 2) {

            // 전우 사거리 입력
            st = new StringTokenizer(br.readLine());
            for(int index=0; index<armyCount-1; index++) {
                distances[index] = Integer.parseInt(st.nextToken());
            }
            distances[armyCount-1] = 0;

            // 전우 확인
            int startPoint = points[0];
            int endPoint = startPoint + distances[0];

            for(int index=1; index<armyCount; index++) {
                int point = points[index];
                int distance = distances[index];

                // 사거리 범위인 경우
                if(point<=endPoint) {
                    endPoint = Math.max(endPoint,point+distance);
                }

                else {
                    answer = "엄마 나 전역 늦어질 것 같아";
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}