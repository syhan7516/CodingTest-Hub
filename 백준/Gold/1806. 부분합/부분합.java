import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 수열의 길이, 목표 값
	public static int arrLen, target;
	// 수열 배열
	public static int arr[];
	// 결과
	public static int result;
	
	// 부분합 구하기 메서드
	static void solve() {
		
		// 포인터 설정
		int point = 0;
		// 누적합
		int prefixSum = 0;
		
		// 부분합 구하기
		for(int start=0; start<arrLen; start++) {
			
			// 부분 수열의 합 구하기
			while(prefixSum<target && point<arrLen) {
				
				// 다음 요소 더하기
				prefixSum += arr[point];
				
				// 포인터 갱신
				point++;
			}
			
			// 목표한 값과 같은 경우
			if(prefixSum>=target) {
				result = Math.min(result,point-start);
			}
			
			// 시작 포인터 구간의 값 빼기
			prefixSum -= arr[start];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 수열의 길이, 목표 값 입력
		st = new StringTokenizer(br.readLine());
		arrLen = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		// 수열 배열 생성
		arr = new int[arrLen];
		
		// 수열 배열 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<arrLen; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 부분합 구하기
		result = 100000;
		solve();
		
		// 결과 출력
		if(result==100000) System.out.println(0);
		else System.out.println(result);
	}
}