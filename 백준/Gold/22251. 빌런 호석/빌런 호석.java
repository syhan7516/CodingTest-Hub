import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 총 층수, 디스플레이 자리 수, 반전 개수, 현재 층수
    public static int answer, totalFloor, displayDigit, reverseCount, currentFloor;

    // 디스플레이 배열 (0~9)
    public static boolean display[][] = {
            {true,true,true,false,true,true,true},
            {false,false,true,false,false,true,false},
            {true,false,true,true,true,false,true},
            {true,false,true,true,false,true,true},
            {false,true,true,true,false,true,false},
            {true,true,false,true,false,true,true},
            {true,true,false,true,true,true,true},
            {true,false,true,false,false,true,false},
            {true,true,true,true,true,true,true},
            {true,true,true,true,false,true,true}};

    // 문자열 변환 메서드
    public static String changeIntToString(int number) {

        StringBuilder sb = new StringBuilder();
        sb.append(number);

        // 0 필요 개수
        int requiredZeroCount = displayDigit-sb.length();

        // 0 추가
        for(int count=0; count<requiredZeroCount; count++)
            sb.insert(0, '0');

        return sb.toString();
    }

    // 자리 비교 메서드
    public static int compareStringAndString(String floor1, String floor2) {

        // 디스플레이 차이 개수
        int differenceDisplayCount = 0;

        // 자리 확인
        for(int index=0; index<displayDigit; index++) {

            // 비교 자리 숫자 확인
            int floor1Num = floor1.charAt(index)-'0';
            int floor2Num = floor2.charAt(index)-'0';

            // 자리 디스플레이 확인
            for(int displayIndex=0; displayIndex<7; displayIndex++) {

                // 켜진 곳이 다른 경우
                if(display[floor1Num][displayIndex]!=display[floor2Num][displayIndex])
                    differenceDisplayCount++;
            }
        }

        return differenceDisplayCount;
    }

    // 반전 경우의 수 구하기 메서드
    public static void solve() {

        // 현재 층수 문자열 변환
        String currentFloorToString = changeIntToString(currentFloor);

        // 1층부터 확인
        for(int num=1; num<=totalFloor; num++) {

            // 자기 자신인 겨웅
            if(num==currentFloor) continue;

            // 비교 층
            String compareFloor = changeIntToString(num);

            // 자리 비교
            int differenceDisplayCount = compareStringAndString(currentFloorToString,compareFloor);

            // 결과 반영
            if(differenceDisplayCount<=reverseCount)
                answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 총 층수, 디스플레이 자리 수, 반전 개수, 현재 층수 입력
        st = new StringTokenizer(br.readLine());
        totalFloor = Integer.parseInt(st.nextToken());
        displayDigit = Integer.parseInt(st.nextToken());
        reverseCount = Integer.parseInt(st.nextToken());
        currentFloor = Integer.parseInt(st.nextToken());

        // 반전 경우의 수 구하기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}