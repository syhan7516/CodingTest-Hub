import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기 입력
        int blockSize = Integer.parseInt(br.readLine());

        // 타일링 크기 홀수인 경우
        if(blockSize%2!=0) {
            System.out.println(0);
            return;
        }
        
        // DP 테이블
        int DP[] = new int[31];
        
        // 테이블 초기화
        DP[0] = 1;
        DP[1] = 0;
        DP[2] = 3;
        
        // 타일링 수행
        for(int t=4; t<=30; t+=2) {
            // 기본 타일 : 매 짝수 번마다 이전의 3배
            DP[t] = DP[t-2]*3;
            for(int p=t-4; p>=0; p-=2)
                DP[t] = DP[t]+(DP[p]*2);
        }
        
        // 결과 출력
        System.out.println(DP[blockSize]);
    }
}