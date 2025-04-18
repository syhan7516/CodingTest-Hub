import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 마을 클래스
class Town {
    int point;
    int count;

    public Town(int point, int count) {
        this.point = point;
        this.count = count;
    }
}

public class Main {

    // 마을 수
    public static int townCount;

    // 사람 수
    public static long totalCount, halfCount;

    // 마을 배열
    public static Town[] towns;

    // 사람들 거리 확인 메서드
    public static int solve() {

        // 선정된 마을
        int answer = 0;

        // 확인 사람 수
        long currentCount = 0;

        // 마을 순회하며, 거리 확인
        for(int townIndex=0; townIndex<townCount; townIndex++) {

            // 해당 마을 사람 수 더하기
            currentCount += towns[townIndex].count;

            // 사람 절반이거나, 넘게되는 마을인 경우
            if(currentCount>=halfCount) {
                answer = towns[townIndex].point;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 마을 수 입력
        townCount = Integer.parseInt(br.readLine());

        // 마을 배열
        towns = new Town[townCount];

        // 전체 사람 수
        totalCount = 0;

        // 마을 정보 입력
        for(int townIndex=0; townIndex<townCount; townIndex++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            towns[townIndex] = new Town(point,count);
            totalCount += count;
        }

        // 정렬
        Arrays.sort(towns, (a,b) -> a.point - b.point);

        // 사람들 거리 확인
        halfCount = totalCount%2==0 ? totalCount/2 : totalCount/2+1;
        System.out.println(solve());
    }
}