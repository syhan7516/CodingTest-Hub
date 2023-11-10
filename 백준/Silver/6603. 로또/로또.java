import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과 저장
    public static StringBuilder sb = new StringBuilder();

    // 숫자 개수
    public static int numCnt;

    // 숫자 정보 배열
    public static int nums[];

    // 로또 번호 뽑기 메서드
    static void solve(int cnt, int idx, String answer) {

        // 숫자를 다 고른 경우
        if(cnt==6) {
            sb.append(answer).append("\n");
            return;
        }

        // 덜 고른 경우
        for(int i=idx; i<numCnt; i++) {
            solve(cnt+1,i+1,answer+nums[i]+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 반복
        while(true) {

            // 숫자 개수 입력
            st = new StringTokenizer(br.readLine());
            numCnt = Integer.parseInt(st.nextToken());

            // 0인 경우
            if(numCnt==0) break;

            // 0이 아닌 경우
            nums = new int[numCnt];
            for(int i=0; i<numCnt; i++)
                nums[i] = Integer.parseInt(st.nextToken());

            // 숫자 뽑기
            for(int i=0; i<numCnt; i++) {
                solve(1,i+1,nums[i]+" ");
            }

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}