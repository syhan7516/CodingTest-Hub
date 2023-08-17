import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	// 고객 수, 결과
	public static int clientCnt, result;
	// 거리 배열
	public static int dist[][];
	// 방문 여부 배열
	public static boolean visited[];
	
	// 최단 경로 확인 메서드
	static void solve(int node, int distance, int cnt) {
		
		// 종료 조건
		if(cnt==clientCnt) {
			distance += Math.abs(dist[node][0]-dist[1][0])+Math.abs(dist[node][1]-dist[1][1]);
			result = Math.min(result, distance);
			return;
		}
		
		// 계속 경로 확인
		for(int i=2; i<clientCnt+2; i++) {
			
			// 방문하지 않은 경우
			if(!visited[i]) {
				visited[i] = true;
				int diff = Math.abs(dist[node][0]-dist[i][0])+Math.abs(dist[node][1]-dist[i][1]);
				solve(i,distance+diff,cnt+1);
				visited[i] = false;
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
			
			// 고객 수 입력
			clientCnt = Integer.parseInt(br.readLine());
			
			// 거리 배열 생성
			dist = new int[clientCnt+2][2];
			
			// 거리 배열 정보 입력
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<clientCnt+2; i++) {
				dist[i][0] = Integer.parseInt(st.nextToken());
				dist[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 최단 경로 확인
			visited = new boolean[clientCnt+2];
			result = (int)1e9;
			
			solve(0,0,0);
			
			// 결과 저장
			sb.append("#").append(caseIdx+1).append(" ").append(result).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}
}