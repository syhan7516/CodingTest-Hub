
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 인접 리스트
    public static ArrayList<ArrayList<Integer>> nodes;
    // 정점, 간선 수
    public static int nodeCnt, edgeCnt;
    // 분류 집합 배열
    public static int setArr[];
    // 분류 집합
    public static int firSet, secSet;

    // 탐색 수행 함수
    static boolean bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        setArr[node] = firSet;
        queue.offer(node);

        while(!queue.isEmpty()) {
            // 현재 노드
            int curNode = queue.poll();
            // 인접한 노드 확인
            for(int n=0; n<nodes.get(curNode).size(); n++) {
            // 확인할 노드
            int connectNode = nodes.get(curNode).get(n);
                // 같은 그룹일 경우
                if(setArr[curNode]==setArr[connectNode]) return false;

                // 아닐 경우

                // 미방문 노드
                if(setArr[connectNode]==0) {
                    // 반대 그룹
                    setArr[connectNode] = setArr[curNode]*(-1);
                    // 큐에 저장
                    queue.offer(connectNode);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정점의 수, 간선의 수 입력
            st = new StringTokenizer(br.readLine());
            nodeCnt = Integer.parseInt(st.nextToken());
            edgeCnt = Integer.parseInt(st.nextToken());

            // 인접 리스트 초기화
            nodes = new ArrayList<>();
            for(int n=0; n<=nodeCnt; n++)
                nodes.add(new ArrayList<>());

            // 연결 정보 입력
            for(int e=0; e<edgeCnt; e++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                nodes.get(from).add(to);
                nodes.get(to).add(from);
            }

            // 탐색 수행
            String result = "YES";
            setArr = new int[nodeCnt+1];
            firSet = 1;
            secSet = -1;
            for(int n=1; n<=nodeCnt; n++) {
                // 미탐색인 경우
                if(setArr[n]==0) {
                    // 이분 그래프가 아닌 경우
                    if(bfs(n)==false) {
                        result = "NO";
                        break;
                    }
                }
            }

            // 결과 출력
            System.out.println(result);
        }
    }
}