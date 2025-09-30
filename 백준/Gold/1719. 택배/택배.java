import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 노드 개수, 간선 개수
    public static int nodeCount, edgeCount;

    // 최단 거리 배열
    public static int[][] path;

    // 경유 노드 배열
    public static int[][] middle;

    // 거리 최대치
    public static final int MAX_COST = (int)1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 노드 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 최단 거리 배열, 경유 노드 배열 생성
        path = new int[nodeCount+1][nodeCount+1];
        middle = new int[nodeCount+1][nodeCount+1];

        // 최단 거리 배열 초기화
        for(int from =1; from<=nodeCount; from++) {
            for(int to=1; to<=nodeCount; to++) {

                // 자기 자신 제외
                if(from == to) path[from][to] = 0;
                else path[from][to] = MAX_COST;
            }
        }

        // 경유 배열 초기화
        for(int from=1; from<=nodeCount; from++) {
            for(int to=1; to<=nodeCount; to++) {

                // 자기 자신 제외
                if(from == to) middle[from][to] = 0;
                else middle[from][to] = to;
            }
        }

        // 간선 정보 입력
        for(int edge=0; edge<edgeCount; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 중복된 간선 중 최단 거리 저장
            path[from][to] = path[to][from] = Math.min(path[from][to], cost);
        }

        // 최단 거리 구하기
        for(int midNode=1; midNode<=nodeCount; midNode++) {
            for(int fromNode=1; fromNode<=nodeCount; fromNode++) {
                for(int toNode=1; toNode<=nodeCount; toNode++) {

                    // 자기 자신 제외
                    if(fromNode == toNode) continue;

                    // 경유 노드를 거치는 과정에서 최단 거리인 경우
                    if(path[fromNode][toNode] > path[fromNode][midNode] + path[midNode][toNode]) {
                        path[fromNode][toNode] = path[fromNode][midNode] + path[midNode][toNode];
                        middle[fromNode][toNode] = middle[fromNode][midNode];
                    }
                }
            }
        }

        // 결과 저장
        for(int from=1; from<=nodeCount; from++) {
            for(int to=1; to<=nodeCount; to++) {
                if(from == to) sb.append("-").append(" ");
                else sb.append(middle[from][to]).append(" ");
            }
            sb.append('\n');
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}