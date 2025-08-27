import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 행복한 수 확인 메서드
    public static boolean solve(int number) {

        // 방문 여부 배열 생성
        boolean[] visited = new boolean[100001];

        while(!visited[number]) {

            // 방문 처리
            visited[number] = true;

            // 행복한 수인 경우
            if(number == 1) {
                return true;
            }

            // 임시
            int mock = number;
            int sum = 0;

            // 각 자리 수 제곱해서 더하기
            while(mock > 0) {
                sum += (int)Math.pow(mock % 10, 2);
                mock /= 10;
            }

            number = sum;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 소수 배열 생성
        boolean[] isPrime = new boolean[10001];

        // 소수 확인
        for(int num=2; num*num<=10000; num++) {
            if(!isPrime[num]) {
                for(int mutipleNum=num+num; mutipleNum<=10000; mutipleNum+=num) {
                    isPrime[mutipleNum] = true;
                }
            }
        }

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=1; caseNum<=caseCount; caseNum++) {
            st = new StringTokenizer(br.readLine());
            int caseIndex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            sb.append(caseIndex).append(" ").append(number).append(" ");

            // 소수 여부 확인 - 행복한 수 확인
            if(number != 1 && !isPrime[number] && solve(number)) {
                sb.append("YES");
            }

            else sb.append("NO");

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}

// 1 1 NO
//2 7 YES
//3 383 YES
//4 1000 NO