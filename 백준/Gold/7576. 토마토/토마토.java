import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int y;
	int x;
	
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	
	// 상자의 크기, 최소 일 수, 토마토 개수
	public static int rowSize, colSize, day, tomatoCnt;
	// 상자
	public static int box[][];
	// 토마토 위치 큐
	public static Queue<Point> queue;
	// 델타
	public static int dy[] = {0,1,0,-1};
	public static int dx[] = {1,0,-1,0};
	
	// 토마토 익히기
	static void solve() {
		
		// 더 이상 익힐 수 없을 때까지 수행
		while(!queue.isEmpty()) {
			
			// 하루 동안 익은 토마토 확인
			int size = queue.size();
			
			// 익은 토마토 주위 확인
			while(size-->0) {
				
				// 현재 토마토
				Point curTomato = queue.poll();
				
				// 네 방향 확인
				for(int dir=0; dir<4; dir++) {
					
					int ny = curTomato.y+dy[dir];
					int nx = curTomato.x+dx[dir];
					
					// 범위 밖인 경우
					if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;
					// 토마토가 익거나, 없는 경우
					if(box[ny][nx]==-1 || box[ny][nx]==1) continue;
					
					// 토마토 익히기
					box[ny][nx]=1;
					
					// 덜 익은 토마토 개수 갱신
					tomatoCnt--;
					
					// 탐색 토마토에 추가
					queue.offer(new Point(ny,nx));
				}
			}
			
			// 하루 증가
			day++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 세로, 가로 입력
		st = new StringTokenizer(br.readLine());
		colSize = Integer.parseInt(st.nextToken());
		rowSize = Integer.parseInt(st.nextToken());
		
		// 상자 만들기
		box = new int[rowSize][colSize];
		
		// 큐 생성
		queue = new LinkedList<>();
		
		// 상자 토마토 채우기
		for(int i=0; i<rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<colSize; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				// 익은 토마토일 경우
				if(box[i][j]==1) queue.offer(new Point(i,j));
				
				// 일반 토마토인 경우
				if(box[i][j]==0) tomatoCnt++;
			}
		}
		
		// 토마토 익히기
		solve();
		
		// 결과 출력
		if(tomatoCnt==0) System.out.println(day-1);
		else System.out.println(-1);
	}
}