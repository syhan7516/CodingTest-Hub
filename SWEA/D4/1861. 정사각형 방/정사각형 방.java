import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 방의 크기, 방 번호
	public static int roomSize, roomNum;
	// 방
	public static int room[][];
	// 결과
	public static int result[];
	// 델타
	public static int dy[] = {0,1,0,-1};
	public static int dx[] = {1,0,-1,0};

	// 방 탐색 메서드
	static void solve(int row, int col) {
		
		// 진행 여부 저장
		boolean flag = false;
		
		// 탐색 횟수
		int searchCnt = 1;
		
		while(true) {
			
			// 네 방향 탐색
			for(int d=0; d<4; d++) {
				
				int ny = row+dy[d];
				int nx = col+dx[d];
				
				// 방 범위 확인
				if(ny<0 || ny>roomSize-1 || nx<0 || nx>roomSize-1) {
					flag = true;
					continue;
				}
				
				// 갈 수 없는 방인 경우
				if(room[ny][nx]!=room[row][col]+1) {
					flag = true;
					continue;
				}
				
				// 좌표 갱신
				row = ny;
				col = nx;
				
				// 탐색 횟수 증가
				searchCnt++;
				
				// 탐색 성공 여부
				flag = false;
				break;
				
			}
			
			// 탐색 성공 여부
			if(flag) break;
		}
	
		// 결과 갱신
		if(result[1]<=searchCnt) {
			
			// 탐색 횟수가 같을 경우
			if(result[1]==searchCnt) {
				// 방 번호가 더 작은 것으로 갱신
				if(result[0]>roomNum) {
					result[0] = roomNum;
					result[1] = searchCnt;
				}
			}
			
			// 탐색 횟수가 다를 경우
			else {
				result[0] = roomNum;
				result[1] = searchCnt;
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
			
			// 방 크기 입력
			roomSize = Integer.parseInt(br.readLine());
			
			// 방 정보 입력
			room = new int[roomSize][roomSize];
			
			for(int i=0; i<roomSize; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<roomSize; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 방 탐색
			result = new int[2];
			roomNum = -1;
			for(int i=0; i<roomSize; i++) {
				for(int j=0; j<roomSize; j++) {
					roomNum = room[i][j];
					solve(i,j);
				}
			}
			
			// 결과 저장
			sb.append("#").append(caseIdx+1).append(" ").append(result[0]).append(" ").append(result[1]).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}