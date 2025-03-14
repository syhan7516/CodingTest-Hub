import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 점수 개수, 그룹 개수
    public static int answer, scoreCount, groupCount;

    // 점수 배열
    public static int[] scores;

    // 그룹 나누기 메서드
    public static void solve() {

        // 범위 설정
        int left = 0;
        int right = 2000000;

        // 범위 이동하며 확인
        while(left<=right) {

            // 현 점수에 따른 그룹 수, 현재 점수
            int currentGroupCount = 0;
            int currentSumScore = 0;

            // 점수 설정
            int mid = (left+right)/2;

            // 점수 확인
            for(int index=0; index<scores.length; index++) {

                // 점수 더하기
                currentSumScore += scores[index];

                // 설정한 점수 이상인 경우
                if(currentSumScore>=mid) {
                    currentGroupCount++;
                    currentSumScore = 0;
                }
            }

            // 점수 처리 결과 확인
            if(currentGroupCount>=groupCount) {
                left = mid+1;
                answer = mid;
            }

            else right = mid-1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 점수 개수, 그룹 개수 입력
        st = new StringTokenizer(br.readLine());
        scoreCount = Integer.parseInt(st.nextToken());
        groupCount = Integer.parseInt(st.nextToken());

        // 점수 배열 생성
        scores = new int[scoreCount];

        // 점수 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<scoreCount; index++) {
            scores[index] = Integer.parseInt(st.nextToken());
        }

        // 그룹 나누기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}