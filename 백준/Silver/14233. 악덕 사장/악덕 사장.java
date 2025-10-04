import java.util.*;
import java.io.*;

public class Main {

    // 결과, 일 개수
    public static int answer, jobCount;

    // 일 마감 정보 배열
    public static int[] deadline;

    // 가능 여부 확인 메서드
    static boolean canFinishJobsFrom(int time) {
        int total = 0;
        for(int index=0; index<jobCount; index++) {
            total += time;
            if(deadline[index] < total) return false;
        }

        return true;
    }

    // 확인 메서드
    public static void solve() {

        // 범위 초기 설정
        int left = 1;
        int right = deadline[0];

        // 탐색
        while(left <= right) {

            // 값 설정
            int mid = (left+right) / 2;

            // 값 확인
            if(canFinishJobsFrom(mid)) {
                answer = mid;
                left = mid + 1;
            }

            else right = mid - 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일 개수 입력
        jobCount = Integer.parseInt(br.readLine());

        // 일 마감 정보 배열 생성
        deadline = new int[jobCount];

        // 일 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<jobCount; index++) {
            deadline[index] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(deadline);

        // 확인
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}