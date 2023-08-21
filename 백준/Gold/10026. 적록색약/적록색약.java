import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 구역 크기, 결과
	public static int areaSize, result[];
	// 구역
	public static char area[][];
	// 구역 방문 여부 배열
	public static boolean visited[][];
	// 델타
	public static int dy[] = {0,1,0,-1};
	public static int dx[] = {1,0,-1,0};
	
	// 탐색 수행 메서드
	static void solve(int row, int col, char color) {
		
		// 방문 처리
		visited[row][col] = true;
		
		// 색 변경
		if(color=='R') area[row][col] = 'G';
		
		// 탐색 가능한 곳 확인
		for(int d=0; d<4; d++) {
			int ny = row+dy[d];
			int nx = col+dx[d];
			
			// 범위 확인
			if(ny<0 || ny>areaSize-1 || nx<0 || nx>areaSize-1) continue;
			
			// 이미 방문한 경우
			if(visited[ny][nx]) continue;
			
			// 다른 색인 경우
			if(area[ny][nx]!=color) continue;
			
			// 그 외의 경우
			solve(ny,nx,color);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 구역 크기 입력
		areaSize = Integer.parseInt(br.readLine());
		
		// 구역 생성
		area = new char[areaSize][areaSize];
		
		// 구역 정보 입력
		for(int i=0; i<areaSize; i++) {
			String line = br.readLine();
			for(int j=0; j<areaSize; j++) {
				area[i][j] = line.charAt(j);
			}
		}
		
		// 결과
		result = new int[2];
		
		// 일반인 방문 여부 배열
		visited = new boolean[areaSize][areaSize];
		
		// 일반인 탐색 수행
		for(int i=0; i<areaSize; i++) {
			for(int j=0; j<areaSize; j++) {
				
				// 방문하지 않았을 경우
				if(!visited[i][j]) {
					solve(i,j,area[i][j]);
					result[0]++;
				}
			}
		}
		
		// 적록색약 방문 여부 배열
		visited = new boolean[areaSize][areaSize];
		
		// 색약 탐색 수행
		for(int i=0; i<areaSize; i++) {
			for(int j=0; j<areaSize; j++) {
				
				// 방문하지 않았을 경우
				if(!visited[i][j]) {
					solve(i,j,area[i][j]);
					result[1]++;
				}
			}
		}
		
		// 결과 출력
		System.out.println(result[0]+" "+result[1]);
	}
}