import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 최대 개수
    public static final int MAX_COUNT = 100001;

    // 동전 종류 배열
    public static int[] kinds = {2,5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 거스름 돈 입력
        int money = Integer.parseInt(br.readLine());

        // 개수 저장 배열 생성
        int[] count = new int[money+1];
        Arrays.fill(count,MAX_COUNT);
        count[0] = 0;

        // 2원부터 확인
        for(int index=2; index<=money; index++) {
            for(int kind=0; kind<2; kind++) {

                // 금액 범위 확인
                if(index-kinds[kind]<0) continue;

                // 거스르기 가능한 경우
                if(count[index-kinds[kind]]!=MAX_COUNT) {
                    count[index] = Math.min(count[index-kinds[kind]]+1,count[index]);
                }
            }
        }

        // 결과 출력
        int answer = count[money]==MAX_COUNT ? -1 : count[money];
        System.out.println(answer);
    }
}