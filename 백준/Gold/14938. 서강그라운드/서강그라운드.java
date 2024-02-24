import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 최대 비용
    public static final int MAX = (int)1e9;

    // 지역 수, 수색 범위, 길의 수, 결과
    public static int localCnt, searchRange, roadCnt, answer;

    // 연결 관계 배열
    public static int path[][];

    // 아이템 개수 배열
    public static int item[];

    // 수색 수행 메서드
    static void solve() {

        // 최단 거리 구하기
        for(int k=1; k<=localCnt; k++) {
            for(int i=1; i<=localCnt; i++) {
                for(int j=1; j<=localCnt; j++) {
                    path[i][j] = Math.min(path[i][j],path[i][k]+path[k][j]);
                }
            }
        }
        
        // 수색하기
        for(int i=1; i<=localCnt; i++) {
            int itemCnt = item[i];
            for(int j=1; j<=localCnt; j++) {

                // 수색 거리에 들어오는 경우
                if(i!=j && path[i][j]<=searchRange) {
                    itemCnt += item[j];
                }
            }

            // 결과 갱신
            answer = Math.max(answer,itemCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지역 수, 수색 범위, 길의 수 입력
        st = new StringTokenizer(br.readLine());
        localCnt = Integer.parseInt(st.nextToken());
        searchRange = Integer.parseInt(st.nextToken());
        roadCnt = Integer.parseInt(st.nextToken());

        // 최단 경로 배열 생성, 초기화
        path = new int[localCnt+1][localCnt+1];
        for(int i=1; i<=localCnt; i++) {
            for(int j=1; j<=localCnt; j++) {
               path[i][j] = MAX;
               if(i==j) path[i][j] = 0;
            }
        }

        // 아이템 개수 배열 생성
        item = new int[localCnt+1];

        // 아이템 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=localCnt; i++)
            item[i] = Integer.parseInt(st.nextToken());

        // 관계 배열 입력
        for(int i=0; i<roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            path[from][to] = dist;
            path[to][from] = dist;
        }

        // 수색 수행
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}