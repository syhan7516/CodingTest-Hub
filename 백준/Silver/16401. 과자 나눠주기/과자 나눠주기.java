import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 과자 나누기 메서드
    static int solve(int arr[], int cnt, int maxLen) {

        // 결과
        int answer = 0;

        // 초기 시작과 끝
        int start = 1;
        int end = maxLen;

        while(start<=end) {

            // 자를 길이
            int mid = (start+end)/2;

            // 얻은 과자 수
            int current = 0;

            // 주어진 과자 확인
            for(int i=arr.length-1; i>=0; i--) {

                // 과자를 자를 수 있는 경우
                if(mid<=arr[i]) {
                    current += (arr[i]/mid);
                }

                // 과자를 인원 수 만큼 자른 경우
                if(current>=cnt) break;
            }

            // 사람 만큼 과자가 잘린 경우
            if(current>=cnt) {
                answer = Math.max(answer,mid);
                start = mid+1;
            }

            // 아닌 경우
            else {
                end = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 조카 수, 과자 수 입력
        st = new StringTokenizer(br.readLine());
        int saramCnt = Integer.parseInt(st.nextToken());
        int snackCnt = Integer.parseInt(st.nextToken());

        // 과자 길이 정보 배열 생성
        int snackLen[] = new int[snackCnt];

        // 가장 긴 과자 길이
        int maxLen = 0;

        // 과자 길이 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<snackCnt; i++) {
            snackLen[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen,snackLen[i]);
        }

        // 과자 나누기
        int answer = solve(snackLen,saramCnt,maxLen);

        // 결과 출력
        System.out.println(answer);
    }
}