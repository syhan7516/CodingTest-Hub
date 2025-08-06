import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 줄 수, 숫자 개수, 피연산자 길이
    public static int answer, lineCount, numCount, numLen;

    // 별 수 배열
    public static int[] stars;

    // 숫자 배열
    public static int[] nums;

    // 숫자 존재 여부 배열
    public static boolean[] visited;

    // 더할 0개 수 구하기 메서드
    public static int getZeroCount(int starLinePoint) {
        if(starLinePoint == 0) {
            return 1;
        }

        int target = 1;
        for(int index=1; index<=starLinePoint; index++) {
            target *= 10;
        }

        return target;
    }

    // 숫자 선택하기 메서드
    public static void solve(int count, StringBuilder sb) {

        // 숫자 선택이 완료된 경우
        if(count == numLen) {

            // 숫자 확인
            int firstNum = Integer.parseInt(sb.substring(0, stars[0]));
            int secondNum = Integer.parseInt(sb.substring(stars[0], sb.length()));
            int finalResult = 0;

            // 연산 위치 지정
            int starLinePoint = 2;
            while(secondNum!=0 && starLinePoint < lineCount) {

                // 두번째 수 곱 대상 숫자와 첫번째 수 곱하기
                int num = secondNum % 10;
                String intermediateResult = String.valueOf(firstNum*num);

                // 연산 결과 길이가 다른 경우
                if(stars[starLinePoint] != intermediateResult.length()) return;

                // 각 자리 숫자 확인
                for(int index=0; index<intermediateResult.length(); index++) {
                    if(!visited[intermediateResult.charAt(index)-'0']) return;
                }

                // 연산 결과 더하기
                finalResult += Integer.parseInt(intermediateResult) * getZeroCount(starLinePoint-2);

                secondNum /= 10;
                starLinePoint++;
            }

            // 각 자리 숫자 확인
            String finalResultToString = String.valueOf(finalResult);
            if(finalResultToString.length() != stars[stars.length-1]) return;

            for(int index=0; index<finalResultToString.length(); index++) {
                if(!visited[finalResultToString.charAt(index)-'0']) return;
            }

            answer++;
            return;
        }

        // 숫자 선택하기
        for(int index=0; index<nums.length; index++) {
            sb.append(nums[index]);
            solve(count+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 줄 수 입력
        lineCount = Integer.parseInt(br.readLine());

        // 별 수 입력
        st = new StringTokenizer(br.readLine());
        stars = new int[lineCount];
        for(int index=0; index<lineCount; index++) {
            stars[index] = Integer.parseInt(st.nextToken());
        }

        // 숫자 개수 입력
        numCount = Integer.parseInt(br.readLine());

        // 숫자 존재 여부 배열 생성
        visited = new boolean[10];

        // 숫자 입력
        nums = new int[numCount];
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<numCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
            visited[nums[index]] = true;
        }

        // 숫자 선택하기
        numLen = stars[0] + stars[1];
        solve(0, new StringBuilder());

        // 결과 출력
        System.out.println(answer);
    }
}