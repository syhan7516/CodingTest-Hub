import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 보석 클래스
class Jewel {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    // 결과
    public static long answer;

    // 보석 개수, 가방 개수
    public static int jewelCount, bagCount;

    // 보석 배열
    public static Jewel[] jewels;

    // 가방 배열
    public static int bags[];

    // 보석 훔치기 메서드
    public static void solve() {

        // 가방 가벼운 순으로 정렬
        Arrays.sort(bags);

        // 보석 저장 우선 순위 큐 생성
        PriorityQueue<Jewel> queue = new PriorityQueue<>((a,b) -> b.value - a.value);

        // 보석 가벼운 순으로 정렬
        Arrays.sort(jewels, (a,b) -> Integer.compare(a.weight, b.weight));

        // 보석 위치
        int index = 0;

        // 가방 순회
        for(int bag=0; bag<bagCount; bag++) {

            // 가방 무게에 가능한 보석 확인
            while(index<jewelCount && jewels[index].weight<=bags[bag]) {
                queue.offer(jewels[index]);
                index++;
            }

            // 가장 큰 비용의 보석 꺼내기
            if(!queue.isEmpty()) {
                answer += queue.poll().value;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보석, 가방 개수 입력
        st = new StringTokenizer(br.readLine());
        jewelCount = Integer.parseInt(st.nextToken());
        bagCount = Integer.parseInt(st.nextToken());

        // 배열 생성
        jewels = new Jewel[jewelCount];
        bags = new int[bagCount];

        // 보석 정보 입력
        for(int index=0; index<jewelCount; index++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[index] = new Jewel(weight,value);
        }

        // 가방 정보 입력
        for(int index=0; index<bagCount; index++) {
            bags[index] = Integer.parseInt(br.readLine());
        }

        // 보석 훔치기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}