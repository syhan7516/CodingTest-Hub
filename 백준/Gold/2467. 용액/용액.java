import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 용액 개수 입력
        int cnt = Integer.parseInt(br.readLine());

        // 용액 정보 배열 생성
        int material[] = new int[cnt];

        // 용액 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }

        // 용액 정렬
        Arrays.sort(material);

        // 결과
        int answer = Integer.MAX_VALUE;

        // 0에 가까운 두 용액 찾기
        int left = 0;
        int right = cnt-1;
        int first = -1;
        int second = -1;

        while(left<right) {

            // 용액의 합
            int sum = material[left]+material[right];
            int mix = Math.abs(sum);

            // 결과 갱신
            if(Math.abs(answer)>=mix) {
                answer = sum;
                first = material[left];
                second = material[right];
            }

            // 위치 이동
            if(sum>0) right--;
            else left++;
        }

        // 결과 출력
        System.out.println(first+" "+second);
    }
}