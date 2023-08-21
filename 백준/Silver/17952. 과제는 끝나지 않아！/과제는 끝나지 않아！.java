import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 일에 대한 클래스
class Work {
	
	// 해당 업무 평가 점수, 걸리는 시간
	int score;
	int time;
	
	public Work(int score, int time) {
		this.score = score;
		this.time = time;
	}
}

public class Main {
	
	// 분기의 분에 대한 정보, 평가 점수
	public static int totalTime, totalScore;
	
	// 업무 정보 저장 스택
	public static Stack<Work> stack;
	
	public static void main(String[] args) throws Exception {
		
		// 입력을 위한 셋팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 업무 정보 저장 스택 생성
		stack = new Stack<>();
		
		// 분 정보 입력
		totalTime = Integer.parseInt(br.readLine());
		
		// 업무에 대한 초기 평가 점수, 시간 할당
		int s = 0;
		int t = 0;
		
		// 평가 점수를 저장 할 변수 생성
		totalScore = 0;
		
		// 분 단위 업무 정보 입력
		for(int i=0; i<totalTime; i++) {
			
			// 업무 여부 입력
			st = new StringTokenizer(br.readLine());
			int exist = Integer.parseInt(st.nextToken());
			
			// 업무가 존재하지 않은 경우
			if(exist==0) {
				
				// 기존 업무가 존재하는 경우 업무 진행
				if(t>0) t--;
					
				// 기존 업무가 존재하지 않은 경우
				else {
					
					// 스택에 이전 업무가 존재하면 꺼내오기
					if(!stack.isEmpty()) {
						Work current = stack.pop();
						
						// 꺼내온 업무 진행
						s = current.score;
						t = current.time;
						t--;
					}
				}
			}
			
			// 업무가 존재하는 경우
			else {
				
				// 점수, 걸리는 시간 입력
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				// 기존 업무가 존재하는 경우 스택에 업무 저장
				if(t>0) stack.push(new Work(s,t));
				
				// 추가 업무 할당 후 업무 진행
				s = score;
				t = time;
				t--;
			}
			
			// 현재 업무를 다 끝낸 경우
			if(t==0) {
				
				// 평가 점수 추가
				totalScore += s;
				// 점수 초기화
				s = 0;
			}
		}
		
		// 결과 출력
		System.out.println(totalScore);
	}
}
