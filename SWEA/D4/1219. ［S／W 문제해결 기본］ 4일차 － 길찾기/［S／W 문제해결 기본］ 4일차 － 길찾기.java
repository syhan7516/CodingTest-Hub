import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	// 지도 
	public static ArrayList<ArrayList<Integer>> map;
	// 길 개수, 결과
	public static int loadCnt, result;
	// 방문 여부
	public static boolean visited[];
	// 도착 여부
	public static boolean flag;
	
	// 지도 탐색
	static void solve(int node) {
		
		// 연결된 경로 확인
		for(int n=0; n<map.get(node).size(); n++) {
			
			// 확인 노드
			int city = map.get(node).get(n);
			
			if(!visited[city]) {
				
				// 만약 도착점인 경우
				if(city==99) {
					flag = true;
					return;
				}
				
				// 방문 처리
				visited[city] = true;
				
				solve(city);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 입력
		int caseNum = 10;
		
		// 케이스 진행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			loadCnt = Integer.parseInt(st.nextToken());
			
			// 지도 생성
			map = new ArrayList(); 
			for(int n=0; n<100; n++) 
				map.add(new ArrayList());
			
			// 지도 정보 입력
			st = new StringTokenizer(br.readLine());
			for(int a=0; a<loadCnt; a++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map.get(start).add(end);
			}
			
			// 지도 탐색
			flag = false;
			result = 0;
			visited = new boolean[100];
			visited[0] = true;
			solve(0);
			
			// 결과 저장
			if(flag==true) result = 1;
			sb.append("#").append(caseIdx+1).append(" ").append(result).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}