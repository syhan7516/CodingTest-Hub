import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // MOD
    public static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기, 선택 수 입력
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int selectCount = Integer.parseInt(st.nextToken());

        // 배열 생성
        int[][] DP = new int[size+1][selectCount+1];

        // 초기화
        for(int index=0; index<=size; index++) {
            DP[index][1] = 1;
        }

        for(int index=1; index<=selectCount; index++) {
            DP[0][index] = 1;
        }

        // 경우의 수 구하기
        for(int num=1; num<=size; num++) {
            for(int count=2; count<=selectCount; count++) {
                DP[num][count] = (DP[num][count-1] + DP[num-1][count]) % MOD;
            }
        }

        // 결과 출력
        System.out.println(DP[size][selectCount]);
    }
}