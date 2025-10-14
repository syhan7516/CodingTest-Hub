import java.io.*;
import java.util.StringTokenizer;


public class Main {

    // 최대값
    public static final int MAX_VALUE = 1000000;

    // 결과, 집 개수
    public static int answer, houseCount;

    // 비용 저장 배열, 비용 누적 배열
    public static int[][] cost, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 집 개수 입력
        houseCount = Integer.parseInt(br.readLine());

        // 배열 생성
        cost = new int[houseCount+1][3];
        sum = new int[houseCount+1][3];

        // 비용 입력
        for(int house=1; house<=houseCount; house++) {
            st = new StringTokenizer(br.readLine());
            for(int color=0 ; color<3; color++) {
                cost[house][color] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과 초기화
        answer = MAX_VALUE;

        // 시작 색깔 순회
        for(int color=0; color<3; color++) {

            // 시작 색깔 이외 모두 큰 값으로 초기화
            for(int startColor=0 ; startColor<3; startColor++) {
                if(startColor == color) sum[1][startColor] = cost[1][startColor];
                else sum[1][startColor] = MAX_VALUE;
            }

            // 조건에 맞게 색칠 비용 확인
            for (int house=2; house<=houseCount; house++) {
                sum[house][0] = Math.min(sum[house-1][1], sum[house-1][2]) + cost[house][0];
                sum[house][1] = Math.min(sum[house-1][0], sum[house-1][2]) + cost[house][1];
                sum[house][2] = Math.min(sum[house-1][0], sum[house-1][1]) + cost[house][2];
            }

            // 최솟값 확인
            for(int index=0 ; index<3; index++)
                if(index != color) {
                    answer = Math.min(answer, sum[houseCount][index]);
                }
        }

        // 결과 출력
        System.out.println(answer);
    }
}