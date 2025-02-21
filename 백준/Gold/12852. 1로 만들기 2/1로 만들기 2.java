import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    // 3으로 나누기 가능 여부 메서드
    public static boolean isDividThree(int number) {
        return number%3 == 0;
    }

    // 2로 나누기 가능 여부 메서드
    public static boolean isDividTwo(int number) {
        return number%2 == 0;
    }

    // 0보다 큰 값인지 확인하는 메서드
    public static boolean isThanZero(int number) {
        return number>0;
    }

    // 결과 저장 메서드
    public static String saveResult(int DP[], int path[]) {

        StringBuilder sb = new StringBuilder();

        // 경로 저장 스택 생성
        Stack<Integer> stack = new Stack<Integer>();

        // 연산 횟수 저장
        sb.append(DP[1]).append("\n");

        // 시작 설정
        int index = 1;

        // 경로 저장
        while(index!=0) {
            stack.push(index);
            index = path[index];
        }

        // 역경로 저장
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시작 숫자 입력
        int num = Integer.parseInt(br.readLine());

        // 경로 배열, 최소 연산 횟수 배열 생성
        int path[] = new int[num+1];
        int DP[] = new int[num+1];

        // 초기 설정
        Arrays.fill(DP,1000001);
        DP[num] = 0;

        // 연산 수행
        for(int index=num; index>=1; index--) {

            // 3으로 나누기 가능한 경우
            if(isDividThree(index) && DP[index/3]>DP[index]+1) {
                DP[index/3] = DP[index]+1;
                path[index/3] = index;
            }

            // 2로 나누기 가능한 경우
            if(isDividTwo(index) && DP[index/2]>DP[index]+1) {
                DP[index/2] = DP[index]+1;
                path[index/2] = index;
            }

            // -1
            if(DP[index-1]>DP[index]+1) {
                DP[index-1] = DP[index]+1;
                path[index-1] = index;
            }
        }

        // 결과 저장, 출력
        System.out.println(saveResult(DP,path));
    }
}