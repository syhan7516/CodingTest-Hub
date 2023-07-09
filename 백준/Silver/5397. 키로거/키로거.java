import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    // 입력, 임시 스택
    public static Stack<Character> input, temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 문장 입력
            String sentense = br.readLine();

            // 입력, 임시 스택
            Stack<Character> input = new Stack<>();
            Stack<Character> temp = new Stack<>();

            // 문장 분석
            for(int c=0; c<sentense.length(); c++) {

                // 문자
                char letter = sentense.charAt(c);

                // 화살표일 경우
                if('<'==letter||'>'==letter) {

                    // '<'
                    if('<'==letter) {
                        // 입력 스택에 요소가 남았을 경우
                        if(!input.isEmpty()) {
                            char alpha = input.pop();
                            temp.push(alpha);
                        }
                    }

                    // '>'
                    else {
                        // 임시 스택에 요소가 남았을 경우
                        if(!temp.isEmpty()) {
                            char alpha = temp.pop();
                            input.push(alpha);
                        }
                    }
                }

                // 백스페이스일 경우
                else if('-'==letter) {

                    // 입력 스택에 요소가 남았을 경우
                    if(!input.isEmpty()) input.pop();
                }

                // 일반 문자일 경우
                else {

                    // 문자 입력
                    input.push(letter);
                }
            }

            // 비밀번호 만들기
            while(!input.isEmpty()) {
                temp.push(input.pop());
            }
            while(!temp.isEmpty()) {
                sb.append(temp.pop());
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}