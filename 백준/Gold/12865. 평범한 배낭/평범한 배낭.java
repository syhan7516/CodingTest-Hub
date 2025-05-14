import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 물건 클래스
class Thing {
    int weight;
    int value;

    public Thing(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    // 물건 개수, 가방 무게
    public static int thingCount, maxWeight;

    // 물건 정보 배열
    public static Thing[] things;

    // 무게별 최대 가치 저장 배열
    public static int[][] DP;

    // 물건 담기 메서드
    public static void solve() {

        // 물건 확인
        for(int thingIndex=1; thingIndex<=thingCount; thingIndex++) {

            // 할당 무게 확인
            for(int weight=0; weight<=maxWeight; weight++) {

                // 현재 물건을 담을 수 있는 경우
                if(things[thingIndex].weight<=weight) {

                    // 물건을 담을 때와 담지 않을 때 비교
                    DP[thingIndex][weight] = Math.max(DP[thingIndex-1][weight],
                            DP[thingIndex-1][weight-things[thingIndex].weight]+things[thingIndex].value);
                }

                // 물건을 담지 못하는 경우
                else {
                    DP[thingIndex][weight] = DP[thingIndex-1][weight];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 물건 개수, 가방 무게 입력
        st = new StringTokenizer(br.readLine());
        thingCount = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt(st.nextToken());

        // 물건 정보 배열 생성
        things = new Thing[thingCount+1];

        // 물건 정보 입력
        for(int thingIndex=0; thingIndex<thingCount; thingIndex++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            things[thingIndex+1] = new Thing(weight,value);
        }

        // 무게별 최대 가치 저장 배열 생성
        DP = new int[thingCount+1][maxWeight+1];

        // 물건 담기
        solve();

        // 결과 출력
        System.out.println(DP[thingCount][maxWeight]);
    }
}