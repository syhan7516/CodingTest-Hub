import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 남은 일 수, 일 가능한 일 수 입력
        st = new StringTokenizer(br.readLine());
        int existDays = Integer.parseInt(st.nextToken());
        int workDays = Integer.parseInt(st.nextToken());

        // 급여 누적합 배열 생성
        int[] salary = new int[existDays+1];

        // 급여 누적합
        long prefixSum = 0;

        // 급여 정보 입력
        st = new StringTokenizer(br.readLine());
        salary[1] = Integer.parseInt(st.nextToken());
        prefixSum = salary[1];
        for(int day=2; day<=workDays; day++) {
            salary[day] = Integer.parseInt(st.nextToken());
            prefixSum += salary[day];
        }

        long answer = 0;

        if(workDays > 0 && workDays < existDays) {
            answer = prefixSum;
            for(int day=workDays+1; day<=existDays; day++) {
                salary[day] = Integer.parseInt(st.nextToken());
                prefixSum = prefixSum - salary[day-workDays] + salary[day];
                answer = Math.max(answer,prefixSum);
            }
        }

        // 결과 출력
        answer = workDays == existDays ? prefixSum : answer;
        System.out.println(answer);
    }
}