import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 노드 개수
    public static int answer, nodeCount;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 목표, 색깔 배열
    public static int[] targets;

    // 방문 여부 배열
    public static boolean[] visited;

    // 탐색 메서드
    public static void solve(int node, int parentColor) {

        // 연결 노드 확인
        for(int index=0; index<relations.get(node).size(); index++) {
            int connected = relations.get(node).get(index);

            // 이미 방문한 경우
            if(visited[connected]) continue;

            // 방문 처리
            visited[connected] = true;

            // 목표 색깔이 현재 색깔과 다른 경우
            if(targets[connected] != parentColor) {
                answer++;
                solve(connected, targets[connected]);
            }

            else solve(connected, parentColor);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 목표, 색깔 배열 생성
        targets = new int[nodeCount+1];

        // 색깔 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=nodeCount; index++) {
            targets[index] = Integer.parseInt(st.nextToken());
        }

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // 방문 여부 배열 생성
        visited = new boolean[nodeCount+1];

        // 탐색
        answer = targets[1] == 0 ? 0 : 1;
        visited[1] = true;
        solve(1, targets[1]);

        // 결과 출력
        System.out.println(answer);
    }
}