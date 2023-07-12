import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 총 개수, 선택 개수
    public static int totalCnt, selectCnt;
    // 숫자 배열
    public static int nums[];
    // 결과 배열
    public static int result[];
    // 방문 배열
    public static boolean visited[];

    // 숫자 선택하기 함수
    static void solve(int depth) {

        // 종료 조건
        if(depth==selectCnt) {
            for(int p: result)
                System.out.print(p+" ");
            System.out.println();
            return;
        }

        // 탐색 진행
        for(int n=0; n<totalCnt; n++) {
            if(!visited[n]) {
                visited[n] = true;
                result[depth] = nums[n];
                solve(depth+1);
                visited[n] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 총 개수, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        totalCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 요소 정보 입력
        nums = new int[totalCnt];

        st = new StringTokenizer(br.readLine());
        for(int n=0; n<totalCnt; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        // 결과 배열
        result = new int[selectCnt];

        // 숫자 정렬
        Arrays.sort(nums);

        // 숫자 선택하기
        int depth=0;
        visited = new boolean[totalCnt];
        for(int n=0; n<totalCnt; n++) {
            if(!visited[n]) {
                visited[n] = true;
                result[depth] = nums[n];
                solve(depth+1);
                visited[n] = false;
            }
        }
    }
}