import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    // 결과, 길 개수, 총 도로 길이
    public static int answer, roadCount, totalRoadLen;

    // 길 배열
    public static int roads[][];

    // 선택된 길 저장 리스트
    public static ArrayList<Integer> selectedRoad;

    // 길 확인 메서드
    public static void solve(int index) {

        // 길 선택이 완료된 경우
        if(index==roadCount) {

            // 지나간 길 길이
            int passLen = 0;

            // 현재 위치 설정
            int current = 0;

            // 선택된 길 순회
            for(int road=0; road<selectedRoad.size(); road++) {

                // 기준 길
                int roadIndex = selectedRoad.get(road);
                int start = roads[roadIndex][0];
                int end = roads[roadIndex][1];
                int len = roads[roadIndex][2];

                // 현재 위치보다 뒤쳐지는 경우
                if(current>start || current>end) continue;

                // 도착 위치가 목적지를 벗어난 경우
                if(totalRoadLen<end) continue;

                // 현재 위치와 동일한 경우
                if(current==start) passLen += len;

                // 현재 위치와 다른 경우
                else passLen += start-current+len;

                // 위치 갱신
                current = end;
            }

            // 목적지에 도착 못한 경우
            if(current!=totalRoadLen) passLen += totalRoadLen-current;

            // 결과 갱신
            answer = Math.min(answer,passLen);
            return;
        }

        // 길 선택, 미선택
        selectedRoad.add(index);
        solve(index+1);
        selectedRoad.remove(selectedRoad.size()-1);
        solve(index+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 길 개수, 총 도로 길이 입력
        st = new StringTokenizer(br.readLine());
        roadCount = Integer.parseInt(st.nextToken());
        totalRoadLen = Integer.parseInt(st.nextToken());

        // 길 배열 생성
        roads = new int[roadCount][3];

        // 길 정보 입력
        for(int road=0; road<roadCount; road++) {
            st = new StringTokenizer(br.readLine());
            roads[road][0] = Integer.parseInt(st.nextToken());
            roads[road][1] = Integer.parseInt(st.nextToken());
            roads[road][2] = Integer.parseInt(st.nextToken());
        }

        // 길 정렬
        Arrays.sort(roads, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(roads, Comparator.comparingInt(a -> a[0]));

        // 선택된 길 저장 리스트 생성
        selectedRoad = new ArrayList<>();

        // 길 확인
        answer = Integer.MAX_VALUE;
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}