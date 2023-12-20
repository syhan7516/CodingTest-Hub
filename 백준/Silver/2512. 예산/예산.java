import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 예산 구하기 메서드
    static int solve(int start, int end, int range, int arr[]) {

        // 결과
        int result = 0;

        while(start<=end) {

            // 필요 예산
            int current = 0;

            // 상한액
            int mid = (start+end)/2;

            // 확인
            for(int i=0; i<arr.length; i++) {

                // 상한액 이상인 경우
                if(arr[i]>mid)
                    current += mid;

                // 상한액 범위 내인 경우
                else
                    current += arr[i];
            }

            // 범위 내인 경우
            if(current<=range) {
                result = Math.max(result,mid);
                start = mid+1;
            }

            // 범위 밖인 경우
            else end = mid-1;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지방 수 입력
        int cityCnt = Integer.parseInt(br.readLine());

        // 예산 요청 정보 배열
        int money[] = new int[cityCnt];

        // 필요 예산
        int required = 0;

        // 가장 큰 예산
        int max = 0;

        // 예산 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityCnt; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,money[i]);
            required += money[i];
        }

        // 총 예산 입력
        int totalMoney = Integer.parseInt(br.readLine());

        // 필요 예산이 총 예산 내에 들어온 경우
        if(totalMoney>=required)
            System.out.println(max);

        // 필요 예산이 범위를 넘어선 경우
        else
            System.out.println(solve(1,max,totalMoney,money));
    }
}