import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 최대, 최소
    public static int maxNum = Integer.MIN_VALUE;
    public static int minNum = Integer.MAX_VALUE;
    // 연산자 정보
    public static int operator[] = new int[4];
    // 숫자
    public static int nums[];
    // 숫자 개수
    public static int numCnt;

    // 연산 함수
    static void operation(int number, int idx) {
        // 연산을 모두 수행한 경우
        if (idx==numCnt) {
            maxNum = Math.max(maxNum, number);
            minNum = Math.min(minNum, number);
            return;
        }

        // 아닌 경우
        for (int p=0; p<4; p++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[p]>0) {
                // 해당연산자를 1 감소
                operator[p]--;
                // 연산
                switch(p) {
                    case 0:
                        operation(number+nums[idx],idx+1);
                        break;
                    case 1:
                        operation(number-nums[idx],idx+1);
                        break;
                    case 2:
                        operation(number*nums[idx],idx+1);
                        break;
                    case 3:
                        operation(number/nums[idx],idx+1);
                        break;
                }

                // 연산자 개수 복구
                operator[p]++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 개수 입력
        numCnt = Integer.parseInt(br.readLine());
        nums = new int[numCnt];

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for (int idx=0; idx<numCnt; idx++) {
            nums[idx] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int idx=0; idx<4; idx++) {
            operator[idx] = Integer.parseInt(st.nextToken());
        }

        // 연산
        operation(nums[0],1);
        // 결과 출력
        System.out.println(maxNum);
        System.out.println(minNum);
    }
}