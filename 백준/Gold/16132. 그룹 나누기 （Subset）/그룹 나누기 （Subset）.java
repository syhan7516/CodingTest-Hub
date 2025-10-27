import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 학생 수
    public static long num, target;

    // DP 배열 생성
    public static long[][] DP;

    // 경우의 수 확인 메서드
    public static long solve(int currentNum, int count) {

        // 학생 수보다 많거나 합을 초과하는 경우
        if (currentNum>num || count>target) return 0;

        // 합이 목표에 도달한 경우
        if (count == target) return 1;

        // 이미 값을 구한 경우
        if (DP[currentNum][count] != -1) return DP[currentNum][count];

        // 계산
        return DP[currentNum][count] = solve(currentNum+1, count) + solve(currentNum+1, count+currentNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수 입력
        num = Long.parseLong(br.readLine());

        // 합 계산
        target = num * (num+1) / 2;

        // 전체 합이 홀수인 경우
        if(target%2 != 0) {
            System.out.println(0);
        }
        
        else {
            
            // 합의 절반
            target /= 2;

            // DP 테이블 생성
            DP = new long[(int)(num+2)][(int)(target+2)];

            // 초기화
            for(int index=0; index<=num+1; index++) {
                Arrays.fill(DP[index], -1);
            }

            // 경우의 수 확인
            System.out.println(solve(1, 0));
        }
    }
}