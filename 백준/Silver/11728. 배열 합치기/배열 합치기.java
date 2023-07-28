import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 배열 크기 입력
        st = new StringTokenizer(br.readLine());
        int firSize = Integer.parseInt(st.nextToken());
        int secSize = Integer.parseInt(st.nextToken());

        // 배열 생성
        int result[] = new int[firSize+secSize];

        // 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<firSize; idx++)
            result[idx] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int idx=firSize; idx<firSize+secSize; idx++)
            result[idx] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(result);

        // 결과 저장
        for(int data: result) sb.append(data+" ");

        // 결과 출력
        System.out.println(sb);
    }
}