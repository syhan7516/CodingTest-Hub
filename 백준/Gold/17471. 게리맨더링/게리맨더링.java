import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 구역 개수, 전체 인구 수, 결과
	public static int areaCnt, totalCnt, result;
	// 구역 인구 수 배열
	public static int population[];
	// 구역 연결 관계 리스트
	public static ArrayList<ArrayList<Integer>> relation;
	// 부분 집합 결과 배열
	public static int powerSetRes[];
	
	// 연결 확인 메서드
	static boolean isConnect(ArrayList<Integer> areaList) {
		
		// 연결 확인 큐
		Queue<Integer> queue = new LinkedList<>();
		
		// 도시 방문 여부 배열
		boolean visited[] = new boolean[areaCnt+1];
		
		// 시작점 처리
		visited[areaList.get(0)] = true;
		queue.offer(areaList.get(0));
		
		// 도시 확인 수 
		int curCnt = 1;
		
		while(!queue.isEmpty()) {
			
			// 현재 도시
			int city = queue.poll();
			
			// 현재 도시와 연결되었는지 확인
			for(int i=0; i<relation.get(city).size(); i++) {
				
				// 현재 집합과 원래 연결 관계와 비교
				int comCity = relation.get(city).get(i);
				
				// 부분 집합 결과 리스트에 포함되면서 방문하지 않았을 경우
				if(areaList.contains(comCity) && !visited[comCity]) {
					visited[comCity] = true;
					queue.offer(comCity);
					curCnt++;
				}
			}
		}
		
		// 확인 결과 확인
		if(curCnt!=areaList.size()) return false;
		
		return true;
	}
	
	// 구역을 부분 집합으로 나누기 메서드
	static void powerSet(int idx, int depth, int inclusion) {
		
		// 다 확인한 경우
		if(depth==areaCnt) {
			
			// 부분 집합 개수 확인
			if(inclusion==0 || inclusion==areaCnt) return;
			
			// 두 구역 개수 파악		
			ArrayList<Integer> areaA = new ArrayList<>();
			ArrayList<Integer> areaB = new ArrayList<>();
			
			for(int i=1; i<=areaCnt; i++) {
				if(powerSetRes[i]==-1)
					areaA.add(i);
				else if(powerSetRes[i]==1)
					areaB.add(i);
			}

			// 두 구역 도시 수 확인
			if((areaA.size()+areaB.size())!=areaCnt) return;
			
			// 연결 확인
			if(isConnect(areaA) && isConnect(areaB)) {
				
				// 인구 수 차이 구하기
				int a = 0;
				int b = 0;
				
				// 인구 수 비교
				for(int i=0; i<areaA.size(); i++) {
					a += population[areaA.get(i)];
				}
				
				b = totalCnt-a;
				
				// 최소 인구 수 갱신
				result = Math.min(result,Math.abs(a-b));
			}
		}
		
		// 확인이 더 된 경우
		for(int i=idx; i<=areaCnt; i++) {
			powerSetRes[i] = -1;
			powerSet(i+1,depth+1,inclusion);
			powerSetRes[i] = 1;
			powerSet(i+1,depth+1,inclusion+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 구역 개수 입력
		areaCnt = Integer.parseInt(br.readLine());
		
		// 구역 인구 수 배열 생성
		population = new int[areaCnt+1];
		
		// 구역 인구 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=areaCnt; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			totalCnt += population[i];
		}
		
		// 구역 연결 관계 리스트 생성
		relation = new ArrayList<>();
		
		// 연결 관계 리스트 초기화
		for(int i=0; i<=areaCnt; i++)
			relation.add(new ArrayList<>());
		
		// 연결 관계 정보 입력
		for(int i=1; i<=areaCnt; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 관계 개수 입력
			int relCnt = Integer.parseInt(st.nextToken());
			
			// 관계 입력
			for(int j=0; j<relCnt; j++) {
				relation.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 구역을 부분 조합으로 나누기
		result = 1001;
		powerSetRes = new int[areaCnt+1];
		powerSet(1,0,0);
		
		// 결과 출력
		if(result==1001) System.out.println(-1);
		else System.out.println(result);
	}
}