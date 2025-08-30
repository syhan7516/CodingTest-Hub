import java.io.*;
import java.util.*;

public class Main {

    // 결과
    public static long answer;

    // 마리 수, 질의 수
    public static int cowCount, orderCount;

    // 소 정보 배열
    public static int[] cows;

    // 누적곱 배열
    public static long[] prefixMultiplication;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 마리 수, 질의 수 입력
        st = new StringTokenizer(br.readLine());
        cowCount = Integer.parseInt(st.nextToken());
        orderCount = Integer.parseInt(st.nextToken());

        // 소 정보 배열, 누적합 배열 생성
        cows = new int[cowCount+1];
        prefixMultiplication = new long[cowCount+1];

        // 소 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=cowCount; index++) {
            cows[index] = Integer.parseInt(st.nextToken());
        }

        // 누적곱 계산
        for(int index=1; index<=cowCount; index++) {
            
            // 곱
            int multiplication = 1;

            // 구간 적용
            for(int squance=0; squance<4; squance++) {
                int currentIndex = index + squance;

                // 위치 확인
                if(currentIndex > cowCount) {
                    currentIndex -= cowCount;
                }

                // 누적곱
                multiplication *= cows[currentIndex];
            }

            // 누적곱 저장
            prefixMultiplication[index] = multiplication;

            // 누적합 갱신
            answer += multiplication;
        }

        // 질의 입력
        st = new StringTokenizer(br.readLine());
        for(int order=0; order<orderCount; order++) {

            // 소 위치
            int cowPoint = Integer.parseInt(st.nextToken());

            // 구간 반전
            for(int squance=0; squance<4; squance++) {

                // 위치 확인
                if(cowPoint < 1) {
                    cowPoint += cowCount;
                }

                // 누적합 갱신
                answer -= prefixMultiplication[cowPoint];
                prefixMultiplication[cowPoint] *= -1;
                answer += prefixMultiplication[cowPoint];
                
                // 적용 위치 갱신
                cowPoint--;
            }

            // 결과 저장
            sb.append(answer).append('\n');
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}