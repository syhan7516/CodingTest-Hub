import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 점 개수, 선분 개수
    public static int answer, nodeCount, lineCount;

    // 집합 배열
    public static int parent[];

    // find
    public static int find(int number) {

        // 자기 자신인 경우
        if(parent[number]==number)
            return number;

        return parent[number] = find(parent[number]);
    }

    // union
    public static void union(int number1, int number2) {

        // 집합 찾기
        number1 = find(number1);
        number2 = find(number2);

        // 집합 합치기
        if(number1<number2)
            parent[number2] = number1;
        else parent[number1] = number2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 점 개수, 확인 위치 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        lineCount = Integer.parseInt(st.nextToken());

        // 집합 배열 생성 및 초기화
        parent = new int[nodeCount];
        for(int node=0; node<nodeCount; node++)
            parent[node] = node;

        // 선분 입력
        for(int line=1; line<=lineCount; line++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 싸이클 여부 확인
            if(find(node1)==find(node2)) {
                answer = line;
                break;
            }

            //  합치기
            else union(node1,node2);
        }

        // 결과
        System.out.println(answer);
    }
}