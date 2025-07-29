import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static long answer;

    // 교육생 수, 관계 수
    public static int studentCount, relationCount;

    // 그룹 배열
    public static int[] parent;

    // 그룹 인원 저장 배열
    public static int[] students;

    // find
    public static int find(int num) {
        if(parent[num] == num) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 경우의 수 구하기 메서드
    public static void solve() {

        // 그룹 인원 확인
        for(int index=1; index<=studentCount; index++) {
            int group = find(index);
            students[group]++;
        }

        for(int index=1; index<=studentCount; index++) {
            if(students[index] > 0) {
                answer = (answer * students[index]) % 1000000007;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 교육생 수, 관계 수 입력
        st = new StringTokenizer(br.readLine());
        studentCount = Integer.parseInt(st.nextToken());
        relationCount = Integer.parseInt(st.nextToken());

        // 그룹 배열, 그룹 인원 저장 배열 생성
        parent = new int[studentCount+1];
        students = new int[studentCount+1];
        for(int index=1; index<=studentCount; index++) {
            parent[index] = index;
        }

        // 관계 정보 입력
        for(int index=0; index<relationCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        // 경우의 수 구하기
        answer = 1;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}