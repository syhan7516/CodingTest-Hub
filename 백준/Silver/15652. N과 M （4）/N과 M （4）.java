import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // 결과 저장
    public static StringBuilder sb = new StringBuilder();

    // 중복 확인 해시
    public static HashMap<String,Boolean> visited;

    // 수의 개수, 선택할 수
    public static int numCnt, selectCnt;

    // 중복 순열
    static void solve(int cnt, int idx, String nums) {

        // 수를 다 고른 경우
        if(cnt==selectCnt) {

            // 중복이 아닌 경우
            if(!visited.containsKey(nums)) {
                sb.append(nums).append("\n");
                visited.put(nums,true);
            }
            return;
        }

        // 수를 덜 고른 경우
        for(int i=idx; i<=numCnt; i++)
            solve(cnt+1,i,nums+i+" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수의 개수, 선택할 수 입력
        st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 중복 확인 해쉬
        visited = new HashMap<>();

        // 중복 순열
        for(int i=1; i<=numCnt; i++)
            solve(1,i,i+" ");

        // 결과 출력
        System.out.println(sb.toString());
    }
}