import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 총 거리, 충전소 개수, 충전 횟수
    public static int answer, totalDistance, chargerCount, chargePossibleCount;

    // 충전소 위치 저장 배열
    public static int chargerPositions[];

    // 값 확인 메서드
    public static boolean getRequiredChargerCount(int charger) {

        // 현재 위치, 필요 충전소 개수
        int index = 0;
        int currentPosition = 0;
        int requiredChargerCount = 0;

        // 충전소 위치 확인
        while(currentPosition<totalDistance) {

            // 이동 가능한 거리
            int possibleDistance = currentPosition + charger;

            // 학교에 도착한 경우
            if(possibleDistance>=totalDistance)
                return true;

            // 갈 수 있는 가장 먼 충전소 탐색
            int maxDistanceCharger = -1;
            while(index<chargerCount && chargerPositions[index]<=possibleDistance) {
                maxDistanceCharger = index;
                index++;
            }

            // 다음 충전소까지 이동이 불가능한 경우
            if(maxDistanceCharger==-1)
                return false;

            // 이동
            currentPosition = chargerPositions[maxDistanceCharger];
            requiredChargerCount++;

            // 방문 가능한 충전소 개수가 넘은 경우
            if(requiredChargerCount>chargePossibleCount)
                return false;
        }

        return false;
    }

    // 최소 배터리 용량 구하기 메서드
    public static void solve() {

        // 범위 설정
        int left = 1;
        int right = totalDistance;
        answer = Integer.MAX_VALUE;

        // 탐색
        while(left<=right) {

            // 값 설정
            int mid = (left+right)/2;

            // 필요 충전소 개수가 같거나 더 적은 경우
            if(getRequiredChargerCount(mid)) {
                right = mid-1;
                answer = Math.min(answer,mid);
            }

            // 충전소 개수가 더 많은 경우
            else left = mid+1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 총 거리, 충전소 개수, 충전 횟수 입력
        st = new StringTokenizer(br.readLine());
        totalDistance = Integer.parseInt(st.nextToken());
        chargerCount = Integer.parseInt(st.nextToken());
        chargePossibleCount = Integer.parseInt(st.nextToken());

        // 충전소 위치 배열 생성
        chargerPositions = new int[chargerCount];

        // 충전소 위치 저장
        st = new StringTokenizer(br.readLine());
        for(int position=0; position<chargerCount; position++) {
            chargerPositions[position] = Integer.parseInt(st.nextToken());
        }

        // 최소 배터리 용량 구하기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}