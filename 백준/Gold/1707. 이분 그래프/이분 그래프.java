import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 정점 수, 간선 수
    public static int vCnt, eCnt;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 소속 그룹 정보 배열
    public static int group[];

    // 이분 그래프 확인 메서드
    static boolean solve(int node) {

        // 인접 정보 저장 큐
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드 처리
        group[node] = 1;
        queue.offer(node);

        // 모든 노드 확인
        while(!queue.isEmpty()) {

            // 기준 노드
            int current = queue.poll();

            // 인접한 노드 확인
            for(int i=0; i<list.get(current).size(); i++) {

                // 확인 노드
                int n = list.get(current).get(i);

                // 미방문 노드인 경우
                if(group[n]==0) {
                    group[n] = group[current]*(-1);
                    queue.offer(n);
                }

                // 방문된 노드인 경우
                else {

                    // 같은 집합인 경우
                    if(group[n]==group[current])
                        return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입려
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정점, 간선 수 입력
            st = new StringTokenizer(br.readLine());
            vCnt = Integer.parseInt(st.nextToken());
            eCnt = Integer.parseInt(st.nextToken());

            // 연결 정보 리스트 생성
            list = new ArrayList<>();
            for(int i=0; i<=vCnt; i++)
                list.add(new ArrayList<>());

            // 연결 정보 입력
            for(int i=0; i<eCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int from= Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);
            }

            // 이분 그래프 확인
            boolean res = true;
            group = new int[vCnt+1];
            for(int i=1; i<=vCnt; i++) {

                // 미방문 노드인 경우
                if(group[i]==0) {
                    res = solve(i);
                    if(!res) break;
                }
            }

            // 결과 확인
            if(res) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}