import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 노드 클래스
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 사각형의 크기, 단지 수, 각 단지 크기
    public static int size, townNum, townArea;

    // 단지 리스트
    public static ArrayList<Integer> areas;

    // 사각형
    public static int square[][];

    // 방향 벡터
    public static int dy[] = {1,0,-1,0};
    public static int dx[] = {0,-1,0,1};

    // 노드 큐
    public static Queue<Node> queue;

    // 단지 탐색
    static void solve(int row, int col) {

        // 큐 생성
        queue = new LinkedList<>();

        // 첫 노드
        queue.offer(new Node(row,col));
        square[row][col] = townNum;
        townArea++;

        // 탐색
        while(!queue.isEmpty()) {

            // 기준 집
            Node curNode = queue.poll();

            // 주위 확인
            for(int d=0; d<4; d++) {
                int ny = curNode.y+dy[d];
                int nx = curNode.x+dx[d];

                // 범위 확인
                if(ny<0 || ny>size-1 || nx<0 || nx>size-1)
                    continue;

                // 집이 없거나 이미 방문한 경우
                if(square[ny][nx]!=1)
                    continue;

                queue.offer(new Node(ny,nx));
                square[ny][nx] = townNum;
                townArea++;
            }
        }

        // 단지 수 저장
        areas.add(townArea);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사각형 크기 입력
        size = Integer.parseInt(br.readLine());

        // 사각형 생성
        square = new int[size][size];

        // 단지 크기 넓이 리스트
        areas = new ArrayList<>();

        // 사각형 정보 입력
        for(int i=0; i<size; i++) {
            String line = br.readLine();
            for(int j=0; j<size; j++) {
                square[i][j] = line.charAt(j)-'0';
            }
        }

        // 단지 탐색
        townNum = 2;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {

                // 집인 경우
                if(square[i][j]==1) {
                    townArea = 0;
                    townNum++;
                    solve(i,j);
                }
            }
        }

        System.out.println(townNum-2);
        Collections.sort(areas);
        for(int i=0; i<areas.size(); i++)
            System.out.println(areas.get(i));
    }
}