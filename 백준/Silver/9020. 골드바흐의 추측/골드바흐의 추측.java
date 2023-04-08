import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 소수 구하기
        boolean primes[] = new boolean[10001];
        primes[1] = true;
        for(int a=2; a*a<=10000; a++) {
            if(!primes[a]) {
                for(int b=a+a; b<=10000; b+=a) {
                    primes[b] = true;
                }
            }
        }

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 자연수 입력
            int number = Integer.parseInt(br.readLine());

            // 자연수까지 소수 찾기
            ArrayList<Integer> prime = new ArrayList<>();
            for(int p=2; p<=number; p++) {
                if(!primes[p]) {
                    prime.add(p);
                }
            }

            // 골드바흐 수 구하기
            int firPoint = 0;
            int secPoint = prime.size()-1;
            int diff = 10000;
            int result[] = new int[2];

            while(firPoint<=secPoint) {

                // 가르키는 값 더하기
                int numSum = prime.get(firPoint) + prime.get(secPoint);

                // 더한 값이 자연수 보다 클 경우
                if(numSum>number) {
                    secPoint--;
                }

                // 더한 값이 자연수 보다 작을 경우
                else if(numSum<number) {
                    firPoint++;
                }

                // 더한 값이 자연수와 같을 겨우
                else {
                    int numDiff = prime.get(secPoint) - prime.get(firPoint);
                    if(diff>numDiff) {
                        diff = numDiff;
                        result[0] = prime.get(firPoint);
                        result[1] = prime.get(secPoint);
                    }

                    firPoint++;
                    secPoint--;
                }
            }

            // 결과 출력
            System.out.println(result[0]+" "+result[1]);
        }
    }
}