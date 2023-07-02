import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자를 적을 스택 만들기
        Stack<Integer> memo = new Stack<>();

        // 적을 숫자 횟수 입력
        int count = Integer.parseInt(br.readLine());

        // 숫자 정보 입력
        for(int idx=0; idx<count; idx++) {

            // 입력
            int number = Integer.parseInt(br.readLine());

            // 숫자가 0이 아닌 경우만 저장
            if(number!=0)
                memo.push(number);
                // 숫자가 0인 경우 지우기
            else
                memo.pop();
        }

        // 메모장에 남아있는 숫자 확인
        int result = 0;

        if(memo.size()!=0) {
            // 남아 있는 숫자 더하기
            while(!memo.isEmpty()) {
                result += memo.pop();
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}