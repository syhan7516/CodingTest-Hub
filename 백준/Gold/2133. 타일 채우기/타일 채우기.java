import java.io.*;

public class Main {

    // 타일 채우기 메서드
    public static int solve(int size) {

        // DP 배열 생성
        int[] DP = new int[size+1];

        // 크기가 홀수인 경우
        if(size%2 != 0) return 0;

        // 배열 초기 설정
        DP[0] = 1;
        DP[1] = 0;
        DP[2] = 3;

        // 타일 채우기
        for(int a=4; a<=size; a+=2) {
            DP[a] = DP[a-2] * DP[2];
            for(int b=a-4; b>=0; b-=2) {
                DP[a] = DP[a] + (DP[b] * 2);
            }
        }

        return DP[size];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 타일 채우기
        System.out.println(solve(size));
    }
}