import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 저장
		int caseNum = 10;
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
			// 계산식의 길이 입력
			int calLen = Integer.parseInt(br.readLine());
			
			// 연산의 합 
			int sum = 0;
			
			// 계산식 입력
			String line = br.readLine();
			
			// 계산식 정보 입력
			for(int s=0; s<line.length(); s++) {
				
				// 홀수 자리인 경우
				if(s%2==0) {
					sum += line.charAt(s)-'0';
				}
			}
			
			// 결과 저장
			sb.append("#").append(caseIdx+1).append(" ").append(sum).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}