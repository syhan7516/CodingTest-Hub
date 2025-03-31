import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 숫자 클래스
class Num {
    int index;
    int data;

    public Num(int index, int data) {
        this.index = index;
        this.data = data;
    }
}

public class Main {

    // 입력 버퍼, 출력 빌더 등
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;

    // 숫자 개수
    public static int numCount;

    // 숫자 배열
    public static Num[] nums;

    // 오큰수 정보 배열
    public static int[] answer;

    // 숫자 비교 스택
    public static Stack<Num> stack;

    // 입출력 초기화 메서드
    public static void initializeIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    // 숫자 개수 입력 메서드
    public static void inputNumCount() throws IOException {
        st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken());
    }

    // 숫자 배열 생성 및 입력 메서드
    public static void createNumArrayAndInputNum() throws IOException {

        // 숫자 배열 생성
        nums = new Num[numCount];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<numCount; index++) {
            int num = Integer.parseInt(st.nextToken());
            nums[index] = new Num(index,num);
        }
    }

    // 비교 가능한 숫자 존재 여부 메서드
    public static boolean canCompareToNum() {
        return !stack.isEmpty();
    }

    // 오큰수인지 확인하는 메서드
    public static boolean isNGE(int num) {
        return num > stack.peek().data;
    }

    // 오큰수가 있는 숫자 처리 메서드
    public static void handleHasNextGreater() {

        // 숫자 배열 순회
        for(int index=0; index<nums.length; index++) {

            // 확인 숫자보다 크기가 작은 앞의 수 처리
            while(canCompareToNum() && isNGE(nums[index].data)) {
                answer[stack.peek().index] = nums[index].data;
                stack.pop();
            }

            // 확인 숫자 스택에 저장
            stack.push(nums[index]);
        }
    }

    // 오큰수가 없는 숫자 처리
    public static void handleHasNotNextGreater() {

        while(!stack.isEmpty()) {
            answer[stack.pop().index] = -1;
        }
    }

    // 오큰수 구하기 메서드
    public static void solve() {

        // 오큰수가 있는 숫자 처리
        handleHasNextGreater();

        // 오큰수가 없는 숫자 처리
        handleHasNotNextGreater();
    }

    // 숫자 비교를 위한 스택 생성 메서드
    public static void createNumStack() {
        stack = new Stack<>();
    }

    // 오큰수 정보 배열 생성 메서드
    public static void createAnswerArray() {
        answer = new int[numCount];
    }

    // 초기화 메서드
    public static void initialize() throws IOException {

        // 입출력 초기화
        initializeIO();

        // 숫자 개수 입력
        inputNumCount();

        // 숫자 배열 생성 및 입력
        createNumArrayAndInputNum();

        // 숫자 비교를 위한 스택 생성
        createNumStack();

        // 오큰수 정보 배열 생성
        createAnswerArray();
    }

    // 결과 저장 메서드
    public static void saveAnswer() {
        for(int index=0; index<nums.length; index++) {
            sb.append(answer[index]).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기화
        initialize();

        // 오큰수 구하기
        solve();

        // 결과 저장
        saveAnswer();

        // 결과 출력
        System.out.println(sb.toString());
    }
}