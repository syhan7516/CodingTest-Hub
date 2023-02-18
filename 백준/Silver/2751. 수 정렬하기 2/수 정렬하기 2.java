import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 개수 입력
        int cnt = Integer.parseInt(br.readLine());
        // 개수 배열 생성
        boolean nums[] = new boolean[2000002];
        // 수 입력
        for(int idx=0; idx<cnt; idx++) {
            int number = Integer.parseInt(br.readLine());
            nums[number+1000001] = true;
        }
        // 수 확인
        for(int value=1; value<2000002; value++) {
            if(nums[value] == true)
                sb.append(value-1000001+"\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}