import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, K 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 누적합 정보 배열 생성
        int prefix[] = new int[N+1];

        // 결과
        long answer = 0;

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            prefix[i] = prefix[i-1]+Integer.parseInt(st.nextToken());
            if(prefix[i]==K) answer++;
        }

        // 누적합 정보 저장 해시 생성
        HashMap<Integer,Long> map = new HashMap<>();

        // 누적합 정보 저장
        for(int i=1; i<=N; i++) {
            if(map.containsKey(prefix[i]-K)) {
                answer += map.get(prefix[i]-K);
            }

            // 누적합 map 추가
            if(map.containsKey(prefix[i])) {
                map.put(prefix[i], map.get(prefix[i])+1);
            } 
            
            else {
                map.put(prefix[i], 1L);
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}