import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 집의 수, 결과
	public static int homeCnt, result;
	
	// 색깔 비용 배열
	public static int color[][];
	
	// 집에 대한 색깔 비용 배열
	public static int DP[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 집의 수 입력
		homeCnt = Integer.parseInt(br.readLine());
		
		// 색깔 비용 배열 생성
		color = new int[homeCnt+1][4];
		
		// 색깔 비용 입력
		for(int i=1; i<=homeCnt; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 집에 대한 색깔 비용 배열
		DP = new int[homeCnt+1][4];
		
		// 첫 집 색칠하기
		DP[1][1] = color[1][1];
		DP[1][2] = color[1][2];
		DP[1][3] = color[1][3];
		
		// 집 색칠하기
		for(int i=2; i<=homeCnt; i++) {
			
			// 빨간색으로 색칠하기
			DP[i][1] = Math.min(color[i][1]+DP[i-1][2],color[i][1]+DP[i-1][3]);
			
			// 초록색으로 색칠하기
			DP[i][2] = Math.min(color[i][2]+DP[i-1][1],color[i][2]+DP[i-1][3]);
			
			// 파란색으로 색칠하기
			DP[i][3] = Math.min(color[i][3]+DP[i-1][1],color[i][3]+DP[i-1][2]);
		}
		
		// 최소 비용 결과 저장
		result = Math.min(DP[homeCnt][1],Math.min(DP[homeCnt][2],DP[homeCnt][3]));
		
		// 결과 출력
		System.out.println(result);
	}
}