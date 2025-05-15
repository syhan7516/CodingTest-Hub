import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 학교 위치, 충전소 개수, 최대 방문 횟수
    public static int answer, destination, stationCount, maxVisitCount;

    // 위치 배열
    public static int[] points;

    // 등교 확인 메서드
    public static boolean goToSchool(int capacity) {

        // 현재 위치
        int currentPointIndex = 0;

        // 충전소 방문 횟수
        int visitCount = 0;

        // 4. 학교 도착할 때까지 반복
        while(currentPointIndex<points.length) {

            // 이동 여부
            boolean isMoved = false;

            // 현재 위치에서 이동 가능한 위치
            int maxCanMoveDistance = points[currentPointIndex] + capacity;

            // 학교 도착한 경우
            if(maxCanMoveDistance>=points[points.length-1]) break;

            // 이동 가능한 충전소 위치 확인
            for(int pointIndex=currentPointIndex+1; pointIndex<points.length; pointIndex++) {

                // 다음 위치로 이동 불가능한 경우
                if(points[pointIndex]>maxCanMoveDistance) {

                    // 한 번도 이동을 못한 경우
                    if(!isMoved) {
                        return false;
                    }

                    break;
                }

                // 다음 위치로 이동 가능한 경우
                isMoved = true;
                currentPointIndex = pointIndex;
            }

            // 충전소 방문 횟수 증가
            visitCount++;
        }

        // 충전소 방문 횟수가 기준 이상인 경우
        if(visitCount<=maxVisitCount) {
            answer = capacity;
            return true;
        }

        // 충전소 방문 횟수가 많은 경우
        else return false;
    }

    // 최소 배터리 용량 구하기 메서드
    public static void solve() {

        // 시작 범위 설정
        int left = 1;
        int right = points[points.length-1];

        // 배터리 용량 탐색
        while(left<=right) {

            // 배터리 용량 설정
            int mid = (left+right)/2;

            // 등교하기
            if(goToSchool(mid)) {

                // 충전 횟수가 같거나 더 적은 경우
                right = mid-1;
            }

            // 등교를 못하거나, 정해진 횟수보다 충전이 많은 경우
            else {
                left = mid+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 학교 위치, 충전소 개수, 최대 방문 횟수 입력
        st = new StringTokenizer(br.readLine());
        destination = Integer.parseInt(st.nextToken());
        stationCount = Integer.parseInt(st.nextToken());
        maxVisitCount = Integer.parseInt(st.nextToken());

        // 위치 배열 생성
        points = new int[stationCount +2];

        // 충전소 위치 입력
        st = new StringTokenizer(br.readLine());
        for(int pointIndex = 1; pointIndex<= stationCount; pointIndex++) {
            points[pointIndex] = Integer.parseInt(st.nextToken());
        }

        // 집, 학교 위치 입력
        points[0] = 0;
        points[points.length-1] = destination;

        // 최소 배터리 용량 구하기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}