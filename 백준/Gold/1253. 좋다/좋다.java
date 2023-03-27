import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 숫자 개수, 좋다 개수
    public static int numCnt, goodCnt;
    // 숫자 정보 배열
    public static long numbers[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        numCnt = Integer.parseInt(br.readLine());

        // 숫자 정보 입력
        numbers = new long[numCnt];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<numCnt; idx++) {
            numbers[idx] = Integer.parseInt(st.nextToken());
        }
        
        // 숫자 정렬
        Arrays.sort(numbers);

        // 기본 셋팅
        goodCnt = 0;

        // 좋다 수 확인
        for(int n = 0; n<numbers.length; n++) {

            // 투 포인터 위치 설정
            int firPoint = 0;
            int secPoint = numbers.length-1;

            // 포인터 범위 제한
            while(firPoint<secPoint) {

                // 검사 번호 위치와 왼쪽 포인터 위치가 동일한 경우
                if(firPoint==n)
                    firPoint++;

                // 검사 번호 위치와 오른쪽 포인터 위치가 동일한 경우
                else if(secPoint==n)
                    secPoint--;

                // 검사 번호 위치와 포인터가 서로 다른 위치일 경우
                else {

                    // 현재 가르키는 포인터의 두 값 더하기
                    long curSum = numbers[firPoint] + numbers[secPoint];

                    // 좋다 수와 같은 경우
                    if(curSum==numbers[n]) {
                        goodCnt += 1;
                        break;
                    }

                    // 좋다 수보다 작은 경우
                    else if(curSum<numbers[n]) {
                        firPoint++;
                    }

                    // 좋다 수 보다 큰 경우
                    else {
                        secPoint--;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(goodCnt);
    }
}