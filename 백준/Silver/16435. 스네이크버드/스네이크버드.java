import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 과일 개수, 스네이크 버드 길이 입력
		st = new StringTokenizer(br.readLine());
		int fruitCnt = Integer.parseInt(st.nextToken());
		int snakeBirdLen = Integer.parseInt(st.nextToken());
		
		// 과일 높이 입력
		int height[] = new int[fruitCnt];
	
		st = new StringTokenizer(br.readLine());
		for(int h=0; h<fruitCnt; h++) {
			height[h] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(height);
		
		// 먹이 먹기
		for(int h=0; h<fruitCnt; h++) {
			
			// 먹을 수 있는 높이인 경우
			if(snakeBirdLen>=height[h]) {
				snakeBirdLen++;
			}
		}
		
		// 결과 출력
		System.out.println(snakeBirdLen);
	}
}