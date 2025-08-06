import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 양동이 개수, 거리
    public static int bucketCount, distance;

    // 맵 배열
    public static int[] map;

    // 얼음 최댓값 구하기 메서드 - 1
    public static int calculateTotalSum() {
        int ice = 0;
        for(int weight: map) {
            ice += weight;
        }

        return ice;
    }

    // 얼음 최댓값 구하기 메서드 - 2
    public static int calculatePrefixSum() {

        // 누적합 구하기
        int prefixSum = map[0];
        for(int index=1; index<=distance*2; index++) {
            prefixSum += map[index];
        }

        int ice = prefixSum;

        for(int index=distance*2+1; index<map.length; index++) {
            prefixSum = prefixSum - map[index-distance*2-1] + map[index];
            ice = Math.max(ice, prefixSum);
        }

        return ice;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 양동이 개수, 거리 입력
        st = new StringTokenizer(br.readLine());
        bucketCount = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());

        // 맵 배열 생성
        map = new int[1000001];

        // 양동이 정보 입력
        for(int index=0; index<bucketCount; index++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            map[point] = weight;
        }

        // 얼음 최댓값 구하기
        int answer = distance>=1000000 ? calculateTotalSum() : calculatePrefixSum();

        // 결과 출력
        System.out.println(answer);
    }
}