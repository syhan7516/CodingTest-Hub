import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 용액의 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 용액 정보 배열 생성
        int values[] = new int[cnt];

        // 용액 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++)
            values[i] = Integer.parseInt(st.nextToken());

        // 결과
        int answer = Integer.MAX_VALUE;

        // 용액 합쳐보기
        int start = 0;
        int end = cnt-1;

        while(start<end) {

            // 두 용액 섞기
            int sum = values[start]+values[end];

            // 확인
            int mix = Math.abs(sum);

            // 섞은 용액이 0에 더 가까운 경우
            if(mix<=Math.abs(answer)) {
                answer = sum;
                if(answer==0) break;
            }

            // 합친 용액이 0보다 큰 경우
            if(sum<0) {
                start++;
            }

            // 합친 용액이 0보다 작은 경우
            else {
                end--;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}