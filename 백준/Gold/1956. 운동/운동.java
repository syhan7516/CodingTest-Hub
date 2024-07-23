import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 정점, 간선 개수
    public static int answer, nodeCnt, edgeCnt;

    // 최단 경로 배열
    public static int path[][];

    // 최단 경로 구하기 메서드
    public static void shortestPath() {

        // 플로이드 워셜
        for(int k=1; k<=nodeCnt; k++) {
            for(int i=1; i<=nodeCnt; i++) {
                for(int j=1; j<=nodeCnt; j++) {
                    path[i][j] = Math.min(path[i][j],path[i][k]+path[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        edgeCnt = Integer.parseInt(st.nextToken());

        // 최단 경로 배열 생성
        path = new int[nodeCnt+1][nodeCnt+1];

        // 초기화
        for(int i=1; i<=nodeCnt; i++) {
            for(int j=1; j<=nodeCnt; j++) {
                if(i==j) path[i][j] = 0;
                else path[i][j] = (int)1e9;
            }
        }

        // 간선 정보 입력
        for(int i=0; i<edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            path[start][end] = Integer.parseInt(st.nextToken());
        }

        // 최단 경로 구하기
        shortestPath();

        // 왕복 거리 구하기
        answer = (int)1e9;
        for(int i=1; i<=nodeCnt; i++) {
            for(int j=1; j<=nodeCnt; j++) {
                if(i==j) continue;
                else answer = Math.min(answer,path[i][j]+path[j][i]);
            }
        }

        // 결과 출력
        if(answer==(int)1e9) System.out.println(-1);
        else System.out.println(answer);
    }
}