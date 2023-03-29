import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 소수 구하기
        boolean primes[] = new boolean[1000001];

        // 숫자 1은 제외
        primes[1] = true;

        // 차례로 확인
        for(int a=2; a*a<=1000000; a++) {
            // 해당 수가 소수인 경우
            if(!primes[a]) {
                for(int b=a+a; b<=1000000; b+=a) {
                    primes[b] = true;
                }
            }
        }

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 좋아하는 수, 범위 시작 숫자, 범위 끝 숫자 입력
            st = new StringTokenizer(br.readLine());
            String likeNum = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 특별한 소수 구하기
            int count = 0;
            for(int idx=start; idx<=end; idx++) {
                // 좋아하는 수가 포함된 경우
                if((idx+"").contains(likeNum) && !primes[idx]) {
                    count += 1;
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+count+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}