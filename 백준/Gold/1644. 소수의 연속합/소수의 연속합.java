import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 소수 배열 생성
        boolean isPrime[] = new boolean[4000001];

        // 소수 저장 큐
        Queue<Integer> queue = new LinkedList<>();

        // 소수 구하기
        for(int i=2; i*i<4000001; i++) {
            if(!isPrime[i]) {
                for(int j=i*i; j<4000001; j+=i) {
                    isPrime[j] = true;
                }
            }
        }

        // 자연수 입력
        int number = Integer.parseInt(br.readLine());

        // 범위까지 소수 저장
        for(int i=2; i<=number; i++)
            if(!isPrime[i]) queue.offer(i);

        // 결과
        int answer = 0;

        // 소수 합 구하기
        long prefixSum = 0;

        // 주어진 수까지 확인
        for(int i=2; i<=number; i++) {

            // 소수인 경우
            if(!isPrime[i])
                prefixSum += i;

            // 더한 값이 같거나 큰 경우
            if(prefixSum>=number) {

                // 작아 질 때까지 앞 소수 빼기
                while(prefixSum>=number) {

                    // 자연수와 같아질 경우, 경우의 수 증가 
                    if(prefixSum==number)
                        answer++;

                    // 앞 소수 빼기
                    if(!queue.isEmpty())
                        prefixSum -= queue.poll();

                    else break;
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}