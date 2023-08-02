import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 입력
		int caseNum = Integer.parseInt(br.readLine());
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
			// 농장의 크기 입력
			int farmSize = Integer.parseInt(br.readLine());
			
			// 농장 만들기
			int farm[][] = new int[farmSize][farmSize];
			
			// 농장 정보 입력
			for(int i=0; i<farmSize; i++) {
				String line = br.readLine();
				for(int j=0; j<farmSize; j++) {
					farm[i][j] = line.charAt(j)-'0';
				}
			}
			
			
			// 크기가 1인 경우
			if(farmSize==1)
				// 결과 저장
				sb.append("#").append(caseIdx+1).append(" ").append(farm[0][0]).append("\n");
			
			// 크기가 2이상인 경우
			else {
				
				// 초기 셋팅
				int dist = 1;
				int start = farmSize/2;
				int end = farmSize/2;
				int valueSum = farm[0][start]+farm[farmSize-1][end];
				int depth = 1;
				
				// 수익 얻기
				while(true) {
					
					// 범위 지정
					start -= dist;
					end += dist;
					
					// 종료 조건
					if(start==0 || end==farmSize-1) break;
					
					// 수확 진행
					for(int i=start; i<=end; i++) {
						valueSum += farm[depth][i];
						valueSum += farm[farmSize-1-depth][i];
					}
					
					// 깊이 증가
					depth++;
				}
				
				// 중간 수확 진행
				for(int i=0; i<farmSize; i++) 
					valueSum += farm[farmSize/2][i];
				
				// 결과 저장
				sb.append("#").append(caseIdx+1).append(" ").append(valueSum).append("\n");
			}
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}