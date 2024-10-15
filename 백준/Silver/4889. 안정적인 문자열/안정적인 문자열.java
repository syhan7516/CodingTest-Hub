import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        int caseNumber = 1;

        while(true) {

            // 결과
            int answer = 0;

            // 문자열 입력
            String letters = br.readLine();

            // "-" 경우
            if(letters.charAt(0)=='-') break;

            // 괄호 관리 스택 생성
            Stack<Character> letterManager = new Stack<>();

            // 문자열 확인
            for(int letter=0; letter<letters.length(); letter++) {

                // 확인 문자
                char currentletter = letters.charAt(letter);

                // "{" 경우
                if(currentletter=='{') {

                    // 스택에 삽입
                    letterManager.push(currentletter);
                }

                // "}" 경우
                else {

                    // 스택에 요소가 존재하면서 "{" 경우
                    if(!letterManager.isEmpty() && letterManager.peek()=='{')
                        letterManager.pop();

                    // 아닌 경우
                    else letterManager.push(currentletter);
                }
            }

            // 처리 후 스택에 문자가 존재하는 경우
            if(!letterManager.isEmpty()) {

                // "}" 여부
                boolean flag = false;

                while(!letterManager.isEmpty()) {

                    // 스택에서 하나 제거
                    char currentLetter = letterManager.pop();

                    // "{" 경우
                    if(currentLetter=='{') {

                        // "}" 없을 경우
                        if(!flag) {
                            flag = true;
                            answer++;
                        }

                        // "}" 있을 경우
                        else flag = false;
                    }

                    // "}" 경우
                    else {

                        // "}" 있을 경우
                        if(flag) {
                            flag = false;
                            answer++;
                        }

                        // "}" 없을 경우
                        else flag = true;
                    }
                }
            }

            // 결과 저장
            sb.append(caseNumber).append(". ").append(answer).append("\n");

            // 케이스 수 증가
            caseNumber++;
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}