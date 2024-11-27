import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 연변장 크기, 조교 수
    public static int size, assistantCount;

    // 연변장
    public static int ground[];

    // 합 배열
    public static int sum[];

    // 연변장 높이 확인 메서드
    public static void solve() {

        // 추가 높이
        int addValue = 0;

        // 연변장 순회
        for(int index=1; index<=size; index++) {

            // 높이 변화가 있는 경우
            if(sum[index]!=0)
                addValue += sum[index];

            // 높이 맞추기
            ground[index] += addValue;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 연변장 크기, 조교 수 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        assistantCount = Integer.parseInt(st.nextToken());

        // 연변장 배열 생성
        ground = new int[size+1];

        // 합 배열 생성
        sum = new int[size+2];

        // 연변장 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=size; index++)
            ground[index] = Integer.parseInt(st.nextToken());

        // 지시 정보 입력
        for(int order=0; order<assistantCount; order++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            sum[start] += height;
            sum[end+1] -= height;
        }

        // 연변장 높이 확인
        solve();

        // 최종 높이 저장
        for(int index=1; index<=size; index++)
            sb.append(ground[index]).append(" ");

        // 결과 출력
        System.out.println(sb.toString());
    }
}