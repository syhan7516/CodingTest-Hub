import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // 정수
    public static long firstNum ,secondNum;

    // 다음 숫자 구하기 메서드
    public static long getNextSequence(long number) {
        if(number %2 == 1) {
            return number * 3 + 1;
        }

        return number / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 수행
        while(true) {

            // 두 정수 입력
            st = new StringTokenizer(br.readLine());
            firstNum = Integer.parseInt(st.nextToken());
            secondNum = Integer.parseInt(st.nextToken());

            // 마지막인 경우
            if(firstNum == 0 && secondNum == 0) break;

            // 수열 저장 해시 맵 생성
            HashMap<Long,Integer> sequence = new HashMap<>();

            // 첫번째 정수 수열 구하기
            long firstCurrentNum = firstNum;
            int step = 0;
            sequence.put(firstCurrentNum, step);

            while(firstCurrentNum != 1) {
                firstCurrentNum = getNextSequence(firstCurrentNum);
                step++;
                sequence.put(firstCurrentNum, step);
            }

            // 두번째 정수 수열 확인
            long commonNum = -1;
            long secondCurrentNum = secondNum;
            step = 0;
            while(true) {

                // 공통 조상인 경우
                Integer result = sequence.get(secondCurrentNum);
                if(result != null) {
                    commonNum = secondCurrentNum;
                    break;
                }

                // 숫자 갱신
                secondCurrentNum = getNextSequence(secondCurrentNum);
                step++;
            }

            // 결과 저장
            sb.append(firstNum).append(" needs ").append(sequence.get(commonNum)).append(" steps, ");
            sb.append(secondNum).append(" needs ").append(step).append(" steps, ");
            sb.append("they meet at ").append(commonNum).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}