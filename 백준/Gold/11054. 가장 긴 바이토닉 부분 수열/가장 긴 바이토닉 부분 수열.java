import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 숫자 개수
    public static int numCount;

    // 숫자, LIS, LDS 배열
    public static int[] nums, LIS, LDS;

    // LIS 수행 메서드
    public static void executeLIS() {

        // 확인 위치
        for(int currentIndex=0; currentIndex<numCount; currentIndex++) {

            // 길이
            int maxLen = 1;

            // 비교 위치
            for(int compareIndex=currentIndex-1; compareIndex>=0; compareIndex--) {

                // 작은 수를 찾은 경우
                if(nums[currentIndex]>nums[compareIndex]) {
                    maxLen = Math.max(maxLen,LIS[compareIndex]+1);
                }
            }

            // 저장
            LIS[currentIndex] = maxLen;
        }
    }

    // LDS 수행 메서드
    public static void executeLDS() {

        // 확인 위치
        for(int currentIndex=nums.length-1; currentIndex>=0; currentIndex--) {

            // 길이
            int maxLen = 1;

            // 비교 위치
            for(int compareIndex=currentIndex+1; compareIndex<nums.length; compareIndex++) {

                // 작은 수를 찾은 경우
                if(nums[currentIndex]>nums[compareIndex]) {
                    maxLen = Math.max(maxLen,LDS[compareIndex]+1);
                }
            }

            // 저장
            LDS[currentIndex] = maxLen;
        }
    }

    // LBS 계산 메서드
    public static int calculateLBS() {

        // 결과
        int answer = 0;

        for(int index=0; index<nums.length; index++) {
            answer = Math.max(answer,LIS[index]+LDS[index]);
        }

        return answer-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        numCount = Integer.parseInt(br.readLine());

        // 숫자 정보 배열 생성
        nums = new int[numCount];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<numCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
        }

        // LIS 배열 생성, 수행
        LIS = new int[numCount];
        executeLIS();

        // LDS 배열 생성, 수행
        LDS = new int[numCount];
        executeLDS();

        // 결과 출력
        System.out.println(calculateLBS());
    }
}