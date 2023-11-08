import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과 저장
    public static StringBuilder sb = new StringBuilder();

    // 숫자 개수, 선택할 수의 개수
    public static int numCnt, selectCnt;

    // 주어진 수 정보 배열, 선택된 수 정보 배열
    public static int [] nums, select;

    // 수 사용 여부 배열
    public static boolean visited[];

    // 수열 구하기 메서드
    static void solve(int depth) {

        // 숫자가 다 선택된 경우
        if(depth==selectCnt) {
            for(int i=0; i<selectCnt; i++) {
                sb.append(select[i]+" ");
            }

            sb.append("\n");
            return;
        }

        // 숫자가 덜 선택된 경우
        for(int i=0; i<numCnt; i++) {
            if(!visited[i]) {
                visited[i] = true;
                select[depth] = nums[i];
                solve(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수, 선택할 수의 개수 입력
        st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 배열 생성
        nums = new int[numCnt];
        select = new int[selectCnt];
        visited = new boolean[numCnt];

        // 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(nums);

        // 수열 구하기
        for(int i=0; i<numCnt; i++) {
            visited[i] = true;
            select[0] = nums[i];
            solve(1);
            visited[i] = false;
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}