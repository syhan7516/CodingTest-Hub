import java.util.Scanner;

public class Main {
	
	// 전체 숫자 개수, 선택할 수의 개수
	public static int totalCnt, selectCnt;
	// 선택 확인 배열
	public static boolean v[];
	
	// 숫자 선택하기 메서드
	static void solve(int depth, String res) {
		
		// 종료 조건
		if(depth==selectCnt) {
			System.out.println(res);
			return;
		}
		
		// 서치
		for(int n=1; n<=totalCnt; n++) {
			
			// 이미 선택된 경우
			if(v[n]) continue;
			
			// 아닌 경우
			v[n] = true;
			solve(depth+1,res+n+" ");
			v[n] = false;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 전체 숫자 개수 입력
		totalCnt = sc.nextInt();
		
		// 선택할 수의 개수 입력
		selectCnt = sc.nextInt();
		
		// 선택 확인 배열, 결과 배열 생성
		v = new boolean[totalCnt+1];
		
		// 숫자 선택하기
		for(int n=1; n<=totalCnt; n++) {
			
			v[n] = true;
			solve(1,n+" ");
			v[n] = false;
		}
	}
}