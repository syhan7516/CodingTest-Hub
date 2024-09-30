import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 로또 번호 개수
    public static final int LOTTO_COUNT = 6;

    // 숫자 개수
    public static int numCnt;

    // 숫자 배열
    public static int nums[];

    // 방문 여부 배열
    public static boolean visited[];

    // 빌더
    public static StringBuilder sb = new StringBuilder();

    // 로또 만들기 메서드
    public static void solve(int idx, int cnt) {

        // 숫자를 다 고른 경우
        if(cnt==LOTTO_COUNT) {

            // 선택된 숫자 저장
            for(int i=0; i<numCnt; i++)
                if(visited[i]) sb.append(nums[i]).append(" ");
            sb.append("\n");

            return;
        }

        // 숫자 고르기
        for(int i=idx; i<numCnt; i++) {
            visited[i] = true;
            solve(i+1,cnt+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {

            // 숫자 개수 입력
            st = new StringTokenizer(br.readLine());
            numCnt = Integer.parseInt(st.nextToken());

            // 숫자 개수가 0개인 경우
            if(numCnt==0) break;

            // 숫자 배열 생성
            nums = new int[numCnt];

            // 방문 여부 배열 생성
            visited = new boolean[numCnt];

            // 숫자 입력
            for(int i=0; i<numCnt; i++)
                nums[i] = Integer.parseInt(st.nextToken());

            // 로또 만들기
            solve(0,0);
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}