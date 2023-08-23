import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	// 집의 개수, 공유기 개수, 결과
	public static int homeCnt, pointCnt, result;
	// 집 위치 배열
	public static int locate[];
	// 좌표 범위
	public static int left, right;
	
	// 공유기 설치하기 메서드
	static void solve() {
		
		// 좌표 정렬
		Arrays.sort(locate);
		
		// 좌표 범위 초기 설정
		int left = 1;
		int right = locate[locate.length-1]-locate[0];
		
		// 설치 시도
		while(left<=right) {
			
			// 간격 설정
			int mid = (left+right)/2;
			
			// 설치한 공유기 개수
			int curPointCnt = 1;
			
			// 이전의 공유기 위치
			int prePoint = locate[0];
			
			// 간격마다 공유기 설치하기
			for(int p=1; p<homeCnt; p++) {
			
				// 집의 간격이 설정한 간격과 같거나 큰 경우
				if((locate[p]-prePoint)>=mid) {
					// 공유기 설치
					curPointCnt++;
					// 이전 공유기 위치 갱신
					prePoint = locate[p];
				}
			}
			
			// 공유기 설치가 덜된 경우
			if(curPointCnt<pointCnt) {
				right = mid-1;
			}
			
			// 공유기 설치가 많거나 동일하게 설치한 경우
			else {
				result = mid;
				left = mid+1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 집의 개수, 공유기 개수 입력
		st = new StringTokenizer(br.readLine());
		homeCnt = Integer.parseInt(st.nextToken());
		pointCnt = Integer.parseInt(st.nextToken());
		
		// 집 위치 배열 생성
		locate = new int[homeCnt];
		
		// 집 위치 정보 입력
		for(int i=0; i<homeCnt; i++) {
			locate[i] = Integer.parseInt(br.readLine());
		}
		
		// 공유기 설치하기
		solve();
		
		// 결과 출력
		System.out.println(result);
	}
}