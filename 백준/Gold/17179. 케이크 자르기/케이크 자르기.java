import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 횟수, 위치 수, 케이크 길이
    public static int answer, tryCount, pointCount, cakeLength;

    // 위치 배열
    public static int points[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 횟수, 위치 수, 케이크 길이 입력
        st = new StringTokenizer(br.readLine());
        tryCount = Integer.parseInt(st.nextToken());
        pointCount = Integer.parseInt(st.nextToken());
        cakeLength = Integer.parseInt(st.nextToken());

        // 위치 배열 생성
        points = new int[pointCount+1];

        // 위치 입력
        for(int point=0; point<pointCount; point++)
            points[point] = Integer.parseInt(br.readLine());
        points[pointCount] = cakeLength;

        // 자르기 횟수
        for(int cutTry=0; cutTry<tryCount; cutTry++) {

            // 결과
            answer = 0;

            // 횟수 입력
            int targetCutCount = Integer.parseInt(br.readLine());

            // 위치 설정
            int left = 0;
            int right = cakeLength;

            // 자르기 시도
            while(left<=right) {

                // 자른 케이크 수
                int cutCount = 0;

                // 이전 자른 위치
                int preCutPoint = 0;

                // 자를 위치 설정
                int mid = (left+right)/2;

                // 자르기 가능한 위치 확인
                for(int point=0; point<=pointCount; point++) {

                    // 자른 케이크 크기 확인
                    int cutTryResult = points[point]-preCutPoint;

                    // 자른 케이크 길이가 자르는 위치보다 같거나 큰 경우
                    if(cutTryResult>=mid) {
                        ++cutCount;
                        preCutPoint = points[point];
                    }
                }

                // 자른 결과 확인
                if (cutCount>targetCutCount) {
                    left = mid+1;
                    answer = Math.max(answer,mid);
                }

                else right = mid-1;
            }

            // 결과 출력
            System.out.println(answer);
        }
    }
}