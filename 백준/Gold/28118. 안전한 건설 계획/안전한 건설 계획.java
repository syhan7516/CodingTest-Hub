import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 노드 수, 간선 수
    public static int answer, nodeCount, edgeCount;

    // 그룹 배열
    public static int[] ranks;

    // find
    public static int find(int node) {
        if(ranks[node] < 0) {
            return node;
        }

        return ranks[node] = find(ranks[node]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        if(a < b) {
            ranks[a] += ranks[b];
            ranks[b] = a;
        } 
        else {
            ranks[b] += ranks[a];
            ranks[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 노드 수, 간선 수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());

        // 그룹 배열 생성
        ranks = new int[nodeCount+1];
        Arrays.fill(ranks, -1);

        // 간선 정보 입력
        for(int index=0; index<edgeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        // 그룹 확인
        for(int node=1; node<=nodeCount; node++) {
            if(ranks[node] < 0) {
                answer++;
            }
        }

        // 결과 출력
        System.out.println(answer-1);
    }
}