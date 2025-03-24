import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 번호 개수
    public static final int NUM_COUNT = 10;

    // 최대 채널 길이
    public static final int MAX_CHANNEL = 999999;

    // 현재 채널
    public static final int START_CHANNEL = 100;

    // 결과, 목표 번호, 고장난 수, 목표 번호 길이
    public static int answer, targetNum, brokenCount;

    // 고장난 번호 여부 배열
    public static boolean[] broken;

    // 각 자리 번호 확인 메서드
    public static boolean checkIsPossible(String num) {

        // 각 자리 확인
        for(int index=0; index<num.length(); index++) {
            if(broken[num.charAt(index)-'0']) {
                return false;
            }
        }

        return true;
    }

    // 번호 찾기 메서드
    public static void solve() {

        // 0 ~ 999999
        for(int num=0; num<=MAX_CHANNEL; num++) {

            // 확인 숫자
            String currentNum = String.valueOf(num);

            // 버튼을 다 누를 수 있는 경우
            if(checkIsPossible(currentNum)) {
                answer = Math.min(answer,Math.abs(num-targetNum)+currentNum.length());
            }
        }
    }

    // 고장 버튼 존재 여부 메서드
    public static boolean isBroken() {
        return brokenCount > 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 목표 번호 입력
        String inputNum = br.readLine();
        targetNum = Integer.parseInt(inputNum);

        // 고장난 수 입력
        brokenCount = Integer.parseInt(br.readLine());

        // 고장난 번호 여부 배열 생성
        broken = new boolean[NUM_COUNT];

        // 고장난 번호 입력
        if(isBroken()) {
            st = new StringTokenizer(br.readLine());
            for(int index = 0; index< brokenCount; index++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        // 번호 찾기
        answer = Math.abs(targetNum-START_CHANNEL);
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}