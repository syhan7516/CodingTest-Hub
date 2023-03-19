import java.util.Scanner;

public class Main {

    // 피보나치 수, 재귀, 동적계획법 횟수
    public static int fibonacci, recursionCnt, dynamicCnt;

    // 재귀 함수
    static long recursionFibo(long number) {

        if(number==1 || number==2) {
            recursionCnt += 1;
            return 1;
        }

        return recursionFibo(number-1) + recursionFibo(number-2);
    }

    // 동적계획법 함숴
    static long dynamicFibo(long number) {
        long DP[] = new long[41];
        DP[1] = 1;
        DP[2] = 1;
        for(int idx=3; idx<=number; idx++) {
            DP[idx] = DP[idx-1] + DP[idx-2];
            dynamicCnt += 1;
        }

        return DP[(int) number];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 피보나치 수 입력
        fibonacci = scanner.nextInt();

        // 재귀
        recursionCnt = 0;
        recursionFibo(fibonacci);

        // 동적 계획법
        dynamicCnt = 0;
        dynamicFibo(fibonacci);

        // 결과 출력
        System.out.println(recursionCnt+" "+dynamicCnt);
        
        scanner.close();
    }
}
