import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 카드 개수 입력
        int cardCount = Integer.parseInt(br.readLine());

        // 카드 배열 생성
        long[] numbers = new long[cardCount];

        // 카드 정보 입력
        long cardNumSum = 0;
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<cardCount; index++) {
            numbers[index] = Long.parseLong(st.nextToken());
            cardNumSum += numbers[index];
        }

        // 해시 셋 생성
        HashSet<Long> sumSet = new HashSet<>();

        // 카드 확인
        int totalSubsets = 1 << cardCount;
        for(int mask=1; mask<totalSubsets; mask++) {
            long sum = 0;
            for(int cardIndex=0; cardIndex<cardCount; cardIndex++) {
                if((mask & (1 << cardIndex)) != 0) {
                    sum += numbers[cardIndex];
                }
            }
            sumSet.add(sum);
        }

        // 결과 저장
        long count = 0;
        for (long sum : sumSet) {
            if (sum >= 1 && sum <= cardNumSum) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(cardNumSum - count);
    }
}