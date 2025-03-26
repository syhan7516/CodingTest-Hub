import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// 상하좌우, 대각선
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static int N, M;
	static int[][] map;
	
	static boolean[][] visited;
	static boolean isTop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					if (bfs(i, j)) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
	
		q.add(new Pair(x, y));
		visited[x][y] = true;
		
		int height = map[x][y];
		
		boolean flag = true;
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!isRange(nx, ny)) {
					continue;
				}
				
				// 현재 높이보다 더 높은 봉우리가 있는 경우 산봉우리가 될 수 없음
				if (map[nx][ny] > map[x][y]) {
					flag = false; // 바로 false를 반환해버리면 해당 산봉우리 전체를 구할 수가 없기 때문에 flag 변수 사용
				}
				
				if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
					q.add(new Pair(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		return flag;
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (!isRange(nx, ny)) {
				continue;
			}
			
			// 현재 높이보다 더 높은 봉우리가 있는 경우 산봉우리가 될 수 없음
			if (map[nx][ny] > map[x][y]) {
				isTop = false;
			}
			
			if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
				dfs(nx, ny);
			}
		}
		
		return;
	}
	
	private static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}