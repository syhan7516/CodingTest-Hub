import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static StringBuilder sb = new StringBuilder();

    // 방문 여부 해시 맵
    public static HashMap<String, Boolean> map;

    // 수의 개수, 선택할 수의 개수
    public static int numCnt, selectCnt;

    // 수 배열, 선택된 수 배열
    public static int nums[];
    public static int select[];

    // 수 나열 메서드
    static void solve(int cnt) {

        // 수가 다 선택된 경우
        if(cnt==selectCnt) {

            // 수열이 겹치지 않는 경우
            if(!map.containsKey(Arrays.toString(select))) {
                map.put(Arrays.toString(select),true);
                for(int data: select)
                    sb.append(data).append(" ");
                sb.append("\n");
            }

            return;
        }

        // 수가 덜 선택된 경우
        for(int i=0; i<numCnt; i++) {
            select[cnt] = nums[i];
            solve(cnt+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수의 개수, 선택할 수의 개수 입력
        st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        selectCnt = Integer.parseInt(st.nextToken());

        // 수 배열 생성
        nums = new int[numCnt];
        select = new int[selectCnt];

        // 수 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(nums);

        // 수 나열
        map = new HashMap<>();
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}