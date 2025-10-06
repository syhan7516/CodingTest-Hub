import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 영역 개수, 최대 선택 개수
    public static int answer, areaCount, maxSelectedCount;

    // 영역 저장 정보 배열
    public static int[] areas;

    // 선택된 영역 저장 리스트
    public static ArrayList<Integer> selectedAreas;

    // 방문 여부 배열
    public static boolean[] visited;

    // 반 배치 수행 메서드
    public static void solve(int selectedAreaCount) {

        // 모두 선택한 경우
        if(selectedAreaCount == areaCount) {

            // 선 개수
            int lineCount = 0;

            // 확인
            for(int index=0; index<selectedAreas.size(); index++) {
                int area = areas[selectedAreas.get(index)];
                if(area >= 50) {
                    if(area == 50) lineCount++;
                    continue;
                }

                int areaIndex = index;
                while(area < 50) {
                    areaIndex = areaIndex + 1 == selectedAreas.size() ? 0 : areaIndex + 1;
                    area += areas[selectedAreas.get(areaIndex)];
                    if(area >= 50) {
                        if(area == 50) lineCount++;
                        break;
                    }
                }
            }

            // 결과 갱신
            answer = Math.max(answer, lineCount/2);
            return;
        }

        // 반 배치 수행
        for(int index=0; index<areas.length; index++) {
            if(visited[index]) continue;
            visited[index] = true;
            selectedAreas.add(index);
            solve(selectedAreaCount + 1);
            selectedAreas.remove(selectedAreas.size() - 1);
            visited[index] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 영역 개수 입력
        areaCount = Integer.parseInt(br.readLine());

        // 영역 저장 배열 생성
        areas = new int[areaCount];

        // 영역 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<areaCount; index++) {
            areas[index] = Integer.parseInt(st.nextToken());
        }

        // 최대 선택 개수
        maxSelectedCount = areaCount%2 == 0 ? areaCount/2 - 1 : areaCount/2;

        // 선택된 영역 저장 리스트 생성
        selectedAreas = new ArrayList<>();

        // 반 배치 수행
        visited = new boolean[areaCount];
        solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}