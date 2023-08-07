import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 타워 클래스
class Tower {
	private int height;
	private int point;
	
	public Tower(int height, int point) {
		this.height = height;
		this.point = point;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getPoint() {
		return this.point;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 탑의 개수
		int towerCnt = Integer.parseInt(br.readLine());
		
		// 탑 송신 확인을 위한 스택 선언, 생성 및 할당
		Stack<Tower> stack = new Stack<>();
		
		// 송신 결과 저장 배열
		int result[] = new int[towerCnt];
		
		// 탑 정보 저장
		st = new StringTokenizer(br.readLine());
		
		// 첫 타워 정보 삽입
		int towerHeight = Integer.parseInt(st.nextToken());
		stack.push(new Tower(towerHeight,1));

		// 나머지 타워 확인
		for(int t=2; t<=towerCnt; t++) {
			towerHeight = Integer.parseInt(st.nextToken());
			
			// 기존 타워 확인
			while(true) {
				
				// 스택이 비었을 경우
				if(stack.isEmpty()) {
					stack.push(new Tower(towerHeight,t));
					result[t-1] = 0;
					break;
				}
				
				// 아닌 경우
				else {
					
					// 비교 대상
					Tower curTower = stack.peek();
					
					// 스택의 위의 값보다 작을 경우
					if(towerHeight<curTower.getHeight()) {
						result[t-1] = curTower.getPoint();
						stack.push(new Tower(towerHeight,t));
						break;
					}
					
					// 아닌 경우
					else {
						stack.pop();
					}
				}
			}
		}
		
		// 결과 출력
		for(int element: result)
			System.out.print(element+" ");
	}
}