import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 결과
        int count = 0;

        // 입력 개수
        int numCnt = Integer.parseInt(st.nextToken());

        // 수 배열
        int nums[] = new int[numCnt];

        // 수 입력
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<numCnt; idx++) {
            nums[idx] = Integer.parseInt(st.nextToken());
        }

        // 소수 판별
        for(int idx=0; idx<numCnt; idx++) {
            int number = nums[idx];
            boolean flag = false;
            // 2부터 자기 자신-1까지 나누기
            for(int a=2; a<number; a++) {
                if(number%a==0)
                    flag = true;
            }
            // 숫자 1 제외
            if(number!=1 && flag==false)
                count += 1;
        }

        // 결과 출력
        System.out.println(count);
    }
}