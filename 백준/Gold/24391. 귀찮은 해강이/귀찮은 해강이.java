import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 강의 개수, 건물 쌍 개수
    public static int answer, lectureCount, pairCount;

    // 집합 배열
    public static int[] parent;

    // find
    public static int find(int building) {
        if(parent[building]==building) {
            return building;
        }

        return parent[building] = find(parent[building]);
    }

    // union
    public static void union(int building1, int building2) {
        building1 = find(building1);
        building2 = find(building2);

        if(building1<building2) parent[building2] = building1;
        else parent[building1] = building2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 강의 개수, 건물 쌍 개수 입력
        st = new StringTokenizer(br.readLine());
        lectureCount = Integer.parseInt(st.nextToken());
        pairCount = Integer.parseInt(st.nextToken());

        // 집합 배열 생성 및 초기화
        parent = new int[lectureCount+1];
        for(int index=1; index<=lectureCount; index++) {
            parent[index] = index;
        }

        // 건물 쌍 정보 입력
        for(int pair=0; pair<pairCount; pair++) {
            st = new StringTokenizer(br.readLine());
            int building1 = Integer.parseInt(st.nextToken());
            int building2 = Integer.parseInt(st.nextToken());
            union(building1,building2);
        }

        // 강의 코드 확인
        st = new StringTokenizer(br.readLine());
        int currentBuilding = find(Integer.parseInt(st.nextToken()));

        while(st.hasMoreTokens()) {
            int nextLectureBuilding = find(Integer.parseInt(st.nextToken()));
            if(currentBuilding!=nextLectureBuilding) {
                answer++;
                currentBuilding = nextLectureBuilding;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}