import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 건물 개수 입력
        int buildingCount = Integer.parseInt(br.readLine());

        // 높이 저장 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 건물 정보 입력
        for(int buildingIndex=0; buildingIndex<buildingCount; buildingIndex++) {

            // 위치, 높이 입력
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int height = Integer.parseInt(st.nextToken());

            // 이전 건물보다 높이가 작은 경우
            while(!stack.isEmpty() && stack.peek()>height) {
                stack.pop();
                answer++;
            }

            // 높이가 0인 경우
            if(height==0) continue;

            // 첫 건물이거나, 이전보다 높은 건물인 경우
            if(stack.isEmpty() || stack.peek()<height)
                stack.push(height);
        }

        // 결과 출력
        System.out.println(answer+stack.size());
    }
}