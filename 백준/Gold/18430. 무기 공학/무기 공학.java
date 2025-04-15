import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
		
        map = new int[N][M];
        visited = new boolean[N][M];
		
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
        findBoomerang(0, 0);
        System.out.println(ans);
    }
	
    public static void findBoomerang(int idx, int tmpSum) {
        if (idx == N*M) {
            ans = Math.max(ans, tmpSum);
            return;
        }
		
        int x = idx/M;
        int y = idx%M;
		
        if (!visited[x][y]) {
            // ┑
            if (x+1 < N && y-1 >= 0 && !visited[x+1][y] && !visited[x][y-1]) {
                visited[x+1][y] = true;
                visited[x][y] = true;
                visited[x][y-1] = true;
                findBoomerang(idx+1, tmpSum + map[x+1][y] + map[x][y-1] + (map[x][y]*2));
                visited[x+1][y] = false;
                visited[x][y] = false;
                visited[x][y-1] = false;
            }
            // ┙
            if (x-1 >= 0 && y-1 >= 0 && !visited[x-1][y] && !visited[x][y-1]) {
                visited[x-1][y] = true;
                visited[x][y] = true;
                visited[x][y-1] = true;
                findBoomerang(idx+1, tmpSum + map[x-1][y] + map[x][y-1] + (map[x][y]*2));
                visited[x-1][y] = false;
                visited[x][y] = false;
                visited[x][y-1] = false;
            }
            // ┕
            if (x-1 >= 0 && y+1 < M && !visited[x-1][y] && !visited[x][y+1]) {
                visited[x-1][y] = true;
                visited[x][y] = true;
                visited[x][y+1] = true;
                findBoomerang(idx+1, tmpSum + map[x-1][y] + map[x][y+1] + (map[x][y]*2));
                visited[x-1][y] = false;
                visited[x][y] = false;
                visited[x][y+1] = false;
            }
            // ┍
            if (x+1 < N && y+1 < M && !visited[x+1][y] && !visited[x][y+1]) {
                visited[x+1][y] = true;
                visited[x][y] = true;
                visited[x][y+1] = true;
                findBoomerang(idx+1, tmpSum + map[x+1][y] + map[x][y+1] + (map[x][y]*2));
                visited[x+1][y] = false;
                visited[x][y] = false;
                visited[x][y+1] = false;
            }
        }
		
        findBoomerang(idx+1, tmpSum);
    }
}