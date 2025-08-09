import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // 물탱크 수, 파이프 수, 방문 수
    public static int waterTankCount, pipeCount, visitCount;

    // 그룹 배열
    public static int[] parent;

    // 물탱크 배열
    public static int[] waterTanks;

    // 청정수 여부 배열
    public static int[][] isCleanWater;

    // find
    public static int find(int waterTank) {
        if(parent[waterTank] == waterTank) {
            return waterTank;
        }

        return parent[waterTank] = find(parent[waterTank]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 물탱크 수, 파이프 수, 방문 수 입력
        st = new StringTokenizer(br.readLine());
        waterTankCount = Integer.parseInt(st.nextToken());
        pipeCount = Integer.parseInt(st.nextToken());
        visitCount = Integer.parseInt(st.nextToken());

        // 물탱크 배열 생성
        waterTanks = new int[waterTankCount+1];

        // 그룹 배열 생성
        parent = new int[waterTankCount+1];
        for(int index=1; index<=waterTankCount; index++) {
            parent[index] = index;
        }

        // 물탱크 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=waterTankCount; index++) {
            waterTanks[index] = Integer.parseInt(st.nextToken());
        }

        // 파이프 정보 입력
        for(int index=0; index<pipeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        // 청정수 여부 배열 생성
        isCleanWater = new int[waterTankCount+1][3];

        // 그룹 저장 셋 생성
        HashSet<Integer> groups = new HashSet<>();

        // 그룹 확인
        for(int index=1; index<=waterTankCount; index++) {
            int group = find(index);
            int water = waterTanks[index];
            if(water == 1) isCleanWater[group][1]++;
            else isCleanWater[group][2]++;
            groups.add(group);
        }

        // 그룹 청정수 확인
        for(int group: groups) {
            if(isCleanWater[group][1] > isCleanWater[group][2]) {
                isCleanWater[group][0] = 1;
            }
        }

        // 물탱크 방문
        for(int index=0; index<visitCount; index++) {
            int group = parent[Integer.parseInt(br.readLine())];
            sb.append(isCleanWater[group][0]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}