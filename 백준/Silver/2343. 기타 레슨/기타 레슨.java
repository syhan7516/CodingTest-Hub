import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 강의 수, 장비 수
    public static int answer, lectureCount, targetEquipmentCount;

    // 범위
    public static int left, right;

    // 강의 길이 배열
    public static int[] lectureLens;

    // 탐색 메서드
    public static void solve() {
        while(left <= right) {

            // 시간 설정
            int mid = (left+right) / 2;

            // 기기 개수
            int equipmentCount = 1;

            // 강의 확인
            int time = 0;
            for(int index=0; index<lectureLens.length; index++) {
                if(time + lectureLens[index] > mid) {
                    equipmentCount++;
                    time = 0;
                }

                time += lectureLens[index];
            }

            // 기기 확인
            if(equipmentCount > targetEquipmentCount) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        answer = left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 강의 수, 장비 수 입력
        st = new StringTokenizer(br.readLine());
        lectureCount = Integer.parseInt(st.nextToken());
        targetEquipmentCount = Integer.parseInt(st.nextToken());

        // 강의 길이 배열 생성
        lectureLens = new int[lectureCount];

        // 강의 길이 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<lectureCount; index++) {
            lectureLens[index] = Integer.parseInt(st.nextToken());
            left = Math.max(left, lectureLens[index]);
        }

        // 탐색
        right = lectureCount * 10000;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}