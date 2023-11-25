import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 섬의 수
    public static int landCnt;

    // 대표 번호 배열
    public static int parent[];

    // find
    static int find(int number) {

        // 자기 자신일 경우
        if(parent[number]==number) {
            return number;
        }

        // 아닐 경우
        return parent[number] = find(parent[number]);

    }

    // union
    static void union(int a, int b) {

        int n1 = find(a);
        int n2 = find(b);

        if(n1!=n2) {

            if(n1<n2)
                parent[n2] = n1;
            else
                parent[n1] = n2;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 섬의 수 입력
        landCnt = Integer.parseInt(br.readLine());

        // 초기 작업
        parent = new int[landCnt+1];
        for(int i=1; i<=landCnt; i++)
            parent[i] = i;

        // 다리 정보 입력
        for(int i=0; i<landCnt-2; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from,to);
        }

        int pre = 1;
        for(int i=2; i<=landCnt; i++) {
            if(find(pre)!=find(i)) {
                System.out.println(pre+" "+i);
                break;
            }
        }
    }
}