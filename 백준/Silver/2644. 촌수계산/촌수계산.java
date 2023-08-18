import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	// 사람 수, 두 사람, 관계 수, 결과
	public static int saramCnt, first, second, relationCnt, result;
	// 조직도 리스트
	public static ArrayList<ArrayList<Integer>> relation;
	// 조직도 방문 여부 배열
	public static boolean visited[];
	// 계산 성공 여부
	public static boolean flag;

	// 촌수 계산하기 메서드
	static void solve(int num, int cnt) {
		
		// 촌수를 찾은 경우
		if(num==second) {
			result = cnt;
			flag = true;
			return;
		}
		
		// 현재 사람 관계 크기
		int currentSize = relation.get(num).size();
		
		// 현재 사람 관계 확인
		for(int i=0; i<currentSize; i++) {
			
			// 상대 확인
			int connect = relation.get(num).get(i);
			
			// 촌수 계산이 안된 사람인 경우
			if(!visited[connect]) {
				visited[connect] = true;
				solve(connect,cnt+1);
			}
			
			// 탐색이 종료된 경우
			if(flag) return;
		}
	} 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 사람 수 입력
		saramCnt = Integer.parseInt(br.readLine());
		
		// 두 사람 입력
		st = new StringTokenizer(br.readLine());
		first = Integer.parseInt(st.nextToken());
		second = Integer.parseInt(st.nextToken());
		
		// 관계 리스트 생성
		relation = new ArrayList<>();
		for(int r=0; r<=saramCnt; r++)
			relation.add(new ArrayList<>());
		
		// 관계 수 입력
		relationCnt = Integer.parseInt(br.readLine());
		
		// 관계 정보 입력
		for(int i=0; i<relationCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 양방향 저장
			relation.get(start).add(end);
			relation.get(end).add(start);
		}
		
		// 촌수 계산하기
		result = 0;
		visited = new boolean[saramCnt+1];
		solve(first,0);
		
		// 만약 관계가 없는 경우
		if(result==0) result = -1;
		
		// 결과 출력
		System.out.println(result);
	}
}