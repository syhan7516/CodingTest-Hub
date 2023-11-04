import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 각 위치
    public static int N, K;

    // 장소
    public static int [] areaCnt;
    public static int [] areaPath;

    // 동생 찾기 메서드
    static void solve() {

        // 위치 저장 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 수빈이 위치 저장
        queue.offer(N);
        areaCnt[N] = 1;
        areaPath[N] = 0;

        // 동생 찾기
        while(!queue.isEmpty()) {

            // 수빈이 현재 위치
            int current = queue.poll();

            // 수빈이가 갈 수 있는 위치
            int [] point = {current*2, current+1, current-1};

            // 위치 확인
            for(int d=0; d<3; d++) {

                // 범위를 벗어난 경우
                if(point[d]<0 || point[d]>100000)
                    continue;

                // 이미 방문한 경우
                if(areaCnt[point[d]]!=0)
                    continue;

                // 이동
                areaPath[point[d]] = current;
                areaCnt[point[d]] = areaCnt[current]+1;
                queue.offer(point[d]);
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
        areaCnt = new int[100001];
        areaPath = new int[100001];

        // 동생 찾기
        solve();

        // 결과 출력
        System.out.println(areaCnt[K]-1);

        // 경로 출력
        Stack<Integer> stack = new Stack<>();
        while(K!=N) {
            stack.push(K);
            K = areaPath[K];
        }

        System.out.print(N+" ");
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }
}