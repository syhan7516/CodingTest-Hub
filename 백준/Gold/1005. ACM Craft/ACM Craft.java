import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 건물 수, 규칙 수, 목표 지점
    public static int buildingCount, ruleCount, targetBuilding;

    // 건물 짓는 시간 정보 배열
    public static int[] buildTimes, totalBuildTimes;

    // 차수 저장 배열
    public static int[] degrees;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 탐색 수행 메서드
    public static void solve() {

        // 건물 짓는 총 시간 정보 배열 생성
        totalBuildTimes = new int[buildingCount+1];

        // 작업 순서 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 시작 건물 확인
        for(int building=1; building<=buildingCount; building++) {
            if(degrees[building] == 0) {
                totalBuildTimes[building] = buildTimes[building];
                queue.offer(building);
            }
        }

        // 건물 짓기
        while(!queue.isEmpty()) {

            // 현재 짓는 건물 확인
            int building = queue.poll();

            // 목표 건물인 경우
            if(building == targetBuilding) return;

            // 연결된 작업 건물 처리
            for(int index=0; index<relations.get(building).size(); index++) {

                // 연결된 작업 건물 확인
                int connectedBuilding = relations.get(building).get(index);

                // 선작업 해결 처리
                degrees[connectedBuilding]--;

                // 건물 짓는 최장 시간 갱신
                totalBuildTimes[connectedBuilding]
                        = Math.max(totalBuildTimes[connectedBuilding], totalBuildTimes[building] + buildTimes[connectedBuilding]);

                // 모든 선작업 처리가 완료된 경우
                if(degrees[connectedBuilding] == 0) {
                    queue.offer(connectedBuilding);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 건물 수, 규칙 수 입력
            st = new StringTokenizer(br.readLine());
            buildingCount = Integer.parseInt(st.nextToken());
            ruleCount = Integer.parseInt(st.nextToken());

            // 건물 짓는 시간 정보 배열 생성, 입력
            buildTimes = new int[buildingCount+1];
            st = new StringTokenizer(br.readLine());
            for(int building=1; building<=buildingCount; building++) {
                buildTimes[building] = Integer.parseInt(st.nextToken());
            }

            // 연결 정보 리스트 생성
            relations = new ArrayList<>();
            for(int index=0; index<=buildingCount; index++) {
                relations.add(new ArrayList<>());
            }

            // 차수 저장 배열 생성, 입력
            degrees = new int[buildingCount+1];
            for(int rule=0; rule<ruleCount; rule++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                degrees[to]++;
                relations.get(from).add(to);
            }

            // 목표 지점 입력
            targetBuilding = Integer.parseInt(br.readLine());

            // 탐색 수행
            solve();

            // 결과 저장
            sb.append(totalBuildTimes[targetBuilding]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}