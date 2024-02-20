import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 건물 수, 도로 수
    public static int buildingCnt, roadCnt;

    // 결과
    public static int answer[];

    // 인접 배열
    public static int path[][];

    // 최단 경로 거리 확인
    static void distCheck(int point1, int point2) {

        // 거리
        int distance = 0;

        // 건물 지정
        int small = Math.min(point1,point2);
        int big = Math.max(point1,point2);

        // 집과의 거리 확인
        for(int b=1; b<=buildingCnt; b++) {

            // 매장인 경우
            if(b==point1 || b==point2) continue;

            // 매장이 아닌 경우
            distance += Math.min(path[small][b],path[big][b]);
        }

        // 기존 값과 비교
        if(distance<=answer[0]) {

            // 거리가 같은 경우
            if(distance==answer[0]) {

                // 작은 건물 비교
                if(answer[1]>=small) {

                    // 더 작은 경우
                    if(answer[1]>small) {
                        answer[1] = small;
                        answer[2] = big;
                    }

                    // 작은 건물이 같은 경우
                    else {

                        // 큰 건물이 더 작은 경우
                        if(answer[2]>big) {
                            answer[1] = small;
                            answer[2] = big;
                        }
                    }
                }
            }

            // 거리가 더 작은 경우
            else {
                answer[0] = distance;
                answer[1] = small;
                answer[2] = big;
            }
        }
    }

    // 최단 경로 찾기 메서드
    static void solve() {

        // 플로이드 워샬
        for(int i=1; i<=buildingCnt; i++) {
            for(int j=1; j<=buildingCnt; j++) {
                for(int k=1; k<=buildingCnt; k++) {
                    path[j][k] = Math.min(path[j][i]+path[i][k],path[j][k]);
                    path[k][j] = path[j][k];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 건물 수, 도로 수 입력
        st = new StringTokenizer(br.readLine());
        buildingCnt = Integer.parseInt(st.nextToken());
        roadCnt = Integer.parseInt(st.nextToken());

        // 인접 배열 생성
        path = new int[buildingCnt+1][buildingCnt+1];

        // 인접 배열 초기화
        for(int i=1; i<=buildingCnt; i++) {
            for(int j=1; j<=buildingCnt; j++) {
                path[i][j] = (int)1e9;
            }
        }


        // 연결 정보 입력
        for(int i=0; i<roadCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            path[first][second] = 1;
            path[second][first] = 1;
        }

        // 최단 경로 찾기
        answer = new int[] {(int)1e9, (int)1e9, (int)1e9};
        solve();
        for(int i=1; i<buildingCnt; i++) {
            for(int j=i+1; j<=buildingCnt; j++) {
                distCheck(i,j);
            }
        }

        // 결과 출력
        System.out.println(answer[1]+" "+answer[2]+" "+answer[0]*2);
    }
}
