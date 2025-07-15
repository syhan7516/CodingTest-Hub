import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 도로 구간, 달리 구간
    public static int answer, roadCount, runCount;

    // 도로 구간 배열
    public static int[] roads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도로 구간, 달리 구간 개수 입력
        st = new StringTokenizer(br.readLine());
        roadCount = Integer.parseInt(st.nextToken());
        runCount = Integer.parseInt(st.nextToken());

        // 도로 구간 배열 생성
        roads = new int[101];

        // 도로 구간 정보 입력
        int previousPoint = 0;
        for(int roadIndex=0; roadIndex<roadCount; roadIndex++) {

            // 구간 정보 입력
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            // 구간 시작 위치, 종료 위치
            int startPoint = previousPoint+1;
            int endPoint = previousPoint+point;

            // 제한 속도 저장
            for(int lcoation=startPoint; lcoation<=endPoint; lcoation++) {
                roads[lcoation] = speed;
            }

            // 이전 위치 갱신
            previousPoint = endPoint;
        }

        // 달린 구간 정보 입력
        roads[0] = roads[1];
        previousPoint = 0;
        for(int runIndex=0; runIndex<runCount; runIndex++) {

            // 구간 정보 입력
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            // 구간 시작 위치, 종료 위치
            int startPoint = previousPoint+1;
            int endPoint = previousPoint+point;

            // 달린 속도와 제한 속도 비교
            for(int location=startPoint; location<=endPoint; location++) {

                // 속도 위반한 경우
                if(speed>roads[location]) {
                    answer = Math.max(answer,speed-roads[location]);
                }
            }

            // 이전 위치 갱신
            previousPoint = endPoint;

        }

        // 결과 출력
        System.out.println(answer);
    }
}