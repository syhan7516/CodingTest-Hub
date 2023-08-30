import java.util.Scanner;

public class Main {
	
	// 조합 배열
	public static int DP[][];
	
	// 조합 구하기 메서드
	static int solve(int n, int c) {
		
		// 1인 부분인 경우
		if(n==c || c==0) return 1;

		// 이미 구한 경우
		if(DP[n][c]!=0) return DP[n][c];
		
		// 구하지 못했던 경우
		return DP[n][c] = solve(n-1,c-1) + solve(n-1,c);
	}
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 수 입력
		int caseNum = sc.nextInt();
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
			// 동쪽, 서쪽 사이트 수 입력
			int west = sc.nextInt();
			int east = sc.nextInt();
			
			// 조합 배열 생성
			DP = new int[east+1][west+1];
			
			// 조합 구하기
			int result = solve(east,west);			
			
			// 결과 저장
			sb.append(result).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}