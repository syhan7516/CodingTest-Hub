import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 유클리드호제법 함수
    static long mathFunction(long firNum, long secNum) {
        
        // 종료 조건
        if(firNum%secNum==0)
            return secNum;

        // b와 a%b의 최대공약수 구하기
        return mathFunction(secNum, firNum%secNum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 두 정수 입력
        long firNum = Integer.parseInt(st.nextToken());
        long secNum = Integer.parseInt(st.nextToken());

        // 유클리드호제법 기본 셋팅
        if(firNum<secNum) {
            long temp = firNum;
            firNum = secNum;
            secNum = temp;
        }

        // 유클리드호제법 수행
        long gcd = mathFunction(firNum,secNum);
        long result = firNum/gcd * secNum/gcd * gcd;

        // 결과 출력
        System.out.println(result);
    }
}