import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 물병 개수, 옮길 수 있는 개수 입력
        st = new StringTokenizer(br.readLine());
        int bottleCount = Integer.parseInt(st.nextToken());
        int portableBottleCount = Integer.parseInt(st.nextToken());

        // 물병 개수
        int currentBottleCount = Integer.bitCount(bottleCount);

        // 물병 구매하기
        while(currentBottleCount>portableBottleCount) {
            bottleCount++;
            currentBottleCount = Integer.bitCount(bottleCount);
            answer++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}