import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 물병 클래스
class Bottle {
    private int a;
    private int b;
    private int c;

    public Bottle(int a,int b,int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getC() {
        return this.c;
    }
}

public class Main {

    // 물병
    public static int capacity[];
    // 방문 배열
    public static boolean visited[][][];
    // 이동 경우의 수 배열
    public static int start[] = {0,0,1,1,2,2};
    public static int end[] = {1,2,0,2,0,1};
    // 결과 리스트
    public static ArrayList<Integer> result;

    // 물 다 옮겨보기 함수
    static void bfs() {
        // 물병 탐색 큐
        Queue<Bottle> bottles = new LinkedList<>();
        // 첫 용량 넣기
        bottles.offer(new Bottle(0,0,capacity[2]));

        // 탐색 수행
        while(!bottles.isEmpty()) {

            // 현재 물 용량 확인
            Bottle curWater = bottles.poll();

            // 옮겨 담기
            for(int m=0; m<6; m++) {
                int curWaters[] = {curWater.getA(),curWater.getB(),curWater.getC()};
                int from = start[m];
                int to = end[m];

                // 물 담기
                curWaters[to] += curWaters[from];
                curWaters[from] = 0;

                // 물이 넘치는지 확인
                if(curWaters[to]>capacity[to]) {
                    int extra = curWaters[to]-capacity[to];
                    curWaters[to] = capacity[to];
                    curWaters[from] += extra;
                }

                // 방문 처리
                int nextA = curWaters[0];
                int nextB = curWaters[1];
                int nextC = curWaters[2];

                // 방문했던 경우
                if(visited[nextA][nextB][nextC])
                    continue;

                // 방문하지 않은 경우
                else {
                    visited[nextA][nextB][nextC] = true;
                    bottles.offer(new Bottle(nextA,nextB,nextC));

                    // 결과 조건에 맞을 경우
                    if(nextA==0) result.add(nextC);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 물병 만들기
        capacity = new int[3];

        // 물병 용량 입력
        st = new StringTokenizer(br.readLine());
        for(int b=0; b<3; b++) {
            capacity[b] = Integer.parseInt(st.nextToken());
        }

        // 물 다 옮겨보기
        visited = new boolean[201][201][201];
        result = new ArrayList<>();
        bfs();

        // 결과 출력
        Collections.sort(result);
        for(int element: result)
            System.out.print(element+" ");
    }
}