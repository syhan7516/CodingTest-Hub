import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 입력
		int caseNum = 10;
		
		// 케이스 수 만큼 수행
		for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
			
			// 정점의 수 입력
			int nodeCnt = Integer.parseInt(br.readLine());
			
			// 유효성 여부
			boolean flag = true;
				
			// 사칙 연산 정보 입력
			for(int i=0; i<nodeCnt; i++) {

				st = new StringTokenizer(br.readLine());
				
				// 이미 결과가 나왔더라도 끝까지 읽기
				if(!flag) continue;
				
				// 순서 입력
				st.nextToken();
				
				// 연산자 입력
				String operator = st.nextToken();
				
				// 연산자인 경우
				if(operator.equals("*") || operator.equals("-") || operator.equals("+") || operator.equals("/")) {
					
					if(st.countTokens()!=2) 
						flag = false;
					
				}
				
				// 연산자가 아닌 경우
				else {
					if(st.countTokens()!=0)
						flag = false;
				}
			}
			
			// 결과 저장
			sb.append("#").append(caseIdx+1).append(" ");
			if(flag) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}