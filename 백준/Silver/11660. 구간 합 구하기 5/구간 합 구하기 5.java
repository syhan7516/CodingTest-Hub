import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		// 표의 크기 입력
		int boardSize = Integer.parseInt(st.nextToken());
		
		// 구할 횟수 입력
		int resCnt = Integer.parseInt(st.nextToken());
		
		// 보드 생성
		int board[][] = new int[boardSize+1][boardSize+1];
		
		// 누접합 보드 생성
		int prefixSumBoard[][] = new int[boardSize+1][boardSize+1];
		
		// 보드 정보 입력
		for(int i=1; i<=boardSize; i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j=1; j<=boardSize; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				prefixSumBoard[i][j] = prefixSumBoard[i-1][j] + board[i][j];
			}
		}
		
		// 합을 구할 구간 입력
		for(int i=0; i<resCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 좌표 입력
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 좌표가 같을 경우
			if(x1==x2 && y1==y2)
				// 결과 저장
				sb.append(board[x1][y1]).append("\n");
			
			// 좌표가 다를 경우
			else {
				
				// 필요한 구간의 합
				int BigAreaSum = 0;
				
				// 넓은 구간에서 불필요한 구간 빼기
				for(int j=y1; j<=y2; j++) {
					BigAreaSum+=prefixSumBoard[x2][j]-prefixSumBoard[x1-1][j];
				}	
				
				// 결과 저장
				sb.append(BigAreaSum).append("\n");
			}
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}