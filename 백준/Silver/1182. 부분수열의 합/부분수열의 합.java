import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 수열의 크기, 목표 합, 결과
	public static int numSize, target, result;
	// 수열 배열
	public static int nums[];
	
	// 부분 수열 합 구하기 메서드
	static void solve(int cnt, int sum, int curCnt) {
		
		// 종료 조건
		if(cnt==numSize) {
			
			// 합이 원하는 합과 맞을 경우
			if(curCnt>0 && sum==target) 
				result++;
			
			return;
		}
	
		// 부분 수열 포함 여부 적용
		solve(cnt+1,sum,curCnt);
		solve(cnt+1,sum+nums[cnt],curCnt+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 수열의 크기, 목표 값 입력
		st = new StringTokenizer(br.readLine());
		numSize = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		// 수열 만들기
		nums = new int[numSize];
		
		// 수열 정보 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<numSize; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 부분 수열 합 구하기 
		result = 0;
		solve(0,0,0);
		
		// 결과 출력
		System.out.println(result);
	}
}
