import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

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
			
			// 스택 선언, 생성 및 할당
			Stack<Integer>stack = new Stack<>();
			
			// 우선 순위 표시 플래그
			boolean flag = false;
			
			// 계산식 입력
			String line = br.readLine();
			
			// 계산식 정보 입력
			for(int s=0; s<line.length(); s++) {
				
				// 해당 자리 문자 저장
				char letter = line.charAt(s);
				
				// 연산자인 경우
				if(letter=='+' || letter=='*') {
					
					// *인 경우
					if(letter=='*') 
						
						// 우선 순위 적용
						flag = true;
				}
				
				// 피연산자인 경우
				else {
					
					// 우선 순위가 적용된 경우
					if(flag) {
						
						// 숫자 꺼내서 * 연산 수행 후 스택 삽입
						int num = (letter-'0') * stack.pop();
						stack.push(num);
						
						// 우선 순위 적용 해제
						flag = false;
					}
					
					
					// 아닌 경우
					else {
						
						// 숫자 스택 삽입
						stack.push(letter-'0');
					}
				}
			}
			
			// 스택 원소 전부 더하기
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			// 결과 저장
			sb.append("#").append(caseIdx+1).append(" ").append(sum).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}