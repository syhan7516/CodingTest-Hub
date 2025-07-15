import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 사람 수, 관계 수
    public static int answer, saramCount, relationCount;

    // 적 정보 저장 배열
    public static int[] enemy;

    // 그룹 번호 저장 배열
    public static int[] parent;

    // find
    public static int find(int saram) {
        if(parent[saram] == saram) {
            return saram;
        }

        return parent[saram] = find(parent[saram]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수, 관계 수 입력
        st = new StringTokenizer(br.readLine());
        saramCount = Integer.parseInt(st.nextToken());
        relationCount = Integer.parseInt(st.nextToken());

        // 그룹 배열 생성 및 초기화
        parent = new int[saramCount+1];
        for(int index=1; index<=saramCount; index++) {
            parent[index] = index;
        }

        // 적 정보 저장 배열 생성
        enemy = new int[saramCount+1];

        // 관계 정보 입력
        answer = 1;
        for(int relation=0; relation<relationCount; relation++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 적인데 같은 그룹인 경우
            if(find(a) == find(b)) {
                answer = 0;
                break;
            }

            // a가 적이 없는 경우
            if(enemy[a] == 0) {
                enemy[a] = b;
            }

            // a가 적이 있는 경우
            else {
                union(enemy[a],b);
            }

            // b가 적이 없는 경우
            if(enemy[b] == 0) {
                enemy[b] = a;
            }

            // b가 적이 있는 경우
            else {
                union(enemy[b],a);
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}