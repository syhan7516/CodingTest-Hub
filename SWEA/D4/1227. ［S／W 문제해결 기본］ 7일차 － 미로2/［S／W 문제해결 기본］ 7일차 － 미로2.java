import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	private int y;
	private int x;
	
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
}

public class Solution {
	
	// 보드
	public static char board[][];
	// 시작점, 결과
	public static int startY, startX, result;
	// 노드 큐
	public static Queue<Node> queue;
	// 델타
	public static int dy[] = {0,1,0,-1};
	public static int dx[] = {1,0,-1,0};
	
	// 미로 탐색
	static void solve(int y, int x) {
		
		// 노드 저장 큐 만들기
		queue = new LinkedList();
		// 출발점 설정
		queue.offer(new Node(y,x));
		board[y][x] = '1';
		
		while(!queue.isEmpty()) {
			
			// 탐색 노드 꺼내기
			Node curNode = queue.poll();
			int curY = curNode.getY();
			int curX = curNode.getX();
			
			// 방향 검색
			for(int d=0; d<4; d++) {
				// 진행 방향
				int ny = curY+dy[d];
				int nx = curX+dx[d];
				// 장외 확인
				if(ny<0 || ny>100-1 || nx<0 || nx>100-1) continue;
				// 벽 확인
				if(board[ny][nx]=='1') continue;
				
				// 도착점인 경우
				if(board[ny][nx]=='3') {
					result = 1;
					return;
				}
				
				// 이동
				board[ny][nx] = '1';
				queue.offer(new Node(ny,nx));
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<10; caseIdx++) {
			
			br.readLine();
			
			// 보드 만들기
			board = new char[100][100];
			for(int a=0; a<100; a++) {
				String line = br.readLine();
				for(int b=0; b<100; b++) {
					board[a][b] = line.charAt(b);
					
					// 시작점인 경우
					if(board[a][b]=='2') {
						startY = a;
						startX = b;
					}
				}
			}
			
			// 미로 탐색
			result = 0;
			solve(startY,startX);
			
			// 결과 저장
			sb.append("#"+(caseIdx+1)+" "+result+"\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}