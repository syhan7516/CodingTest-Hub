import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = 10;

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            int result = 0;

            // 종료 여부
            boolean flag = false;

            // 괄호 개수 입력
            int cnt = Integer.parseInt(br.readLine());

            // 괄호 정보 입력
            char braket[] = br.readLine().toCharArray();

            // 괄호 저장 스택
            Stack<Character> stack = new Stack<>();

            // 괄호 검사
            stack.push(braket[0]);

            for(int s=1; s<braket.length; s++) {

                // 현재 괄호
                char curLetter = braket[s];

                // 여는 괄호인 경우
                if(curLetter=='(' || curLetter=='[' || curLetter=='{' || curLetter=='<')
                    stack.push(curLetter);

                // 닫는 괄호인 경우
                else {

                    // 스택이 빈 경우
                    if(stack.isEmpty()) {
                        flag = true;
                        break;
                    }

                    // 아닌 경우
                    else {

                        // 비교 대상
                        int differ = Math.abs(stack.peek()-curLetter);

                        // 스택의 요소와 같을 경우
                        if(differ==1 || differ==2) 
                            stack.pop();
                            
                        // 다를 경우
                        else {
                            flag = true;
                            break;
                        }
                    }
                }
            }

            // 종료되지 않으면서 괄호가 스택에 없는 경우
            if(flag==false && stack.isEmpty()) result = 1;

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}