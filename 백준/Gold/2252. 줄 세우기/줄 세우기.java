import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 사람 수, 비교 수
    public static int personCnt, compareCnt;
    // 인접 노드 리스트
    public static ArrayList<ArrayList<Integer>> node;
    // 진입 차수 배열
    public static int degree[];
    // 차수 0 저장 큐
    public static Queue<Integer> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수, 비교 수 입력
        personCnt = Integer.parseInt(st.nextToken());
        compareCnt = Integer.parseInt(st.nextToken());

        // 기본 셋팅
        node = new ArrayList<>();
        for(int idx=0; idx<=personCnt; idx++)
            node.add(new ArrayList<>());

        degree = new int[personCnt+1];
        Arrays.fill(degree,0);

        // 비교 정보 입력
        for(int idx=0; idx<compareCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            node.get(startNode).add(endNode);
            degree[endNode] += 1;
        }

        // 0차수 찾기
        queue = new LinkedList<>();
        for(int idx=1; idx<=personCnt; idx++) {
            if(degree[idx]==0)
                queue.offer(idx);
        }

        // 정렬
        while(!queue.isEmpty()) {
            // 0차수 노드
            int nodeNum = queue.poll();
            // 연결 정보 확인
            for(int connect=0; connect<node.get(nodeNum).size(); connect++) {
                int connectNode = node.get(nodeNum).get(connect);
                degree[connectNode] -= 1;
                if(degree[connectNode]==0)
                    queue.offer(connectNode);
            }
            // 결과 출력
            System.out.print(nodeNum+" ");
        }
    }
}