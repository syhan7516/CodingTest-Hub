import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 N 입력
        int N = Integer.parseInt(br.readLine());

        // 전체 크기
        int room[] = new int[1001];
        room[1] = 1;
        room[2] = 2;

        // 점화식
        for(int r=3; r<=N; r++) {
            room[r] = (room[r-1]+room[r-2])%10007;
        }

        // 결과 출력
        System.out.println(room[N]);
    }
}