import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 수행
        while(true) {

            // 노드 개수, 목표 노드 입력
            st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int targetNode = Integer.parseInt(st.nextToken());

            // 둘 다 0인 경우
            if(nodeCount == 0 && targetNode == 0) break;

            // 노드 정보, 부모 노드 위치 저장 배열 생성
            int[] nodes = new int[nodeCount+1];
            int[] parent = new int[nodeCount+1];

            // 목표 노드 저장 인덱스
            int targetIndex = 0;

            // 부모 인덱스
            int parentIndex = -1;

            // 초기화
            int answer = 0;
            parent[0] = -1;
            nodes[0] = -1;

            // 노드 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int index=1; index<=nodeCount; index++) {
                nodes[index] = Integer.parseInt(st.nextToken());

                // 목표 노드인 경우
                if(nodes[index] == targetNode) {
                    targetIndex = index;
                }

                // 연속되지 않은 경우
                if(nodes[index] != nodes[index-1]+1) {
                    parentIndex++;
                }

                // 부모 위치 저장
                parent[index] = parentIndex;
            }

            // 각 노드 부모 위치 확인
            for(int index=1; index<=nodeCount; index++) {

                // 부모가 다르며, 노드의 부모의 부모가 동일한 경우
                if(parent[index] != parent[targetIndex] && parent[parent[index]] == parent[parent[targetIndex]]) {
                    answer++;
                }
            }

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}