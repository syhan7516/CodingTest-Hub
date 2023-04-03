import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 고도의 개수 입력
        int heightCnt = Integer.parseInt(br.readLine());

        // 고도 저장 배열
        int height[] = new int[heightCnt+1];

        // 고도 정보 입력
        for(int h=0; h<heightCnt; h++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            height[h] = Integer.parseInt(st.nextToken());
        }

        // 건물을 확인할 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 건물 확인
        int result = 0;
        for(int h=0; h<=heightCnt; h++) {

            // 비교할 건물의 높이가 존재할 경우 & 해당 값이 다음 건물보다 클 경우
            while(!stack.empty() && stack.peek() > height[h]) {
                result += 1;
                stack.pop();
            }

            // 비교할 건물의 높이가 존재할 경우 & 해당 값이 다음 건물과 높이가 같을 경우
            if(!stack.empty() && stack.peek() == height[h])
                continue;

            // 비교할 건물이 존재하지 않을 경우
            // 비교할 건물이 존재할 경우 & 해당 값이 다음 건물보다 작을 경우
            stack.push(height[h]);
        }

        // 결과 출력
        System.out.println(result);
    }
}