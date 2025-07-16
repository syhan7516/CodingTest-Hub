import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb;

    // 숫자 개수
    public static int numCount;

    // 숫자 사용 여부 배열
    public static boolean[] visited;

    // 숫자 정보 배열
    public static int[] nums;

    // 선택된 숫자 정보 배열
    public static int[] selected;

    // 숌 사이 수열 찾기 메서드
    public static void solve(int depth) {

        // 이미 수열을 찾은 경우
        if(sb.length()!=0) return;

        // 숫자 선택이 완료된 경우
        if(depth==selected.length) {
            for(int index=0; index<selected.length; index++) {
                sb.append(selected[index]).append(" ");
            }
            return;
        }

        // 이미 숫자가 놓인 경우
        if(selected[depth]!=-1) {
            solve(depth+1);
            return;
        }

        // 숫자 선택
        for(int index=0; index<nums.length; index++) {

            // 선택되지 못한 숫자인 경우
            if(!visited[index]) {

                // 범위를 넘는 경우
                if((depth+nums[index]+1)>selected.length-1) continue;

                // 이미 숫자가 채워진 경우
                if(selected[depth+nums[index]+1]!=-1) continue;

                // 숫자 선택
                visited[index] = true;
                selected[depth] = nums[index];
                selected[depth+nums[index]+1] = nums[index];
                solve(depth+1);
                visited[index] = false;
                selected[depth] = -1;
                selected[depth+nums[index]+1] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        numCount = Integer.parseInt(br.readLine());

        // 숫자 정보 배열 생성
        nums = new int[numCount];

        // 선택된 숫자 정보 배열 생성
        selected = new int[numCount*2];
        Arrays.fill(selected,-1);

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int num=0; num<nums.length; num++) {
            nums[num] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(nums);

        // 숫자 사용 여부 저장 배열 생성
        visited = new boolean[nums.length];

        // 숌 사이 수열 찾기
        sb = new StringBuilder();
        solve(0);

        // 결과 출력
        System.out.println(sb.length()==0 ? -1 : sb.toString());
    }
}