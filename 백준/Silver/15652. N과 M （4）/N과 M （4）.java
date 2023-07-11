import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 총 개수, 선택 개수
    public static int totalCnt, selectCnt;

    // 결과 배열
    public static int result[];

    // 숫자 선택하기 함수
    static void solve(int number, int idx) {

        // 종료 조건
        if(idx==selectCnt) {
            for(int p: result)
                System.out.print(p+" ");
            System.out.println();
            return;
        }

        // 탐색 진행
        for(int n=number; n<=totalCnt; n++) {
            result[idx] = n;
            solve(n,idx+1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 총 개수, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        totalCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 결과 배열
        result = new int[selectCnt];

        // 숫자 선택하기
        int idx=0;
        for(int n=1; n<=totalCnt; n++) {
            result[idx] = n;
            solve(n,idx+1);
        }
    }
}