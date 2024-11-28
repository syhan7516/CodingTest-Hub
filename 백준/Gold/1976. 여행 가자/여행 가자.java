import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 도시 수, 계획 도시 수
    public static int totalCityCount, planCityCount;

    // 대표 배열
    public static int parent[];

    // find
    public static int find(int number) {

        // 자기 자신인 경우
        if(parent[number]==number)
            return number;

        return parent[number] = find(parent[number]);
    }

    // union
    public static void union(int a, int b) {

        // 대표 찾기
        a = find(a);
        b = find(b);

        // 집합 추가
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 게획 도시 확인 메서드
    public static boolean solve(StringTokenizer st) {

        // 시작 도시
        int cityGroup = find(Integer.parseInt(st.nextToken()));

        // 나머지 도시 확인
        for (int city=2; city<=planCityCount; city++) {
            int planCity = Integer.parseInt(st.nextToken());

            // 방문 불가능한 도시인 경우
            if (find(cityGroup)!=find(planCity))
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 수 입력
        totalCityCount = Integer.parseInt(br.readLine());
        planCityCount = Integer.parseInt(br.readLine());

        // 대표 배열 생성
        parent = new int[totalCityCount+1];

        // 대표 배열 초기화
        for(int index=1; index<=totalCityCount; index++)
            parent[index] = index;

        // 연결 정보 입력
        for(int city=1; city<=totalCityCount; city++) {
            st = new StringTokenizer(br.readLine());
            for(int otherCity=1; otherCity<=totalCityCount; otherCity++) {

                // 연결 정보
                int connect = Integer.parseInt(st.nextToken());

                // 연결된 경우
                if(connect==1) union(city,otherCity);
            }
        }

        // 연결 정보 최신화
        for(int city=1; city<=totalCityCount; city++) find(city);

        // 계획 도시 확인
        boolean answer = solve(new StringTokenizer(br.readLine()));

        // 결과 출력
        if(answer) System.out.println("YES");
        else System.out.println("NO");
    }
}