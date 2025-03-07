import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑 클래스
class Tower {
    int point;
    int height;

    public Tower(int point, int height) {
        this.point = point;
        this.height = height;
    }
}

public class Main {

    // 탑 개수
    public static int towerCount;

    // 결과, 탑 높이 배열
    public static int[] answer, towers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 탑 개수 입력
        towerCount = Integer.parseInt(br.readLine());

        // 탑 높이 배열 생성
        towers = new int[towerCount];

        // 탑 높이 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<towerCount; index++) {
            towers[index] = Integer.parseInt(st.nextToken());
        }

        // 높이 저장 스택 생성
        answer = new int[towerCount];
        Stack<Tower> stack = new Stack<>();

        // 높이 확인
        for(int index=towerCount-1; index>=0; index--) {

            // 현재 높이
            int currentHeight = towers[index];

            // 이전 탑 확인
            while(!stack.isEmpty() && stack.peek().height<currentHeight) {
                Tower tower = stack.pop();
                answer[tower.point] = index+1;
            }

            stack.push(new Tower(index, currentHeight));
        }

        // 결과 출력
        for(int index=0; index<towerCount; index++) {
            sb.append(answer[index]).append(" ");
        }
        System.out.println(sb.toString());
    }
}