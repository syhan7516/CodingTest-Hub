
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수열의 크기 입력
        int setSize = Integer.parseInt(br.readLine());

        // 수열 만들기
        int nums[] = new int[setSize];
        for(int n=0; n<setSize; n++) {
            nums[n] = Integer.parseInt(br.readLine());
        }

        // 수열 정렬
        Arrays.sort(nums);

        // 수열 합구하기
        Stack<Long> stack = new Stack<>();
        int secPoint = nums.length-2;
        stack.push((long) nums[secPoint+1]);

        // 기본 셋팅
        int curNum = 0;
        long stackNum = 0;
        boolean operator = true;

        // 양수 처리
        while(true) {
            // 종료 조건
            if(secPoint<0)
                break;

            // 수 하나 가져오기
            curNum = nums[secPoint];

            // 가져온 수가 음수인 경우
            if(curNum<0)
                break;

            // 곱하기 연산 가능할 경우
            if(operator) {

                // 스택에서 수 꺼내기
                stackNum = stack.pop();

                long firOp = curNum+stackNum;
                long secOp = curNum*stackNum;

                // 곱하기가 큰 경우
                if(firOp<secOp) {
                    stack.push(secOp);
                    operator = false;
                }

                // 더하기가 큰 경우
                else {
                    stack.push(stackNum);
                    stack.push((long)curNum);
                }
            }

            // 곱하기 연산 불가능할 경우
            else {
                stack.push((long)curNum);
                operator = true;
            }

            // 연산 횟수 감소
            secPoint--;
        }

        // 음수 처리
        if(curNum<0) {
            operator = true;
            int firPoint = 0;
            stack.push((long) nums[firPoint]);
            firPoint++;

            while(true) {
                // 종료 조건
                if(firPoint>=nums.length)
                    break;

                // 수 하나 가져오기
                curNum = nums[firPoint];

                // 가져온 수가 양수인 경우
                if(curNum>0)
                    break;

                // 곱하기 연산 가능할 경우
                if(operator) {

                    // 스택에서 수 꺼내기
                    stackNum = stack.pop();

                    long firOp = curNum+stackNum;
                    long secOp = curNum*stackNum;

                    // 곱하기가 큰 경우
                    if(firOp<secOp) {
                        stack.push(secOp);
                        operator = false;
                    }

                    // 더하기가 큰 경우
                    else {
                        stack.push(stackNum);
                        stack.push((long)curNum);
                    }
                }

                // 곱하기 연산 불가능할 경우
                else {
                    stack.push((long)curNum);
                    operator = true;
                }

                // 연산 횟수 감소
                firPoint++;
            }
        }

        // 결과 저장 & 출력
        long result = 0;
        for(long element: stack)
            result += element;
        System.out.println(result);
    }
}