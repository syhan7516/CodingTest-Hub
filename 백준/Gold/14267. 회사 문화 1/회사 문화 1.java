import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Integer>> graph = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            graph.get(parent).add(i);
        }

        // 칭찬 초기화
        int[] answer = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            answer[node] += weight;
        }

        // DFS
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 0});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int curNode = cur[0];
            int curWeight = answer[curNode];
            int totalWeight = cur[1];
            answer[curNode] += totalWeight;
            for (int nextNode : graph.get(curNode)) {
                stack.push(new int[]{nextNode, curWeight + totalWeight});
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
