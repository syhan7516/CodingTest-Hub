import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 변환 숫자
class NextNumber {
    int number;
    int transCount;

    public NextNumber(int number, int transCount) {
        this.number = number;
        this.transCount = transCount;
    }
}

public class Main {

    // 소수 배열
    public static boolean prime[];

    // 소수 확인 메서드
    public static void settingPrime() {

        for(int number=2; number<10000; number++) {

            // 소수인 경우
            if(!prime[number]) {

                // 다음 배수 숫자 설정
                int startNumber = number*2;

                // 배수 처리
                for(int compareNumber=startNumber; compareNumber<10000; compareNumber+=number)
                    prime[compareNumber] = true;
            }
        }
    }

    // 변환 최소 횟수 구하기 메서드
    public static int solve(int currentPrime, int targetPrime) {

        // 숫자 탐색 큐
        Queue<NextNumber> queue = new LinkedList<>();

        // 방문 여부 배열
        boolean visited[] = new boolean[10000];

        // 첫 숫자 처리
        queue.offer(new NextNumber(currentPrime,0));
        visited[currentPrime] = true;

        // 숫자 탐색
        while(!queue.isEmpty()) {

            // 기준 숫자
            NextNumber currentNumber = queue.poll();
            int number = currentNumber.number;
            int transCount = currentNumber.transCount;

            // 기준 숫자와 목표 숫자가 동일한 경우
            if(number==targetPrime)
                return transCount;

            // 일의 자리 바꾸기
            int first = number/10*10;
            for(int i=0; i<10; i++){
                int mock = first+i;
                if(!prime[mock] && !visited[mock]){
                    visited[mock] = true;
                    queue.add(new NextNumber(mock,transCount+1));
                }
            }
            // 십의 자리 바꾸기
            first = (number/100*100)+(number%10);
            for(int i=0; i<10; i++){
                int mock = first+i*10;
                if(!prime[mock] && !visited[mock]){
                    visited[mock] = true;
                    queue.add(new NextNumber(mock,transCount+1));
                }
            }
            // 백의 자리 바꾸기
            first = (number/1000*1000)+(number%100);
            for(int i=0; i<10; i++){
                int mock = first+i*100;
                if(!prime[mock] && !visited[mock]){
                    visited[mock] = true;
                    queue.add(new NextNumber(mock,transCount+1));
                }
            }
            //천의 자리 바꾸기
            first = number%1000;
            for(int i=1; i<10; i++){
                int mock = first+i*1000;
                if(!prime[mock] && !visited[mock]){
                    visited[mock] = true;
                    queue.add(new NextNumber(mock,transCount+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 소수 배열 생성
        prime = new boolean[10000];

        // 소수 확인
        settingPrime();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 기준 소수, 목표 소수 입력
            st = new StringTokenizer(br.readLine());
            int currentPrime = Integer.parseInt(st.nextToken());
            int targetPrime = Integer.parseInt(st.nextToken());

            // 변환 최소 횟수 구하기
            int minCount = solve(currentPrime,targetPrime);

            // 결과 저장
            if(minCount==-1) sb.append("Impossible").append("\n");
            else sb.append(minCount).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}