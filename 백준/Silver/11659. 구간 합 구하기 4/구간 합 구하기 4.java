import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		// 숫자 개수 입력
		int numCnt = Integer.parseInt(st.nextToken());
		
		// 구할 횟수 입력
		int resCnt = Integer.parseInt(st.nextToken());
		
		// 숫자 정보 입력
		int nums[] = new int[numCnt+1];
		int prefixSum[] = new int[numCnt+1];
		
		st = new StringTokenizer(br.readLine());
		for(int n=1; n<=numCnt; n++) {
			
			// 일반 숫자 정보 저장
			nums[n] = Integer.parseInt(st.nextToken());
			
			// 누적합 정보 저장
			prefixSum[n] = prefixSum[n-1]+nums[n];
		}
		
		// 구할 구간 정보 입력
		int res = 0;
		for(int p=0; p<resCnt; p++) {
			st = new StringTokenizer(br.readLine());
			
			// 시작 구간
			int start = Integer.parseInt(st.nextToken());
			
			// 종료 구간
			int end = Integer.parseInt(st.nextToken());
			
			// 구간 합 구하기
			res = prefixSum[end]-prefixSum[start]+nums[start];
			
			// 결과 저장
			sb.append(res).append("\n");
		}
		
		// 결과 출력
		System.out.println(sb.toString());
		
	}
}