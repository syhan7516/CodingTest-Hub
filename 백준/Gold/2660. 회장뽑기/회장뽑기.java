import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 회원 수, 결과
    public static int clientCnt, answer;

    // 방문 여부
    public static boolean visited[];

    // 친구 관계 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 후보 리스트
    public static ArrayList<Integer> result;

    // 점수 매기기 메서드
    static void solve(int saram) {

        // 관계 저장 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 첫 사람 처리
        visited[saram] = true;
        queue.offer(saram);

        // 현재 깊이 친구 수, 점수
        int size = 1;
        int score = 0;

        // 관계 확인
        while(!queue.isEmpty()) {

            // 현재 깊이 친구 수를 다 본 경우
            if(size==0) {
                size = queue.size();
                score++;
            }

            // 확인 할 사람
            int current = queue.poll();

            // 기준 관계 확인
            for(int i=0; i<list.get(current).size(); i++) {

                // 친구
                int friend = list.get(current).get(i);

                // 미방문인 경우
                if(!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(friend);
                }
            }

            // 감소
            size--;
        }

        // 후보 갱신
        if(answer>=score) {

            // 점수가 더 낮은 경우
            if(answer>score) {
                result = new ArrayList<>();
                answer = score;
            }

            // 후보 추가
            result.add(saram);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 회원 수 입력
        clientCnt = Integer.parseInt(br.readLine());

        // 관계 리스트 생성
        list = new ArrayList<>();
        for(int i=0; i<=clientCnt; i++)
            list.add(new ArrayList<>());

        // 관계 입력
        while(true) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // -1, -1 인 경우
            if(from==-1 && to==-1) break;

            // 관계 추가
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 점수 매기기
        answer = Integer.MAX_VALUE;
        result = null;
        for(int i=1; i<=clientCnt; i++) {
            visited = new boolean[clientCnt+1];
            solve(i);
        }

        // 결과 출력
        sb.append(answer).append(" ").append(result.size()).append("\n");
        Collections.sort(result);
        for(int data: result)
            sb.append(data).append(" ");
        System.out.println(sb.toString());
    }
}