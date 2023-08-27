import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static String ans;
	static int R, C;
	static char[][] forest;
	static int[][] visited;
	static Queue<Node> water;
	static Queue<Node> queue;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = "KAKTUS";

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		forest = new char[R][C];
		visited = new int[R][C];

		water = new LinkedList<>();

		queue = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			char[] info = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (info[c] == 'S') {
					queue.offer(new Node(r, c));
					visited[r][c] = 1;
					forest[r][c] = '.';
				} else {
					if (info[c] == '*') {
						water.offer(new Node(r, c));
					}
					forest[r][c] = info[c];
				}
			}
		}

		bfs();
//		System.out.println(Arrays.toString(forest[0]));
//		System.out.println(Arrays.toString(forest[1]));
//		System.out.println(Arrays.toString(forest[2]));
//		System.out.println(Arrays.toString(forest[3]));
//		System.out.println(Arrays.toString(forest[4]));
//
//		System.out.println(Arrays.toString(visited[0]));
//		System.out.println(Arrays.toString(visited[1]));
//		System.out.println(Arrays.toString(visited[2]));
//		System.out.println(Arrays.toString(visited[3]));
//		System.out.println(Arrays.toString(visited[4]));

		System.out.println(ans);

	}

	static boolean makeWater(int wSize) {

		return true;
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			int wSize = water.size();

			for (int w = 0; w < wSize; w++) {
				Node curW = water.poll();

				for (int i = 0; i < 4; i++) {
					int nr = curW.r + dr[i];
					int nc = curW.c + dc[i];

					if (nr >= 0 && nr < R && nc >= 0 && nc < C && forest[nr][nc] == '.') {
						forest[nr][nc] = '*';
						water.add(new Node(nr, nc));
					}
				}
			}
			
			int fSize = queue.size();
			for (int f = 0; f < fSize; f++ ) {
				Node cur = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr >= 0 && nr < R && nc >= 0 && nc < C && visited[nr][nc] == 0 ) {
						if (forest[nr][nc] == 'D') {
							ans = (String.valueOf(visited[cur.r][cur.c]));
							return;
						} else if (forest[nr][nc] == '.') {
							visited[nr][nc] = visited[cur.r][cur.c] + 1;
							queue.add(new Node(nr, nc));
						}
					}
				}
				
			}
			

		}
	}
}