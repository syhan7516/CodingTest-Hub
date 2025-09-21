import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도로 클래스
class Road {
    int node;
    int cost;

    public Road(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Main {

    // 최대 비용
    public static final int MAX_VALUES = (int)1e9;

    // 지점 수, 도로 수, 홀 수
    public static int nodeCount, roadCount, hallCount;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Road>> relations;

    // 최단 경로 배열
    public static int[] path;

    // 탐색 메서드
    public static boolean solve() {

        // 최단 경로 배열 생성
        path = new int[nodeCount+1];
        Arrays.fill(path, MAX_VALUES);

        // 시작 지점 처리
        path[1] = 0;

        // 거리 갱신 여부
        boolean updated = false;

        // 도로 확인
        for(int index=1; index<=nodeCount-1; index++) {

            // 거리 갱신 여부 초기화
            updated = false;

            // 연결 도로 확인
            for(int node=1; node<=nodeCount; node++) {
                for(int road=0; road<relations.get(node).size(); road++) {
                    Road connectedRoad = relations.get(node).get(road);

                    // 거리 갱신이 가능한 경우
                    if(path[connectedRoad.node] > path[node] + connectedRoad.cost) {
                        path[connectedRoad.node] = path[node] + connectedRoad.cost;
                        updated = true;
                    }
                }
            }

            // 거리 갱신 여부 확인
            if(!updated) break;
        }

        // 정점 -1 까지 거리가 갱신된 경우
        if(updated) {

            // 음수 사이클 여부 확인
            for(int node=1; node<=nodeCount; node++) {
                for(int road=0; road<relations.get(node).size(); road++) {
                    Road connectedRoad = relations.get(node).get(road);

                    // 거리 갱신이 가능한 경우
                    if(path[connectedRoad.node] > path[node] + connectedRoad.cost) return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 지점 수, 도로 수, 홀 수 입력
            st = new StringTokenizer(br.readLine());
            nodeCount = Integer.parseInt(st.nextToken());
            roadCount = Integer.parseInt(st.nextToken());
            hallCount = Integer.parseInt(st.nextToken());

            // 연결 정보 리스트 생성
            relations = new ArrayList<>();
            for(int index=0; index<=nodeCount; index++) {
                relations.add(new ArrayList<>());
            }

            // 도로 정보 입력
            for(int index=0; index<roadCount; index++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                relations.get(from).add(new Road(to, cost));
                relations.get(to).add(new Road(from, cost));
            }

            // 웜홀 정보 입력
            for(int index=0; index<hallCount; index++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                relations.get(from).add(new Road(to, -cost));
            }

            // 탐색
            if(!solve()) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}