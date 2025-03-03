import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동전 종류, 금액 입력
        st = new StringTokenizer(br.readLine());
        int kindCount = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        // 동전 종류 리스트 생성
        ArrayList<Integer> kinds = new ArrayList<>();

        // 동전 종류 입력
        for(int index=0; index<kindCount; index++) {
            kinds.add(Integer.parseInt(br.readLine()));
        }

        // 역정렬
        Collections.reverse(kinds);

        // 동전 거스르기
        int answer = 0;
        for(int index=0; index<kinds.size(); index++) {
            answer += money/kinds.get(index);
            money %= kinds.get(index);
        }

        // 결과 출력
        System.out.println(answer);
    }
}