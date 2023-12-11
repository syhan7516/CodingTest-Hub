import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 식 입력
        String sentense = br.readLine();

        // 피연산자 시작 위치
        int start = 0;

        // 연산 중간, 최종 결과
        int result = 0;
        int answer = 0;

        // 현재 연산 정보
        boolean flag = true;

        // 식 확인
        for(int i=0; i<sentense.length(); i++) {
            
            // 문자 확인
            char c = sentense.charAt(i);

            // - , +
            if(c=='-' || c=='+') {

                // 숫자 만들기
                int number = Integer.parseInt(sentense.substring(start,i));

                // 숫자 더하기
                result += number;

                // -
                if(c=='-') {

                    // 이전 연산 +
                    if(flag) answer += result;

                    // 이전 연산 -
                    else answer += (-result);

                    flag = false;
                    result = 0;
                }

                start = i+1;
            }
            
            // 숫자
            else {

                // 마지막
                if(i==sentense.length()-1) {
                    int number = Integer.parseInt(sentense.substring(start,i+1));
                    result += number;
                }

                // 아닌 경우
                else continue;
            }
        }

        // 이전 연산 -
        if(!flag) answer += (-result);

        // 이전 연산 +
        else answer += result;

        // 결과 출력
        System.out.println(answer);
    }
}