import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 학생 수, 비교 회수
	public static int studentCnt, compareCnt;
	// 관계 리스트 
	public static ArrayList<ArrayList<Integer>> relation;
	// 들어오는 간선 수 배열
	public static int inDegree[];
	// 결과 저장을 위한 빌더
	public static StringBuilder sb;
	
	// 줄 세우기 메서드
	static void solve() {
		
		// 정렬을 위한 큐 생성
		Queue<Integer> queue = new LinkedList<>();
				
		// 시작점 찾기
		for(int i=1; i<=studentCnt; i++) {
			if(inDegree[i]==0) {
				queue.offer(i);
				sb.append(i).append(" ");
			}
		}
		
		// 큐가 빌 때까지 수행
		while(!queue.isEmpty()) {
			
			// 현재 확인 노드
			int current = queue.poll();
			
			// 연결 관계 확인
			for(int i=0; i<relation.get(current).size(); i++) {
				int node = relation.get(current).get(i);
				inDegree[node]--;
				
				// 진입 차수가 0이 되는 경우
				if(inDegree[node]==0) {
					queue.offer(node);
					sb.append(node).append(" ");
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 학생 수, 비교 회수 입력
		st = new StringTokenizer(br.readLine());
		studentCnt = Integer.parseInt(st.nextToken());
		compareCnt = Integer.parseInt(st.nextToken());
		
		// 관계 리스트 생성
		relation = new ArrayList<>();
		
		// 관계 리스트 셋팅
		for(int i=0; i<=studentCnt; i++) {
			relation.add(new ArrayList<>());
		}
		
		// 들어오는 간선 수 배열 생성
		inDegree = new int[studentCnt+1];
		
		// 비교 정보 입력
		for(int i=0; i<compareCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			relation.get(from).add(to);
			inDegree[to]++;
		}
		
		// 줄 세우기 수행
		sb = new StringBuilder();
		solve();
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}