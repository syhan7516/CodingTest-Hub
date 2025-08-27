import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 전선 클래스
class Line implements Comparable<Line> {
    int node;
    int time;

    public Line(int node, int time) {
        this.node = node;
        this.time = time;
    }

    @Override
    public int compareTo(Line other) {
        return this.time - other.time;
    }
}

public class Main {

    // 컴퓨터 수, 전선 수
    public static int computerCount, lineCount;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Line>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 최단 거리 배열
    public static int[] path;

    // 최단 거리 구하기 메서드
    public static int solve(int computer) {

        // 거리 총합
        int totalTime = 0;

        // 우선 순위 큐 생성
        PriorityQueue<Line> queue = new PriorityQueue<>();

        // 방문 여부 배열 생성
        visited = new boolean[computerCount+1];

        // 최단 거리 배열 생성
        path = new int[computerCount+1];
        Arrays.fill(path,  (int)1e9);
        path[computer] = 0;

        // 시작 지점 처리
        queue.offer(new Line(computer, path[computer]));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 컴퓨터
            Line line = queue.poll();

            // 이미 방문한 경우
            if(visited[line.node]) continue;

            // 방문 처리
            totalTime += path[line.node];
            visited[line.node] = true;

            // 연결 정보 확인
            for(int node=0; node<relations.get(line.node).size(); node++) {
                Line connectedLine = relations.get(line.node).get(node);

                // 이미 방문한 경우
                if(visited[connectedLine.node]) continue;

                // 최단 거리인 경우
                if(path[connectedLine.node] > path[line.node] + connectedLine.time) {
                    path[connectedLine.node] = path[line.node] + connectedLine.time;
                    queue.offer(new Line(connectedLine.node, path[connectedLine.node]));
                }
            }
        }

        return totalTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 컴퓨터 수, 전선 수 입력
        st = new StringTokenizer(br.readLine());
        computerCount = Integer.parseInt(st.nextToken());
        lineCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=computerCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        for(int edge=0; edge<lineCount; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            relations.get(from).add(new Line(to, time));
            relations.get(to).add(new Line(from, time));
        }

        // 최단 거리 구하기
        int[] answer = {0, (int)1e9};
        for(int node=1; node<=computerCount; node++) {
            int shortestPathTime = solve(node);
            if(answer[1] > shortestPathTime) {
                answer[1] = shortestPathTime;
                answer[0] = node;
            }
        }

        // 결과 출력
        System.out.println(answer[0]);
    }
}