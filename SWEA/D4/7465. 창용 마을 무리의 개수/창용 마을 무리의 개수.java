import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	// 집합 개수, 연산 개수, 대상
	public static int cnt, operationCnt, firNum, secNum;
	// 대표 번호 배열
	public static int parents[];
	// 집합 셋
	public static HashSet<Integer> set;
	
	// union
	static void union(int a, int b) {
		
		// 각 집합이 속한 곳 가져오기
		a = find(a);
		b = find(b);
		
		// 집합 합치기
		parents[b] = a;
	}
	
	// find
	static int find(int a) {
		
		// 대표 번호가 자기 자신일 경우
		if(parents[a]==a) return a;
		
		// 아닐 경우
		return parents[a] = find(parents[a]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 입력
		int caseNum = Integer.parseInt(br.readLine());
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
			// 집합 셋 생성
			set = new HashSet<>();
			
			// 집합 개수, 연산 개수 입력
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			operationCnt = Integer.parseInt(st.nextToken());
			
			// 대표 번호 배열 생성, 초기화
			parents = new int[cnt+1];
			for(int i=1; i<=cnt; i++)
				parents[i] = i;
			
			int firNum = 0;
			int secNum = 0;
			
			for(int i=0; i<operationCnt; i++) {
				
				// 연산 정보 입력
				st = new StringTokenizer(br.readLine());
				firNum = Integer.parseInt(st.nextToken());
				secNum = Integer.parseInt(st.nextToken());
				
				// union
				union(firNum,secNum);
			}
			
			// 집합 확인
			for(int i=1; i<=cnt; i++) {
				set.add(find(i));
			}
			
			// 결과 저장
			sb.append("#").append(caseIdx+1).append(" ").append(set.size()).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}