import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 은하 수, 연결 수
    public static int galaxyCount, roadCount;

    // 그룹 배열
    public static int[] groups;

    // 그룹별 은하의 수 저장 배열
    public static int[] count;

    // find
    public static int find(int galaxy) {
        if(groups[galaxy] == galaxy) {
            return galaxy;
        }

        return groups[galaxy] = find(groups[galaxy]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) {
            groups[b] = a;
            count[a] += count[b];
        }

        else {
            groups[a] = b;
            count[b] += count[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 은하 수, 연결 수 입력
        st = new StringTokenizer(br.readLine());
        galaxyCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());

        // 그룹 배열 생성
        groups = new int[galaxyCount+1];
        for(int index=1; index<=galaxyCount; index++) {
            groups[index] = index;
        }

        // 그룹별 은하의 수 저장 배열 생성
        count = new int[galaxyCount+1];

        // 은하 정보 입력
        for(int index=1; index<=galaxyCount; index++) {
            count[index] = Integer.parseInt(br.readLine());
        }

        // 연결 정보 입력
        for(int index=0; index<roadCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(find(from) != find(to)) {
                union(from, to);
            }

            sb.append(count[Math.min(find(from), find(to))]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}