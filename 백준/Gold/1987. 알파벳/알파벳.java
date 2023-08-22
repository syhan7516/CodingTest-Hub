import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 보드 가로, 세로 크기, 결과
	public static int rowSize, colSize, result;
	// 보드
	public static char board[][];
	// 알파벳 방문 여부 배열
	public static boolean visited[][];
	public static boolean alpha[];
	// 델타
	public static int dy[] = {0,1,0,-1};
	public static int dx[] = {1,0,-1,0};
	
	// 말 옮기기 메서드 수행
	static void solve(int row, int col, int cnt) {
		
		// 결과 값 갱신
		result = Math.max(result,cnt);
		
		// 방향 탐색
		for(int d=0; d<4; d++) {
			int ny = row+dy[d];
			int nx = col+dx[d];
			
			// 보드 밖인 경우
			if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;
			
			// 보드를 방문한 경우
			if(visited[ny][nx]) continue;
			
			// 이미 방문한 알파벳인 경우
			if(alpha[board[ny][nx]-'A']) continue;
			
			// 그 외 경우
			visited[ny][nx] = true;
			alpha[board[ny][nx]-'A'] = true;
			
			solve(ny,nx,cnt+1);
			
			// 되돌리기
			visited[ny][nx] = false;
			alpha[board[ny][nx]-'A'] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 보드 가로, 세로 입력
		st = new StringTokenizer(br.readLine());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		// 보드 생성
		board = new char[rowSize][colSize];
		
		// 보드 정보 입력
		for(int i=0; i<rowSize; i++) {
			String line = br.readLine();
			for(int j=0; j<colSize; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		// 말 옮기기
		visited = new boolean[rowSize][colSize];
		alpha = new boolean[26];
		alpha[board[0][0]-'A'] = true;
		visited[0][0] = true;
		solve(0,0,1);
		
		// 결과 출력
		System.out.println(result);
	}
}