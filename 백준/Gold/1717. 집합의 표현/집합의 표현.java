import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 집합의 수, 연산의 개수
    public static int numCnt, operationCnt;

    // 대표 번호 배열
    public static int parent[];

    // find
    static int find(int number) {

        // 자기 자신의 경우
        if(parent[number]==number)
            return number;

        // 아닌 경우
        return parent[number] = find(parent[number]);
    }

    // union
    static void union(int a, int b) {

        int n1 = find(a);
        int n2 = find(b);

        if(n1<n2) parent[n2] = n1;
        else parent[n1] = n2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 집합의 수, 연산의 개수 입력
        st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        operationCnt = Integer.parseInt(st.nextToken());

        // 대표 번호 배열 생성
        parent = new int[numCnt+1];
        for(int i=0; i<=numCnt; i++)
            parent[i] = i;

        // 연산 수행
        for(int i=1; i<=operationCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 합하는 경우
            if(a==0) {
                union(b,c);
            }

            // 포함여부 확인의 경우
            else {
                if(find(b)==find(c))
                    sb.append("yes");
                else
                    sb.append("no");

                sb.append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}