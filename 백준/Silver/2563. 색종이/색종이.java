import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 색종이 수 입력
		int paperCnt = Integer.parseInt(br.readLine());
		
		// 도화지 만들기
		int BigPaper[][] = new int[101][101];
		
		// 결과
		int sum = 0;
		
		// 색종이 정보 입력
		for(int i=0; i<paperCnt; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			// 좌표 입력
			int start = 100-Integer.parseInt(st.nextToken())-10;
			int end = Integer.parseInt(st.nextToken());
			
			// 탐색 마지막 범위 설정
			int startEnd = start+10;
			int endEnd = end+10;
			
			// 종이 붙이기
			for(int j=start; j<startEnd; j++) {
				for(int k=end; k<endEnd; k++) {
					
					// 0인 경우 갱신
					if(BigPaper[j][k]==0) {
						BigPaper[j][k] = 1;
						sum++;
					} 
				}
			}
		}
		
		// 결과 출력
		System.out.println(sum);
	}
}