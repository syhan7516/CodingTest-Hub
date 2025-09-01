import java.io.*;
import java.util.*;

public class Main {

    // 결과, 노드 개수, 방문 가능한 횟수
    public static int answer, nodeCount, maxCanVisitCount;

    // 노드 사과 정보 배열, 방문 가능한 최대 노드 수 저장 배열
    public static int[] apples, maxCanVisitNodeSize;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // DP 배열
    public static int[][] DP;

    // 탐색 메서드
    public static void solve(int node) {

        // 자기 자신 포함시키기
        DP[node][1] = apples[node];
        maxCanVisitNodeSize[node] = 1;

        // 자식 서브트리 합차기
        for(int index=0; index<relations.get(node).size(); index++) {

            // 연결된 자식 노드
            int connectedNode = relations.get(node).get(index);

            // 자식 노드 탐색
            solve(connectedNode);

            // 임시 배열 생성
            int[] mock = new int[maxCanVisitCount+1];

            // 노드 확인
            for(int selectNodeCount=1; selectNodeCount<=maxCanVisitNodeSize[node]; selectNodeCount++) {
                for(int addNodeCount=1; addNodeCount<=maxCanVisitNodeSize[connectedNode] && selectNodeCount+addNodeCount<=maxCanVisitCount; addNodeCount++) {
                    mock[selectNodeCount+addNodeCount]
                            = Math.max(mock[selectNodeCount+addNodeCount], DP[node][selectNodeCount] + DP[connectedNode][addNodeCount]);
                }
            }

            // 해당 노드 정보 갱신
            for(int visitCount=1; visitCount<=maxCanVisitCount; visitCount++) {
                DP[node][visitCount] = Math.max(DP[node][visitCount], mock[visitCount]);
            }

            // 자식 노드 정보 반영
            maxCanVisitNodeSize[node] += maxCanVisitNodeSize[connectedNode];

            // 해당 노드 갱신
            if(maxCanVisitNodeSize[node] > maxCanVisitCount) {
                maxCanVisitNodeSize[node] = maxCanVisitCount;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수, 방문 가능한 횟수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        maxCanVisitCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relations.get(parent).add(child);
        }

        // 사과 정보 배열 생성
        apples = new int[nodeCount];

        // 사과 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<nodeCount; index++) {
            apples[index] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 생성 - [해당 노드]에서의 [최대 방문 가능한 노드 수]
        DP = new int[nodeCount][maxCanVisitCount+1];
        maxCanVisitNodeSize = new int[nodeCount];

        // 탐색
        solve(0);

        // 결과 확인
        for(int index=1; index<=maxCanVisitCount; index++) {
            answer = Math.max(answer, DP[0][index]);
        }

        // 결과 출력
        System.out.println(answer);
    }
}