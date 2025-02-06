import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 휴게소 개수, 추가 휴게소 개수, 고속도로 길이
    public static int answer, areaCount, addAreaCount, highWayLen;

    // 휴게소 위치 배열
    public static int highWay[];

    // 휴게소 세우기 메서드
    public static void solve() {

        // 시작, 끝 설정
        int left = 1;
        int right = highWayLen-1;

        // 세울 곳 탐색
        while(left<=right) {

            // 중간 설정
            int mid = (left+right)/2;
            int sum = 0;

            // 휴게소 위치 확인
            for(int index=1; index<highWay.length; index++) {
                sum += (highWay[index]-highWay[index-1]-1)/mid;
            }

            // 추가된 휴게소가 목표보다 작을 경우
            if(sum>addAreaCount) {
                left = mid + 1;
            }

            // 추가된 휴게소가 목표보다 같거나 클 경우
            else right = mid-1;
        }

        answer = left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 휴게소 개수, 추가 휴게소 개수, 고속도로 길이
        st = new StringTokenizer(br.readLine());
        areaCount = Integer.parseInt(st.nextToken());
        addAreaCount = Integer.parseInt(st.nextToken());
        highWayLen = Integer.parseInt(st.nextToken());

        // 휴게소 배열 생성
        highWay = new int[areaCount+2];
        highWay[0] = 0;
        highWay[areaCount+1] = highWayLen;

        // 휴게소 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=areaCount; index++) {
            highWay[index] = Integer.parseInt(st.nextToken());
        }

        // 가까운 순으로 휴게소 위치 정렬
        Arrays.sort(highWay);

        // 휴게소 세우기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}