import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 숫자 개수 저장 해시 맵 생성
            HashMap<Long, Integer> nums = new HashMap<>();

            // 숫자 개수, 목표 숫자 입력
            st = new StringTokenizer(br.readLine());
            int numCount = Integer.parseInt(st.nextToken());
            int targetNum = Integer.parseInt(st.nextToken());

            // 숫자 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int index=0; index<numCount; index++) {
                long num = Integer.parseInt(st.nextToken());
                nums.put(num, nums.getOrDefault(num, 0)+1);
            }

            // 조합 수 구하기
            long answer = 0;

            // 목표 숫자가 0인 경우
            if(targetNum == 0) {
                for(long key: nums.keySet()) {
                    long count = nums.getOrDefault(targetNum ^ key,0);
                    answer += count * (count -1);
                }
            }

            // 다른 숫자인 경우
            else {
                for(long key: nums.keySet()) {
                    long count = nums.getOrDefault(targetNum ^ key,0);
                    answer += nums.get(key) * count;
                }
            }

            // 결과 저장
            sb.append(answer/2).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}