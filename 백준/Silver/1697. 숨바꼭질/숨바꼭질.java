import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 수빈이의 위치와 동생 위치
	public static int subin, sister;
	// 영역 배열
	public static int area[];
	
	// 동생 찾기 메서드
	static void solve() {

		// 탐색 노드 저장 큐
		Queue<Integer> queue = new LinkedList<>();
		
		// 수빈이 시작점 처리
		queue.offer(subin);
		area[subin] = 1;
		
		// 찾을 때까지 반복
		while(!queue.isEmpty()) {
			
			// 현재 위치
			int current = queue.poll();
			
			// 동생을 찾은 경우
			if(current==sister) return;
			
			// 이동 가능한 위치
			int p[] = {current-1,current+1,current*2};
			
			// 진행 방향
			for(int i=0; i<3; i++) {
				
				// 범위 확인
				if(p[i]<0 || p[i]>100000) continue;
				
				// 이미 방문한 경우
				if(area[p[i]]>0) continue;
				
				// 그 외의 경우
				area[p[i]] = area[current]+1;
				
				// 탐색 큐에 저장
				queue.offer(p[i]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수빈이의 위치와 동생 위치 입력
		st = new StringTokenizer(br.readLine());
		subin = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());
		
		// 영역 배열 생성
		area = new int[100001];
		
		// 동생 찾기
		solve();
		
		// 결과 출력
		System.out.println(area[sister]-1);
	}
}