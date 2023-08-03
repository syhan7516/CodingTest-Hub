import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 재료의 개수
	public static int ingredientCnt;
	// 결과
	public static long result;
	// 재료 맛 정도 배열
	public static int taste[][];
	// 재료 방문 여부 배열
	public static boolean v[];
	
	// 요리하기 메서드
	static void solve(int cnt, long sour, long bitter, int selectCnt) {
		
		// 종료 조건 : 재료를 다 골랐을 경우
		if(cnt==ingredientCnt) {
			
			// 재료가 하나도 없는 경우
			if(selectCnt==0) return;
			
			// 아닌 경우
			result = Math.min(result, Math.abs(bitter-sour));
			return;
		}
		
		// 재료 고르기
		solve(cnt+1, sour*taste[cnt][0], bitter+taste[cnt][1], selectCnt+1);
		solve(cnt+1, sour, bitter, selectCnt);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 재료의 개수 입력
		ingredientCnt = Integer.parseInt(br.readLine());
		
		// 재료 맛 정도 배열
		taste = new int[ingredientCnt][2];
		
		// 재료 정보 입력
		for(int i=0; i<ingredientCnt; i++) {		
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 요리하기
		result = Long.MAX_VALUE;
		solve(0,1,0,0);
		
		// 결과 출력
		System.out.println(result);
	}
}