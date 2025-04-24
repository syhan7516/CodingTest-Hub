import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 물통 클래스
class Bottle {
    int A;
    int B;
    int C;

    public Bottle(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public boolean isEmpty() {
        return A == 0;
    }
}

public class Main {

    // 물통 개수
    public static final int BOTTLE_COUNT = 3;

    // 물 최대 용량
    public static final int MAX_LITER = 200;

    // 물통 채우는 경우의 수
    public static final int CASE_COUNT = 6;

    // 물통 용량
    public static int[] maxBottle;

    // C용량 저장 리스트 생성
    public static ArrayList<Integer> capacities;

    // 큐
    public static Queue<Bottle> queue;

    // 방문 여부 배열
    public static boolean[][][] visited;

    // 물통 채우는 경우
    public static int[] from = {0,0,1,1,2,2};
    public static int[] to = {1,2,0,2,0,1};


    // 물통 채우기 메서드
    public static void solve() {

        // 물통 처음 상태 처리
        visited[0][0][maxBottle[2]] = true;
        queue.offer(new Bottle(0,0,maxBottle[2]));
        capacities.add(maxBottle[2]);

        // 물통 채우기
        while(!queue.isEmpty()) {

            // 현재 물통 상태
            Bottle currentBottle = queue.poll();

            // A가 0인 경우
            if(currentBottle.isEmpty() && !capacities.contains(currentBottle.C)) {
                capacities.add(currentBottle.C);
            }

            // 채울 수 있는 경우 확인
            for(int dir=0; dir<CASE_COUNT; dir++) {

                // 물 채울 준비
                int[] ABC = {currentBottle.A,currentBottle.B,currentBottle.C};
                int fromBottle = from[dir];
                int toBottle = to[dir];

                // 물 채우기
                ABC[toBottle] += ABC[fromBottle];
                ABC[fromBottle] = 0;

                // 물이 넘치는 경우
                if(ABC[toBottle]>maxBottle[toBottle]) {
                    ABC[fromBottle] = ABC[toBottle]-maxBottle[toBottle];
                    ABC[toBottle] = maxBottle[toBottle];
                }

                // 방문 여부 확인
                if(visited[ABC[0]][ABC[1]][ABC[2]]) continue;

                // 탐색 대상 추가
                visited[ABC[0]][ABC[1]][ABC[2]] = true;
                queue.offer(new Bottle(ABC[0],ABC[1],ABC[2]));
            }
        }
    }

    // 결과 저장 메서드
    public static String save() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(capacities);

        for(int index=0; index<capacities.size(); index++) {
            sb.append(capacities.get(index)).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 물통 용량 배열 생성
        maxBottle = new int[BOTTLE_COUNT];

        // 물통 정보 입력
        st = new StringTokenizer(br.readLine());
        maxBottle[0] = Integer.parseInt(st.nextToken());
        maxBottle[1] = Integer.parseInt(st.nextToken());
        maxBottle[2] = Integer.parseInt(st.nextToken());

        // 방문 여부 배열 생성
        visited = new boolean[MAX_LITER+1][MAX_LITER+1][MAX_LITER+1];

        // 큐 생성
        queue = new LinkedList<>();

        // C용량 저장 리스트 생성
        capacities = new ArrayList<>();

        // 물통 채우기
        solve();

        // 결과 출력
        System.out.println(save());
    }
}