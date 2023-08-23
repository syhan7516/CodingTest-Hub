import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 간선 클래스
class Edge implements Comparable<Edge> {
	int start;
	int end;
	int value;
	
	public Edge(int start, int end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}
	
	public int compareTo(Edge other) {
		return this.value-other.value;
	}
}

public class Main {
	
	// 정점 개수, 간선 개수, 결과
	public static int v,e;
	public static long result;
	// 간선 가중치 정렬을 위한 우선 순위 큐
	public static PriorityQueue<Edge> priQ;
	// 대표 번호 배열 
	public static int parents[];
	
	// find
	static int find(int a) {
		
		// 자기 자신과 동일한 경우
		if(parents[a]==a) return a;
		
		// 아닐 경우
		return parents[a] = find(parents[a]);
	}
	
	// union
	static void union(int a, int b) {
		
		// 각각 대표 번호 찾기
		a = find(a);
		b = find(b);
		
		// 집합 합치기
		parents[b] = a;
	}
	
	// MST 구하기 메서드
	static void solve() {
		
		// 대표 번호 배열 생성
		parents = new int[v+1];
		
		// 대표 번호 배열 초기화
		for(int i=1; i<=v; i++)
			parents[i] = i;
		
		// 현재 연결된 간선 수
		int cnt = 0;
	
		// 간선 확인하기
		while(!priQ.isEmpty()) {
			
			// 간선 연결이 완료된 경우
			if(cnt==v-1) break;
			
			// 확인할 간선
			Edge curEdge = priQ.poll();
			
			// 싸이클 확인
			if(find(curEdge.start)==find(curEdge.end)) continue;
			
			// 간선 합치기
			union(curEdge.start,curEdge.end);
			
			// 정점 개수 추가
			cnt++;
			
			// 비용 추가
			result += curEdge.value;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        // 정점 개수, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        priQ = new PriorityQueue<>();

        // 간선 정보 입력
        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            priQ.offer(new Edge(from,to,value));
        }

        // MST 구하기
        result = 0;
        solve();
		
		// 결과 출력
		System.out.println(result);
	}
}