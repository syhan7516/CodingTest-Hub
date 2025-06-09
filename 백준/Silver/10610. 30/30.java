import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자 입력
        String number = br.readLine();

        // 한자리로 분해
        char[] nums = number.toCharArray();

        // 정렬
        Arrays.sort(nums);

        // 확인
        int sum = 0;
        for(int numIndex=nums.length-1; numIndex>=0; numIndex--) {
            sum += nums[numIndex]-'0';
            sb.append(nums[numIndex]);
        }

        // 결과 출력
        if(sum%3==0 && nums[0]=='0') System.out.println(sb.toString());
        else System.out.println(-1);
    }
}