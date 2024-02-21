import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 최장 경로
    public static final int MAX = (int)1e9;

    // 도시 개수, 버스 개수
    public static int cityCnt, busCnt;

    // 최단 경로 배열
    public static int path[][];

    // 최단 경로 구하기 메서드
    static void solve() {

        for(int i=1; i<=cityCnt; i++) {
            for(int j=1; j<=cityCnt; j++) {
                for(int k=1; k<=cityCnt; k++) {
                    path[j][k] = Math.min(path[j][i]+path[i][k],path[j][k]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시 개수 입력
        cityCnt = Integer.parseInt(br.readLine());

        // 버스 개수 입력
        busCnt = Integer.parseInt(br.readLine());

        // 최단 경로 배열 생성
        path = new int[cityCnt+1][cityCnt+1];

        // 최단 경로 배열 초기화
        for(int i=1; i<=cityCnt; i++) {
            for(int j=1; j<=cityCnt; j++) {
                path[i][j] = MAX;
                if(i==j) path[i][j] = 0;
            }
        }

        // 버스 정보 입력
        for(int i=0; i<busCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            path[from][to] = Math.min(path[from][to],dist);
        }

        // 최단 경로 구하기
        solve();

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=cityCnt; i++) {
            for(int j=1; j<=cityCnt; j++) {
                if(path[i][j]==MAX)
                    sb.append(0).append(" ");
                else
                    sb.append(path[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}