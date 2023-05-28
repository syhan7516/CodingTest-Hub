import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
        // 한 자리 수 배열로 변환
		char nums[] = line.toCharArray();
        // 자리 길이
		int numsLen = nums.length;
        // 0,1 개수 배열
		int count[] = new int[2];
        
        // 시작 숫자 설정
		char temp = nums[0];
		for(int n=1; n<numsLen; n++) {
			if(temp!=nums[n]) {
				count[temp-48]++;
				temp = nums[n];
			}
		}
		
		// 연속된 수의 끝 처리
		count[temp-48]++;
		
        // 결과 출력
		System.out.println(Math.min(count[0], count[1]));
	}
}