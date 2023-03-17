import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        String letters = br.readLine();

        // 숫자 분리
        int numSum = 0;
        int nums[] = new int[10];
        for(int idx=0; idx<letters.length(); idx++) {
            int number = Integer.parseInt(letters.substring(idx,idx+1));
            nums[number] += 1;
            numSum += number;
        }

        // 30의 배수 확인
        if(letters.contains("0") && numSum%3==0) {
            // 30의 배수인 경우
            for(int n=9; n>=0; n--) {
                while(true) {
                    if(nums[n]==0)
                        break;

                    System.out.print(n);
                    nums[n] -= 1;
                }
            }
        }
        // 아닌 경우
        else
            System.out.println(-1);
    }
}