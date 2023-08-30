import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 미로 크기 입력
		st = new StringTokenizer(br.readLine());
		int rowSize = Integer.parseInt(st.nextToken());
		int colSize = Integer.parseInt(st.nextToken());
		
		// 미로 생성
		int maze[][] = new int[rowSize+1][colSize+1];
		
		// 줍기 가능한 선물 개수 배열 생성
		int DP[][] = new int[rowSize+1][colSize+1];
		
		// 미로 정보 입력
		for(int i=1; i<=rowSize; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=colSize; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 미로 탐색
		for(int i=1; i<=rowSize; i++) {
			for(int j=1; j<=colSize; j++) {
				DP[i][j] = Math.max(DP[i-1][j-1], Math.max(DP[i-1][j],DP[i][j-1])) + maze[i][j];
			}
		}
		
		// 결과 출력
		System.out.println(DP[rowSize][colSize]);
	}
}