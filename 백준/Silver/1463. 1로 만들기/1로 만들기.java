import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 숫자 입력
		int number = sc.nextInt();
		
		// 연산 횟수 저장 배열 생성
		int DP[] = new int[number+1];
		
		// 초기 셋팅	
		Arrays.fill(DP,(int)1e9);
		DP[1] = 0;
		
		// 연산 수행
		for(int i=1; i<=number; i++) {
			
			// 연산 방법
			int operator[] = {i+1,i*2,i*3};
			
			// 확인
			for(int j=0; j<3; j++) {
				
				// 범위 확인
				if(operator[j]<=number)
					DP[operator[j]] = Math.min(DP[operator[j]],DP[i]+1);
			}
		}
		
		// 결과 출력
		System.out.println(DP[number]);
	}
}