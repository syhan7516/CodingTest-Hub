import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 각 위치, 결과
    public static int N, K, answer;

    // 장소
    public static int [] area;

    // 동생 찾기 메서드
    static void solve() {

        // 위치 저장 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 수빈이 위치 저장
        queue.offer(N);
        area[N] = 0;

        // 동생 찾기
        while(!queue.isEmpty()) {

            // 수빈이 현재 위치
            int current = queue.poll();

            // 수빈이가 갈 수 있는 위치
            int [] point = {current*2, current+1, current-1};
            int [] time = {0,1,1};

            // 위치 확인
            for(int d=0; d<3; d++) {

                // 범위를 벗어난 경우
                if(point[d]<0 || point[d]>100000)
                    continue;

                // 비용이 더 적게든 경우
                if(area[point[d]]>area[current]+time[d]) {
                    queue.offer(point[d]);
                    area[point[d]] = area[current]+time[d];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 각 위치 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 장소 생성
        area = new int[100001];

        // 위치 최대 값 셋팅
        Arrays.fill(area,(int)1e9);

        // 동생 찾기
        solve();
        answer = area[K];

        // 결과 출력
        System.out.println(answer);
    }
}