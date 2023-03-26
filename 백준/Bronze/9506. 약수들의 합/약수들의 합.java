import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            // 숫자 입력
            int number = Integer.parseInt(br.readLine());

            // 종료 조건
            if(number==-1)
                break;

            // 소수 찾기
            int numSum = 1;
            sb.append(number).append(" = 1");
            for(int idx=2; idx<number; idx++) {
                // 소수인 경우
                if(number%idx==0) {
                    numSum += idx;
                    sb.append(" + ").append(idx);
                }
            }

            // 완전수 확인
            if(numSum==number)
                System.out.println(sb.toString());
            else
                System.out.println(number+" is NOT perfect.");

            // 초기화
            sb.setLength(0);
        }
    }
}