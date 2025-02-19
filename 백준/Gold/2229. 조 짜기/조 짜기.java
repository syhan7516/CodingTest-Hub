import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 인원 수
    public static int saramCount;

    // 점수, 정도의 합 배열
    public static int[] score, DP;

    // 정도 구하기 메서드
    public static int solve(int start, int end) {

        int maxNum = -1;
        int minNum = 10001;

        for(int index=start; index>=end; index--) {
            maxNum = Math.max(maxNum, score[index]);
            minNum = Math.min(minNum, score[index]);
        }

        return maxNum-minNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인원 수 입력
        saramCount = Integer.parseInt(br.readLine());

        // 점수 정보 배열 생성
        score = new int[saramCount+1];

        // 점수 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=saramCount; index++) {
            score[index] = Integer.parseInt(st.nextToken());
        }

        // 정도의 합 배열 생성
        DP = new int[saramCount+1];

        // 조 짜기
        for(int index=1; index<=saramCount; index++) {

            for(int order=index; order>=1; order--) {
                DP[index] = Math.max(DP[index],DP[order-1]+solve(index,order));
            }
        }

        // 결과 출력
        System.out.println(DP[saramCount]);
    }
}