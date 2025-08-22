import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 블록 클래스
class Block {
    int blockNum;
    int count;

    public Block(int blockNum, int count) {
        this.blockNum = blockNum;
        this.count = count;
    }
}

public class Main {

    // 결과, 블록 개수, 빨강 얼음 개수, 펭귄 위치
    public static int answer, blockCount, redIceCount, penguin;

    // 블록 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static boolean[] visited;

    // 탐색 수행 메서드
    public static void solve() {

        // 연결된 지지대 블록 개수
        int connectedRedIceCount = 0;

        // 블록 저장 큐 생성
        Queue<Block> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[blockCount+1];

        // 시작 지점 처리
        visited[penguin] = true;
        queue.offer(new Block(penguin, 1));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 얼음
            Block block = queue.poll();

            // 지지대인 경우
            if(block.blockNum <= redIceCount) {
                connectedRedIceCount++;
                answer += block.count;
            }

            // 지지대가 2개 연결된 경우
            if(connectedRedIceCount == 2) return;

            // 연결 정보 확인
            for(int index=0; index<relations.get(block.blockNum).size(); index++) {
                int connectedBlock = relations.get(block.blockNum).get(index);

                // 이미 방문한 경우
                if(visited[connectedBlock]) continue;

                // 처리
                visited[connectedBlock] = true;
                queue.offer(new Block(connectedBlock,block.count+1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 블록 개수, 빨강 얼음 개수, 펭귄 위치 입력
        st = new StringTokenizer(br.readLine());
        blockCount = Integer.parseInt(st.nextToken());
        redIceCount = Integer.parseInt(st.nextToken());
        penguin = Integer.parseInt(st.nextToken());

        // 블록 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=blockCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 블록 연결 정보 입력
        for(int index=0; index<blockCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
            relations.get(to).add(from);
        }

        // 방문 여부 배열 생성
        visited = new boolean[blockCount+1];
        solve();

        // 결과 출력
        System.out.println(blockCount - answer + 1);
    }
}