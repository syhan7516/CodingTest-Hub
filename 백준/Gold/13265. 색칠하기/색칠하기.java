import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i=0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[][] route = new boolean[N][N]; // 연결 노드 

            for (int j=0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                route[x][y] = true;
                route[y][x] = true;
            }

            System.out.println(cal(route, N));
        }

    }


    public static String cal(boolean[][] route, int N) {
        boolean[] visited = new boolean[N];
        int[] colors = new int[N];

        for (int i=0; i < N; i++) {
            if (!visited[i]) { // 방문 기록이 없는 노드로 시작
                dfs(route, i, N, visited, colors, 1); // 색칠하기 
            }
        }

        for (int i=0; i < N; i++) {
            for (int j=0; j < N; j++) {
                if (i != j && route[i][j] && colors[i] == colors[j]) { // 만약 두 노드가 색이 같으면 2가지 색으로 처리 불가
                    return "impossible";
                }
            }
        }

        return "possible";
    }

    public static void dfs(boolean[][] map, int loc, int N, boolean[] visited, int[] colors, int color) {
        visited[loc] = true; // 방문 기록
        colors[loc] = color; // 색 설정

        for (int i=0; i < N; i++) {
            if (!visited[i] && map[loc][i]) {
                dfs(map, i, N, visited, colors, color == 1 ? 2 : 1); // 색 변경 후 연결 노드로 이동
            }
        }

    }
}