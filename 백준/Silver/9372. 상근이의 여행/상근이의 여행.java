import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 국가 수, 비행기 수
    public static int answer, countryCount, airplaneCount;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 비행기 타기 메서드
    public static void solve(int country) {

        // 이동 가능한 비행기 종류 확인
        for(int relation=0; relation<relations.get(country).size(); relation++) {

            // 이동 가능한 나라
            int connectedCountry = relations.get(country).get(relation);

            // 미방문 나라인 경우
            if(!visited[connectedCountry]) {
                visited[connectedCountry] = true;
                answer++;
                solve(connectedCountry);
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

            // 국가 수, 비행기 수 입력
            st = new StringTokenizer(br.readLine());
            countryCount = Integer.parseInt(st.nextToken());
            airplaneCount = Integer.parseInt(st.nextToken());

            // 관계 정보 리스트 생성 및 초기화
            relations = new ArrayList<>();
            for(int country=0; country<=countryCount; country++) {
                relations.add(new ArrayList<>());
            }

            // 비행기 종류 입력
            for(int airplane=0; airplane<airplaneCount; airplane++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                relations.get(from).add(to);
                relations.get(to).add(from);
            }

            // 방문 여부 배열 생성
            visited = new boolean[countryCount+1];

            // 비행기 타기
            answer = 0;
            visited[1] = true;
            solve(1);

            // 결과 출력
            System.out.println(answer);
        }

    }
}