import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static int result[];

    // 유저 수, 친구 관계 수
    public static int userCnt, relCnt;

    // 관계 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 방문 여부 배열
    public static boolean visited[];

    // 점수 매기기 메서드
    static void solve(int saram) {

        // 관계 저장 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 첫 사람 처리
        queue.offer(saram);
        visited[saram] = true;

        // 점수, 깊이, 깊이 크기
        int score = 0;
        int deep = 0;
        int size = queue.size();

        // 관계 확인
        while(!queue.isEmpty()) {

            // 깊이 크기를 다 확인한 경우
            if(size==0) {
                size = queue.size();
                deep++;
            }

            // 확인 할 사람
            int current = queue.poll();

            // 기준 사람 관계 확인
            for(int i=0; i<list.get(current).size(); i++) {

                // 친구
                int friend = list.get(current).get(i);

                // 미방문인 경우
                if(!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(friend);
                    score += deep;
                }
            }
            
            // 크기 감소
            size--;
        }

        // 점수 갱신
        if(result[1]>=score) {

            // 점수가 같은 경우
            if(result[1]==score)
                result[0] = Math.min(result[0],saram);

            // 점수가 더 작은 경우
            else {
                result[0] = saram;
                result[1] = score;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 유저, 관계 수 입력
        st = new StringTokenizer(br.readLine());
        userCnt = Integer.parseInt(st.nextToken());
        relCnt = Integer.parseInt(st.nextToken());

        // 관계 리스트 생성
        list = new ArrayList<>();
        for(int i=0; i<=userCnt; i++)
            list.add(new ArrayList<>());

        // 관계 정보 입력
        for(int i=0; i<relCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 결과
        result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MAX_VALUE;

        // 점수 매기기
        for(int i=1; i<=userCnt; i++) {
            visited = new boolean[userCnt+1];
            solve(i);
        }

        // 결과 출력
        System.out.println(result[0]);
    }
}