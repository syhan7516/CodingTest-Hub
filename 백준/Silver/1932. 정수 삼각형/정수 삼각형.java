import java.util.Scanner;

public class Main {

    public static int result;
    public static int size;
    public static int triangle[][];
    public static int dp[][] = new int[501][501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        result = 0;

        // 삼각형 크기
        size = scanner.nextInt();
        // 삼각형 데이터 입력
        triangle = new int[size+1][size+1];
        for(int a=1; a<=size; a++) {
            for(int b=0; b<a; b++) {
                int num = scanner.nextInt();
                triangle[a][b] = num;
            }
        }
        // 기본 셋팅
        dp[1][0] = triangle[1][0];

        // 층의 수 선택
        for(int floor=2; floor<=size; floor++) {
            for(int locate=0; locate<floor; locate++) {
                if(locate==0) {
                    dp[floor][locate] = triangle[floor][locate] + dp[floor-1][locate];
                }
                else if(locate==floor-1) {
                    dp[floor][locate] = triangle[floor][locate] + dp[floor-1][locate-1];
                }
                else {
                    dp[floor][locate] = triangle[floor][locate] + Integer.max(dp[floor-1][locate-1],dp[floor-1][locate]);
                }
            }
        }

        // 결과 출력
        for(int idx=0; idx<size; idx++) {
            result = Integer.max(result,dp[size][idx]);
        }

        System.out.println(result);
    }
}
