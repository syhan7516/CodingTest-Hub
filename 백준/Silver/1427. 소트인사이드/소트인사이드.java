import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 결과 저장 메서드
    public static String saveResult(char[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int numIndex=nums.length-1; numIndex>=0; numIndex--) {
            sb.append(nums[numIndex]);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        String number = br.readLine();

        // 한자리씩 분해
        char[] nums = number.toCharArray();

        // 정렬
        Arrays.sort(nums);

        // 결과 출력
        System.out.println(saveResult(nums));
    }
}