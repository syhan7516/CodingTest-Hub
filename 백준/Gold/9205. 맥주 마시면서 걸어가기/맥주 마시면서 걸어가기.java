import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    // 편의점 위치 배열
    public static Node store[];

    // 편의점 방문 여부 배열
    public static boolean visited[];

    // 맥주 마시면서 걸어가기 메서드
    static String solve(int startX, int startY, int endX, int endY) {

        // 거리 탐색 큐
        Queue<Node> queue = new LinkedList<>();

        // 출발점 처리
        queue.offer(new Node(startX,startY));

        // 걸어가기
        while(!queue.isEmpty()) {

            // 현재 위치 좌표
            Node current = queue.poll();

            // 페스티벌에 도착한 경우
            if(1000>=(Math.abs(current.x-endX)+Math.abs(current.y-endY)))
                return "happy";

            // 거리 확인
            for(int i=0; i<store.length; i++) {

                // 이동 불가능한 경우
                if(1000<(Math.abs(store[i].x- current.x)+Math.abs(store[i].y- current.y))) continue;

                // 방문한 경우
                if(visited[i]) continue;

                // 이동 가능한 경우
                queue.offer(new Node(store[i].x,store[i].y));
                visited[i] = true;
            }
        }

        return "sad";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 편의점 개수 입력
            int storeCnt = Integer.parseInt(br.readLine());

            // 편의점 위치 배열 생성
            store = new Node[storeCnt];

            // 상근이네 집 위치 입력
            st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());

            // 편의점 위치 입력
            for(int i=0; i<storeCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                store[i] = new Node(x,y);
            }

            // 페스티벌 위치 입력
            st = new StringTokenizer(br.readLine());
            int festivalX = Integer.parseInt(st.nextToken());
            int festivalY = Integer.parseInt(st.nextToken());
            
            // 맥주 마시면서 걸어가기
            visited = new boolean[storeCnt];
            sb.append(solve(homeX,homeY,festivalX,festivalY)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}
