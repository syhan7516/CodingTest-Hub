import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 개수
        int kinds = Integer.parseInt(st.nextToken());
        int row[] = new int[kinds];

        // 길이 입력
        for(int idx=0; idx<kinds; idx++) {
            st = new StringTokenizer(br.readLine());
            row[idx] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(row);

        // 최대 중량
        long maxRow = 0;
        for(int idx=kinds-1; idx>=0; idx--) {

            // 중량 구하기
            row[idx] = row[idx]*(kinds-idx);

            // 최대보다 클 경우
            if(maxRow<row[idx]) maxRow = row[idx];
        }

        // 결과 출력
        System.out.println(maxRow);
    }
}
