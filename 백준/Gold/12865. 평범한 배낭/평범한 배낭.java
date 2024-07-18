import java.util.*;
import java.io.*;

public class Main {

    // 물건 개수, 가방 무게
    public static int cnt, bagWeight;

    // DP 테이블
    public static int DP[][];

    // 물건 무게, 가치 배열
    public static int[] weight, value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 물건 개수, 가방 무게 입력
        st = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(st.nextToken());
        bagWeight = Integer.parseInt(st.nextToken());

        // 무게, 가치 배열 생성
        weight = new int[cnt+1];
        value = new int[cnt+1];

        // 무게, 가치 정보 입력
        for(int i=1; i<=cnt; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블 생성
        DP = new int[101][100001];

        // 테이블 채우기
        for(int i=1; i<=cnt; i++) {
            for(int j=1; j<100001; j++) {

                // 넣었을 경우 무게가 넘치는 경우
                if(j-weight[i]<0) DP[i][j] = DP[i-1][j];

                // 넣었을 경우 무게가 넘치지 않는 경우
                else DP[i][j] = Math.max(DP[i-1][j],DP[i-1][j-weight[i]]+value[i]);
            }
        }

        // 결과 출력
        System.out.println(DP[cnt][bagWeight]);
    }
}