import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 도시 클래스
class City {
    int node;
    int value;

    public City(int node, int value) {
        this.node = node;
        this.value = value;
    }
}

public class Main {

    // 도시 개수, 도로 개수, 거리 정보, 시작점
    public static int cityCount, roadCount, distanceValue,startNode;

    // 결과 저장 리스트
    public static ArrayList<Integer> answer;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 도시 관계 확인 메서드
    public static void solve() {

        // 결과 저장 리스트 생성
        answer = new ArrayList<>();

        // 방문 여부 배열 생성
        boolean visited[] = new boolean[cityCount+1];

        //  도시 저장 큐 생성
        Queue<City> queue = new LinkedList<>();

        // 시작 위치 처리
        queue.offer(new City(startNode,0));
        visited[startNode] = true;

        // 탐색
        while(!queue.isEmpty()) {

            // 확인 개수
            int size = queue.size();

            // 개수 만큼 확인
            while(size-->0) {

                // 확인 노드
                City currentCity = queue.poll();

                // 연결 노드 확인
                for(int node=0; node<relations.get(currentCity.node).size(); node++) {

                    // 연결 노드
                    int connectNode = relations.get(currentCity.node).get(node);

                    // 이미 방문한 경우
                    if(visited[connectNode]) continue;

                    // 방문 처리
                    visited[connectNode] = true;

                    // 큐에 삽입
                    queue.offer(new City(connectNode,currentCity.value+1));

                    // 목표 거리인 경우
                    if(currentCity.value+1==distanceValue)
                        answer.add(connectNode);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시, 도로 개수, 거리 정보, 시작점 입력
        st = new StringTokenizer(br.readLine());
        cityCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());
        distanceValue = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성, 초기화
        relations = new ArrayList<>();
        for(int node=0; node<=cityCount; node++)
            relations.add(new ArrayList<>());

        // 관계 정보 입력
        for(int road=0; road<roadCount; road++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
        }

        // 도시 관계 확인
        solve();

        // 결과 정렬
        Collections.sort(answer);

        // 결과 출력
        if(answer.isEmpty())
            System.out.println(-1);

        else for(int node: answer)
            System.out.println(node);
    }
}