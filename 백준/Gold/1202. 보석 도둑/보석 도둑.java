import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 보석 클래스
class Jewelry {
    int weight;
    int price;

    public Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class Main {

    // 보석 가격의 합
    public static long answer;

    // 보석 개수, 가방 개수
    public static int meterialCnt, bagCnt;

    // 가방 무게 배열
    public static int bags[];

    // 보석 배열
    public static Jewelry jewelry[];

    // 가방 넣기 우선 순위 큐
    public static PriorityQueue<Jewelry> queue;

    // 보석 담기 메서드
    static void solve() {

        int idx = 0;

        // 가방 확인
        for(int i=0; i<bagCnt; i++) {

            // 현재 가방에서 가장 비싼 보석 확인
            while(idx<meterialCnt && jewelry[idx].weight<=bags[i]) {
                queue.add(jewelry[idx]);
                idx++;
            }

            if(!queue.isEmpty())
                answer += queue.poll().price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보석, 가방 개수 입력
        st = new StringTokenizer(br.readLine());
        meterialCnt = Integer.parseInt(st.nextToken());
        bagCnt = Integer.parseInt(st.nextToken());

        // 보석 우선 순위 큐, 가방 넣기 우선 순위 큐 생성
        jewelry = new Jewelry[meterialCnt];
        queue = new PriorityQueue<>((g1, g2)-> Integer.compare(g2.price, g1.price));

        // 보석 정보 입력
        for(int i=0; i<meterialCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelry[i] = new Jewelry(weight,price);
        }

        // 가방 무게 배열 생성
        bags = new int[bagCnt];

        // 가방 무게 입력
        for(int i=0; i<bagCnt; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 무게 정렬
        Arrays.sort(bags);
        Arrays.sort(jewelry, (g1, g2)-> Integer.compare(g1.weight, g2.weight));

        // 보석 담기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}