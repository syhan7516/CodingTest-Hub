import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] party;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken()); // 사람의 수
        m = Integer.parseInt(stk.nextToken()); // 파티의 수
        int k; // 진실을 아는 사람의 수
        stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        int[] true_man = new int[k];
        for (int i = 0; i < k; i++) {
            true_man[i] = Integer.parseInt(stk.nextToken());
        } // 진실을 아는 사람의 번호를 저장

        parent = new int[n + 1];
        party = new ArrayList[m];
        for (int i = 0; i < m; i++) { // 파티의 수 만큼
            party[i] = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < party_size; j++) {
                party[i].add(Integer.parseInt(stk.nextToken()));
            }
        }

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int first_man = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first_man, party[i].get(j));
            } // 각각의 파티에 참석한 인원들은 같은 집합으로 분류함
        }
        // parent 배열을 순회하며 진실을 아는 사람들과 다른 집합으로 분류되어 있다면
        // 해당 사람들의 개수를 더해서 출력하면 됨
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int leader = party[i].get(0);
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if (isitsame(leader, true_man[j])) {
                    // 진실을 아는 사람과 같은 집합에 속한다면
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // 진실을 아는 사람과 같은 집합에 속하지 않는다면
                // 해당 파티에서는 거짓말을 해도 들키지 않음
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            // a 와 b 가 다른 집합에 속한다면
            parent[b] = a; // 같은 집합으로 묶어주기
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            // a 의 부모가 a 이면(root)
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean isitsame(int a, int b) {
        if (find(a) == find(b)) { // 같은 집합에 속한다면 true
            return true;
        } else return false;
    }
}