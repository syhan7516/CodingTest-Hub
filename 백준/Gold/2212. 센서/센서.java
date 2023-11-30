import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 센서의 개수 입력
        int sensorCnt = Integer.parseInt(br.readLine());

        // 집중국의 개수 입력
        int centerCnt = Integer.parseInt(br.readLine());

        // 집중국의 개수가 센서 수보다 같거나 큰 경우
        if(centerCnt>=sensorCnt)
            System.out.println(0);

        // 아닌 경우
        else {
            // 센서 좌표 배열 생성
            int sensor[] = new int[sensorCnt];

            // 좌표 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<sensorCnt; i++) {
                sensor[i] = Integer.parseInt(st.nextToken());
            }

            // 좌표 정렬
            Arrays.sort(sensor);

            // 좌표 차이 저장 배열 생성
            int diff[] = new int[sensorCnt-1];

            // 좌표 차이 구하기
            for(int i=0; i<sensorCnt-1; i++) {
                diff[i] = sensor[i+1]-sensor[i];
            }

            // 좌표 차이 배열 정렬
            Arrays.sort(diff);

            // 최선의 구간 길이 구하기
            int distance = 0;
            for(int i=0; i<sensorCnt-centerCnt; i++) {
                distance += diff[i];
            }

            // 결과 출력
            System.out.println(distance);
        }
    }
}