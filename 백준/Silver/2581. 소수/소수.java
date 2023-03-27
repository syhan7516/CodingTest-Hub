import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 범위 시작 숫자 입력
        int startNum = Integer.parseInt(br.readLine());

        // 범위 끝 숫자 입력
        int endNum = Integer.parseInt(br.readLine());



        // 최솟값 및 소수들의 합 구하기
        boolean primeExist = false;
        int minNum = endNum;
        int numSum = 0;

        // 범위 사이 숫자 확인
        for(int a=startNum; a<=endNum; a++) {

            // 시작 값이 1인 경우 제외
            if(a==1)
                continue;

            // 해당 숫자 소수 판별
            boolean flag = true;
            for(int b=2; b<a; b++) {
                if(a%b==0) {
                    flag = false;
                    break;
                }
            }

            // 소수인 경우
            if(flag==true) {
                numSum += a;
                // 소수이면서 첫 값일 경우
                if(!primeExist) {
                    primeExist = true;
                    minNum = a;
                }
            }
        }

        // 소수가 존재하지 않을 경우
        if(!primeExist)
            System.out.println(-1);

        // 소수가 존재할 경우
        else {
            System.out.println(numSum);
            System.out.println(minNum);
        }
    }
}