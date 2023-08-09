import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 연산의 개수 입력
		int operationCnt = sc.nextInt();
		
		// 우선 순위 큐 만들기
		PriorityQueue<Integer> priQ = new PriorityQueue<>((o1,o2) -> {
            
            // 절대값 비교
			if(Math.abs(o1)<Math.abs(o2))
				return -1;
            
            // 절대값이 같은 경우
			else if(Math.abs(o1)==Math.abs(o2))
				return o1-o2;
            
			return 1;
		});
		
		// 연산 수행
		for(int i=0; i<operationCnt; i++) {
			
			int order = sc.nextInt();
			
			// 명렁이 0인 경우
			if(order==0) {
				
                // 비었다면 0 출력
				if(priQ.isEmpty()) System.out.println(0);
				
				else {
					
					// 만약 절대값이 같은 경우
					System.out.println(priQ.poll());
				}
			}
			
			// 아닌 경우
			else {
				priQ.offer(order);
			}
		}
	}
}