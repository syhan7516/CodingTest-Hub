import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 사람 수 입력
        int saramCount = Integer.parseInt(br.readLine());

        // 시간 정보 배열 생성
        int times[] = new int[saramCount];

        // 시간 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int time=0; time<saramCount; time++) {
            times[time] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(times);

        // 시간 확인
        int waitTime = 0;
        for(int time=0; time<saramCount; time++) {
            waitTime += times[time];
            answer += waitTime;
        }

        // 결과 출력
        System.out.println(answer);
    }
}