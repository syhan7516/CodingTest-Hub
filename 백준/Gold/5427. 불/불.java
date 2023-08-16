import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스
class Node {
	int y;
	int x;
	int dist;
	
	public Node(int y, int x, int dist) {
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
}

public class Main {	
	
	// 공간 크기, 결과
	public static int rowSize, colSize, result;
	// 공간
	public static char room[][];
	// 불 경로 저장  큐, 사람 경로 저장 큐
	public static Queue<Node> human, fire;
	// 상근이 경로 방문 배열
	public static boolean visited[][];
	// 델타
	public static int dy[] = {0,1,0,-1};
	public static int dx[] = {1,0,-1,0};
	
	// 탈출하기 메서드
	static void solve() {
		
		while(!human.isEmpty()) {
			
			// 불 경로 깊이
			int size = fire.size();
			
			// 불 경로 확인
			while(size-->0) {
				
				// 현재 위치
				Node curNode = fire.poll();
				
				// 네 방향 확인
				for(int d=0; d<4; d++) {
					int ny = curNode.y+dy[d];
					int nx = curNode.x+dx[d];
					
					// 공간 범위 확인
					if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) continue;
					// 벽, 불 확인
					if(room[ny][nx]=='*' || room[ny][nx]=='#') continue;
					// 불 이동
					fire.offer(new Node(ny,nx,0));
					room[ny][nx] = '*';
				}
			}
			
			// 사람 경로 깊이
			size = human.size();
			
			// 사람 경로 확인
			while(size-->0) {
				
				// 현재 위치
				Node curNode = human.poll();
				
				// 네 방향 확인
				for(int d=0; d<4; d++) {
					int ny = curNode.y+dy[d];
					int nx = curNode.x+dx[d];
					
					// 공간 범위 확인
					if(ny<0 || ny>rowSize-1 || nx<0 || nx>colSize-1) {
						result = curNode.dist;
						return;
					}
					// 벽, 불 확인
					if(room[ny][nx]=='*' || room[ny][nx]=='#') continue;
					// 방문 여부 확인
					if(visited[ny][nx]) continue;
					// 사람 이동
					human.offer(new Node(ny,nx,curNode.dist+1));
					visited[ny][nx] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 입력
		int caseNum = Integer.parseInt(br.readLine());
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
			// 공간 입력
			st = new StringTokenizer(br.readLine());
			colSize = Integer.parseInt(st.nextToken());
			rowSize = Integer.parseInt(st.nextToken());
			
			// 기본 셋팅
			result = 0;
			human = new LinkedList<>();
			fire = new LinkedList<>();
			visited = new boolean[rowSize][colSize];
			
			
			// 공간 생성
			room = new char[rowSize][colSize];
			
			// 공간 정보 입력
			for(int i=0; i<rowSize; i++) {
				String line = br.readLine();
				for(int j=0; j<colSize; j++) {
					room[i][j] = line.charAt(j);
					
					// 불인 경우
					if(room[i][j]=='*') fire.offer(new Node(i,j,0));
					
					// 사람인 경우
					if(room[i][j]=='@') {
						human.offer(new Node(i,j,1));
						visited[i][j] = true;
					}
				}
			}
			
			// 탈출하기
			solve();
			
			// 결과 저장
			if(result==0) sb.append("IMPOSSIBLE");
			else sb.append(result);
			sb.append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}
