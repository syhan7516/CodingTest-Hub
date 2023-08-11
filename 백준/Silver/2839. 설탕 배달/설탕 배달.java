import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	// 무게 최대 값 
	public static final int MAX = (int)1e9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배달 무게 입력
		int target = Integer.parseInt(br.readLine());
		
		// 무게 DP 배열
		int DP[] = new int[6000];
		
		// 최대 값 채우기
		Arrays.fill(DP, MAX);
		
		// 기본 셋팅
		DP[3] = 1;
		DP[5] = 1;
		
		// 배달하기
		for(int i=3; i<=target; i++) {
			
			// 무게가 존재하는 경우
			if(DP[i]!=MAX) {
				DP[i+3] = Math.min(DP[i+3],DP[i]+1);
				DP[i+5] = Math.min(DP[i+5],DP[i]+1);
			}
		}
		
		// 결과 출력
		if(DP[target]==MAX) System.out.println(-1);
		else System.out.println(DP[target]);
	}
}