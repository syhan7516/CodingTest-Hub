import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		
		// 사람 수 입력
		int human = Integer.parseInt(br.readLine());

		// 인출 시간 정보 입력
		int time[] = new int[human];
		st = new StringTokenizer(br.readLine());
		for(int t=0; t<human; t++) {
			time[t] = Integer.parseInt(st.nextToken());
		}

		// 인출 시간 오름 차순 정렬
		Arrays.sort(time);

		// 시간 구하기
		int result = 0;
        int answer = 0;
		for(int r=0; r<human; r++) {
			result += time[r];
			time[r] = result;
            answer += result;
		}

		// 결과 출력
		System.out.println(answer);
	}
}