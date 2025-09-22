import java.io.*;
import java.util.*;

public class Main {

    // 결과
    public static long answer;

    // 노드 개수
    public static int nodeCount;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 배열
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 노드 개수 입력
        nodeCount = Integer.parseInt(br.readLine());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=2; index<=nodeCount; index++) {
            int node = Integer.parseInt(st.nextToken());
            relations.get(node).add(index);
        }

        // 배열 생성
        nums = new int[nodeCount+1];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=nodeCount; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
        }

        // 우선 순위 큐 생성
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        queue.offer(new int[]{nums[1], 1});

        // 탐색
        answer = 0;
        while(!queue.isEmpty()) {
            int[] currentNums = queue.poll();
            long num = currentNums[0];
            int node = currentNums[1];

            answer += num;
            sb.append(answer).append("\n");

            // 순회
            for(int next: relations.get(node)) {
                queue.offer(new int[]{nums[next], next});
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}