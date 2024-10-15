import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 센서 개수, 집중국 개수
    public static int answer, sensorCount, centerCount;

    // 센서 위치 정보 배열
    public static int sensorPoints[];

    // 센서 간격 정보 배열
    public static int sensorPointsDistance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 센서 개수, 집중국 개수 입력
        sensorCount = Integer.parseInt(br.readLine());
        centerCount = Integer.parseInt(br.readLine());

        // 센서 위치 정보 배열 생성
        sensorPoints = new int[sensorCount];

        // 센서 위치 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int point=0; point<sensorCount; point++)
            sensorPoints[point] = Integer.parseInt(st.nextToken());

        // 센서 간격 정보 배열 생성
        sensorPointsDistance = new int[sensorCount];

        // 센서 위치 정렬
        Arrays.sort(sensorPoints);

        // 센서 간격 정보 구하기
        for(int point=0; point<sensorCount-1; point++)
            sensorPointsDistance[point] = sensorPoints[point+1]-sensorPoints[point];

        // 센서 간격 작은 순으로 정렬
        Arrays.sort(sensorPointsDistance);

        // 먼 거리 집중국 설치 후 남은 개수
        int existCenterCount = sensorCount-centerCount;

        // 남은 센서가 거리 합 구하기
        for(int point=0; point<=existCenterCount; point++)
            answer += sensorPointsDistance[point];

        // 결과 출력
        System.out.println(answer);
    }
}