import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 입력
        int number = Integer.parseInt(br.readLine());

        // 정수 값이 1인 경우
        if(number==1)
            return;

        // 정수까지의 소수 구하기
        boolean nums[] = new boolean[number+1];
        nums[0] = true;
        nums[1] = true;
        for(int a=2; a<=number; a++) {
            if(nums[a]==false) {
                for(int b=a+a; b<=Math.sqrt(number); b=b+a) {
                    nums[b] = true;
                }
            }
        }

        // 소인 가져오기
        for(int a=2; a<=number; a++) {
            // 소수인 경우
            if(nums[a]==false) {
                while(true) {

                    // 종료 조건
                    if(number==1 || number%a!=0)
                        break;

                    // 소인수분해
                    System.out.println(a);
                    number /= a;
                }
            }
        }
    }
}