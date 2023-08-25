import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 노드 클래스
class Node implements Comparable<Node> {
	int node;
	int value;
	
	public Node(int to, int value) {
		this.node = to;
		this.value = value;
	}
	
	public int compareTo(Node other) {
		return this.value-other.value;
	}
}

public class Main {
	
	// 상수 설정
	public static final int INF = (int)1e9;
	// 정점의 개수, 간선의 개수, 시작점
	public static int v,e,start;
	// 그래프 리스트
	public static ArrayList<ArrayList<Node>> graph;
	// 최단 거리 배열
	public static int path[];
    // 방문 여부 배열
    public static boolean visited[];
	
	// 최단 거리 구하기 메서드
	static void dijkstra() {
		
		// 최단 간선 정렬을 위한 우선 순위 큐 생성
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		
        // 방문 여부 배열 생성
        visited = new boolean[v+1];
        
		// 시작점 처리
		path[start] = 0;
		pQueue.offer(new Node(start,path[start]));
		
		// 큐가 빌 때까지 반복 수행
		while(!pQueue.isEmpty()) {
			
			// 확인 할 노드
			Node curNode = pQueue.poll();
            
            // 이미 방문한 경우
			if(visited[curNode.node]) continue;
            
			// 해당 노드와 인접한 노드 확인
			for(int i=0; i<graph.get(curNode.node).size(); i++) {
				
				// 연결  노드, 연결 정점, 연결 가중치
				Node connectNode = graph.get(curNode.node).get(i);
				
				// 최단 경로 배열 갱신
				if(path[connectNode.node]>curNode.value+connectNode.value) {
					path[connectNode.node] = curNode.value+connectNode.value;
				}	
				
				// 큐에 저장
				pQueue.offer(new Node(connectNode.node,path[connectNode.node]));
			}
            
            // 방문 처리
            visited[curNode.node] = true;
		}		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 정점, 간선 개수 입력
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		// 시작점 입력
		start = Integer.parseInt(br.readLine());
		
		// 그래프 리스트 생성
		graph = new ArrayList<>();
		
		// 그래프 초기화
		for(int i=0; i<=v; i++)
			graph.add(new ArrayList<>());
		
		// 최단 경로 배열 초기화
		path = new int[v+1];
		Arrays.fill(path,INF);
		
		// 간선 정보 입력
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to,value));
		}
		
		// 최단 거리 구하기
		dijkstra();
		 
		// 결과 출력
		for(int i=1; i<=v; i++) {
			if(path[i]==INF) System.out.println("INF");
			else System.out.println(path[i]);
		}
	}
}