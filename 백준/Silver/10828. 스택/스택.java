
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스택 만들기
        Stack<Integer> stack = new Stack<>();

        // 명령어 수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령어 입력
        for(int o=0; o<orderCnt; o++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            // 명렁어 수행
            switch (order) {
                    
                // 삽입
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                    
                // 삭제
                case "pop":
                    if(!stack.isEmpty()) System.out.println(stack.pop());
                    else System.out.println(-1);
                    break;
                    
                // 크기
                case "size":
                    System.out.println(stack.size());
                    break;
                    
                // 비었는지 확인
                case "empty":
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                    
                // 탑 확인
                case "top":
                    if(!stack.isEmpty()) System.out.println(stack.peek());
                    else System.out.println(-1);
                    break;
            }
        }
    }
}