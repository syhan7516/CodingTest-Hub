import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 숫자 개수
    public static int maxResult, minResult, numCount;

    // 숫자 배열, 연산자 개수 배열
    public static int [] numbers, operators;

    // 연산자 사용 여부 배열
    public static boolean visited[];

    // 연산자 순서 배열
    public static char operatorOrder[];

    // 연산자 정보 배열
    public static char operatorinfo[] = {'+','-','*','/'};

    // 연산자 생성
    public static void createOperator(int operatorCount) {

        int index = 0;
        operatorOrder = new char[operatorCount];
        for(int operator=0; operator<4; operator++) {
            while(operators[operator]>0) {
                operatorOrder[index] = operatorinfo[operator];
                operators[operator]--;
                index++;
            }
        }
    }

    // 연산 메서드
    public static int operation(int number1, int number2, char operator) {

        // "+"
        if(operator=='+')
            return number1 + number2;

        // "-"
        else if(operator=='-')
            return number1 - number2;

        // "*"
        else if(operator=='*')
            return number1 * number2;

        // "/"
        else return number1 / number2;
    }

    // 연산 수행 메서드
    public static void solve(int count, int result) {

        // 연산을 다 수행한 경우
        if(count==numCount-1) {
            minResult = Math.min(minResult,result);
            maxResult = Math.max(maxResult,result);
            return;
        }

        // 연산 선택하기
        for(int operator=0; operator<operatorOrder.length; operator++) {

            // 사용하지 않은 연산일 경우
            if(!visited[operator]) {
                visited[operator] = true;
                solve(count+1,operation(result,numbers[count+1],operatorOrder[operator]));
                visited[operator] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        numCount = Integer.parseInt(br.readLine());

        // 숫자 배열, 연산자 개수 배열 생성
        numbers = new int[numCount];
        operators = new int[4];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int number=0; number<numCount; number++)
            numbers[number] = Integer.parseInt(st.nextToken());

        // 연산자 개수 정보 입력
        int operatorCount = 0;
        st = new StringTokenizer(br.readLine());
        for(int operator=0; operator<4; operator++) {
            operators[operator] = Integer.parseInt(st.nextToken());
            operatorCount += operators[operator];
        }

        // 연산자 생성
        createOperator(operatorCount);

        // 연산 수행
        minResult = Integer.MAX_VALUE;
        maxResult = Integer.MIN_VALUE;
        visited = new boolean[operatorCount];

        solve(0,numbers[0]);

        // 결과 출력
        System.out.println(maxResult+"\n"+minResult);
    }
}