import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 라운드 수
    public static int roundCount;

    // 점수
    public static long firstScore, secondScore;

    // 해시 맵
    public static HashMap<Integer, Boolean> visited;

    // 소수 판별 메서드
    public static boolean isPrime(int number) {

        // 0 또는 1인 경우
        if(number == 0 || number == 1) return false;

        // 숫자 확인
        for(int num=2; num*num<=number; num++) {
            if(number % num == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 라운드 수 입력
        roundCount = Integer.parseInt(br.readLine());

        // 점수
        firstScore = 0;
        secondScore = 0;

        // 우선 순위 큐 생성
        PriorityQueue<Integer> firstNums = new PriorityQueue<>();
        PriorityQueue<Integer> secondNums = new PriorityQueue<>();

        // 해시 맵 생성
        visited = new HashMap<>();

        // 라운드 수행
        for(int round=0; round<roundCount; round++) {
            st = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(st.nextToken());

            // 대웅 숫자 확인
            if(visited.containsKey(firstNum)) {
                firstScore -= 1000;
            }

            else if(isPrime(firstNum)) {
                firstNums.offer(firstNum);
                if(firstNums.size() > 3) {
                    firstNums.poll();
                }
                visited.put(firstNum, true);
            }

            else {
                if(secondNums.size() < 3) {
                    secondScore += 1000;
                }

                else {
                    secondScore += secondNums.peek();
                }
            }

            int secondNum = Integer.parseInt(st.nextToken());

            // 규선 숫자 확인
            if(visited.containsKey(secondNum)) {
                secondScore -= 1000;
            }

            else if(isPrime(secondNum)) {
                secondNums.offer(secondNum);
                if(secondNums.size() > 3) {
                    secondNums.poll();
                }
                visited.put(secondNum, true);
            }

            else {
                if(firstNums.size() < 3) {
                    firstScore += 1000;
                }

                else {
                    firstScore += firstNums.peek();
                }
            }
        }

        // 결과 저장
        if(firstScore == secondScore) System.out.println("우열을 가릴 수 없음");
        else if(firstScore > secondScore) System.out.println("소수의 신 갓대웅");
        else System.out.println("소수 마스터 갓규성");
    }
}