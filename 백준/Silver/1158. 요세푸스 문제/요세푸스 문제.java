import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 사람 수 입력
		int humanCnt = Integer.parseInt(st.nextToken());
		
		// 텀 입력
		int term = Integer.parseInt(st.nextToken());
		
		// 큐 
		Queue<Integer> queue = new LinkedList();
		
		// 큐에 번호 삽입
		for(int i=1; i<=humanCnt; i++)
			queue.offer(i);
		
		// 결과 
		sb.append("<");
		
		// 사람 제거하기
		int cnt = 1;
		while(queue.size()>1) {
			
			// 만약 텀이 된 경우
			if(cnt==term) {
				int human = queue.poll();
				sb.append(human).append(", ");
				cnt = 1;
			}
			
			// 아닌 경우
			else {
				queue.offer(queue.poll());
				cnt++;
			}
		}
		
		// 결과 저장
		sb.append(queue.poll()).append(">");
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}