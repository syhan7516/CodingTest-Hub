import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 지시 수
    public static int orderCount;

    // 로봇 배열, 부품 개수 배열
    public static int[] robots, parts;

    // find
    public static int find(int num) {
        if(robots[num] == num) {
            return num;
        }

        return robots[num] = find(robots[num]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) {
            robots[b] = a;
            parts[a] += parts[b];
        }
        else {
            robots[a] = b;
            parts[b] += parts[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 지시 수 입력
        orderCount = Integer.parseInt(br.readLine());

        // 부품 배열 생성
        parts = new int[1000001];
        Arrays.fill(parts, 1);

        // 로봇 배열 생성
        robots = new int[1000001];
        for(int index=1; index<=1000000; index++) {
            robots[index] = index;
        }

        // 지시 수행
        for(int index=0; index<orderCount; index++) {
            st = new StringTokenizer(br.readLine());
            char orderType = st.nextToken().charAt(0);

            // I
            if(orderType == 'I') {
                int firstPart = Integer.parseInt(st.nextToken());
                int secondPart = Integer.parseInt(st.nextToken());
                if(find(firstPart) == find(secondPart)) continue;
                union(firstPart, secondPart);
            }

            // Q
            else {
                int robotNum = Integer.parseInt(st.nextToken());
                sb.append(parts[find(robotNum)]).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}