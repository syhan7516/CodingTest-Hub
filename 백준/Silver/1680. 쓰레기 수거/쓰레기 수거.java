import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 지점 클래스
class Area {
    int distance;
    int weight;

    public Area(int distance, int weight) {
        this.distance = distance;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {
            st = new StringTokenizer(br.readLine());
            int truckCapacity = Integer.parseInt(st.nextToken());
            int pointCount = Integer.parseInt(st.nextToken());

            // 지점 정보 저장 배열 생성
            Area[] areas = new Area[pointCount];

            // 지점 정보 입력
            for(int point=0; point<pointCount; point++) {
                st = new StringTokenizer(br.readLine());
                int distance = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                areas[point] = new Area(distance, weight);
            }
            
            // 현재 위치, 현재 트럭 무게, 총 이동 거리
            int currentPoint = 0;
            int currentCapacity = 0;
            int totalMoveDistance = 0;

            // 지점 확인
            for(int point=0; point<pointCount; point++) {

                // 현재 지점
                int distance = areas[point].distance;
                int weight = areas[point].weight;

                // 이동
                totalMoveDistance += distance - currentPoint;
                currentPoint = distance;

                // 무게 확인
                currentCapacity += weight;

                // 무게가 넘치는 경우
                if(currentCapacity >= truckCapacity) {
                    totalMoveDistance += currentPoint * 2;

                    if(currentCapacity == truckCapacity) {
                        currentCapacity = 0;
                    }
                    else {
                        currentCapacity = weight;
                    }
                }
            }

            // 마지막 지점 확인
            totalMoveDistance = currentCapacity == 0 ? totalMoveDistance - currentPoint : totalMoveDistance + currentPoint;

            // 결과 저장
            sb.append(totalMoveDistance).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}