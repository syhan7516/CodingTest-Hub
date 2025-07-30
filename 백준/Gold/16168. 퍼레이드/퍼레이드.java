import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // 노드 개수, 경로 개수
    public static int nodeCount, edgeCount;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 차수 저장 배열
    public static int[] degrees;

    // 그룹 배열
    public static int[] parent;

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

    // 그룹 개수 확인 메서드
    public static int getGroupCount() {
        HashSet<Integer> set = new HashSet<>();
        for(int index=1; index<=nodeCount; index++) {
            find(index);
            set.add(parent[index]);
        }

        return set.size();
    }

    // 경로 가능 여부 확인 메서드
    public static boolean canParade() {
        int oddCount = 0;
        for(int index=1; index<=nodeCount; index++) {
            if(degrees[index]%2==1) oddCount++;
        }

        return oddCount==0 || oddCount==2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노드 개수, 경로 개수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 그룹 배열 생성
        parent = new int[nodeCount+1];
        for(int index=1; index<=nodeCount; index++) {
            parent[index] = index;
        }

        // 차수 정보 배열 생성
        degrees = new int[nodeCount+1];

        // 연결 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if(relations.get(from).contains(to)) continue;
            relations.get(from).add(to);
            relations.get(to).add(from);
            degrees[from]++;
            degrees[to]++;
            union(from, to);
        }

        // 그룹 개수 확인
        if(getGroupCount()==1) {

            // 경로 가능 여부 확인
            if(canParade()) System.out.println("YES");
            else System.out.println("NO");
        }
        
        else System.out.println("NO");
    }
}