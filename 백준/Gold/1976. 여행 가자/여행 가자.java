import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 도시의 수
    public static int cityCnt, planCityCnt;
    // 도시
    public static int city[][];
    // 도시 연결 정보
    public static int parent[];

    // 대표 번호 찾기
    static int find(int node) {
        if(parent[node]==node)
            return node;

        return parent[node] = find(parent[node]);
    }

    // 도시 연결
    static void union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        parent[rootB] = rootA;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 수 입력
        cityCnt = Integer.parseInt(br.readLine());

        // 여행할 도시 수 입력
        planCityCnt = Integer.parseInt(br.readLine());

        // 대표 테이플 초기화
        parent = new int[cityCnt+1];
        for(int idx=1; idx<=cityCnt; idx++)
            parent[idx] = idx;

        // 도시 연결 정보 입력
        city = new int[cityCnt+1][cityCnt+1];
        for(int row=1; row<=cityCnt; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=1; col<=cityCnt; col++) {
                city[row][col] = Integer.parseInt(st.nextToken());
                if(city[row][col]==1)
                    union(row,col);
            }
        }

        // 계획 도시 정보 입력
        int checkCity[] = new int[planCityCnt];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<checkCity.length; idx++) {
            checkCity[idx] = Integer.parseInt(st.nextToken());
        }

        // 계획 도시 확인
        boolean flag = true;
        int result = find(checkCity[0]);
        for(int idx=1; idx<checkCity.length; idx++) {
            if(find(checkCity[idx-1])!=find(checkCity[idx]))
                flag = false;
        }

        // 결과 출력
        if(flag==true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
