import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        long answer = 0;

        // 기름 가격 기준
        int gas = Integer.MAX_VALUE;

        // 도시 개수 입력
        int cityCnt = Integer.parseInt(br.readLine());

        // 도시 거리 배열 생성
        int dist[] = new int[cityCnt];

        // 도시 거리 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<dist.length-1; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        // 도시 기름 가격 배열 생성
        int price[] = new int[cityCnt];

        // 도시 기름 가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityCnt; i++) {
            price[i] = Integer.parseInt(st.nextToken());

            // 주유 비용이 더 적은 경우
            if(price[i]<gas)
                gas = price[i];

            // 기름 값 계산
            answer += (long) gas * dist[i];
        }

        // 결과 출력
        System.out.println(answer);
    }
}