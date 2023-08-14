import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	// 알파벳 개수, 암호 길이
	public static int alphaCnt, alphaLen;
	// 알파벳 종류 배열
	public static char alpha[];
	
	// 암호 만들기 메서드
	static void solve(int cnt, int idx, int gat, int con, String letter) {
		
		
		
		// 암호가 만들어진 경우
		if(cnt==alphaCnt) {
			
			// 최소 개수가 만족하는 경우
			if(con>1 && gat>0) sb.append(letter).append("\n");
			
			return;
		}
		
		// 아닌 경우
		for(int i=idx; i<alpha.length; i++) {
			
			// 확인 문자
			char curAlpha = alpha[i];
			
			// 모음
			if(curAlpha=='a' || curAlpha=='e' || curAlpha=='i' || curAlpha=='o' || curAlpha=='u')
				solve(cnt+1,i+1,gat+1,con,letter+alpha[i]);
			// 자음
			else 
				solve(cnt+1,i+1,gat,con+1,letter+alpha[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 알파벳 개수, 암호 길이 입력
		st = new StringTokenizer(br.readLine());
		alphaCnt = Integer.parseInt(st.nextToken());
		alphaLen = Integer.parseInt(st.nextToken());
		
		// 알파벳 종류 배열 생성
		alpha = new char[alphaLen];
		
		// 알파벳 종류 입력
		String line = br.readLine();
		for(int i=0; i<alpha.length; i++) {
			alpha[i] = line.charAt(i*2);
		}
		
		// 문자 정렬
		Arrays.sort(alpha);
		
		// 암호 만들기
		solve(0,0,0,0,"");
		
		// 결과 출력
		System.out.println(sb.toString());
	}
}