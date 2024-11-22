import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 장소 수, 전체 꿀
    public static int answer, areaCount, totalHoney;

    // 꿀 배열, 왼쪽 누적합 배열, 오른쪽 누적합 배열
    public static int[] honey, leftPrefixSum, rightPrefixSum;

    // 벌 양쪽 배치 메서드
    public static int side() {

        // 최대 수확 정도
        int maxHoney = 0;

        // 꿀통 이동
        for(int area=1; area<areaCount-1; area++) {

            // 수확 꿀
            int sum = leftPrefixSum[area]-leftPrefixSum[0]+rightPrefixSum[area]-rightPrefixSum[areaCount-1];
            maxHoney = Math.max(maxHoney,sum);
        }

        return maxHoney;
    }

    // 벌 왼쪽 배치 메서드
    public static int left() {

        // 최대 수확 정도
        int maxHoney = 0;

        // 고정 수확 꿀
        int fixDegree = leftPrefixSum[areaCount-1]-leftPrefixSum[0];

        // 벌 이동
        for(int area=1; area<areaCount-1; area++) {

            // 수확 꿀
            int sum = leftPrefixSum[areaCount-1]-leftPrefixSum[area]+fixDegree-honey[area];
            maxHoney = Math.max(maxHoney,sum);
        }

        return maxHoney;
    }

    // 벌 오른쪽 배치 메서드
    public static int right() {

        // 최대 수확 정도
        int maxHoney = 0;

        // 고정 수확 꿀
        int fixDegree = rightPrefixSum[0]-rightPrefixSum[areaCount-1];

        // 꿀통 이동
        for(int area=areaCount-2; area>0; area--) {
            
            // 수확 꿀
            int sum = rightPrefixSum[0]-rightPrefixSum[area]+fixDegree-honey[area];
            maxHoney = Math.max(maxHoney,sum);
        }

        return maxHoney;
    }
    
    // 꿀 따기 메서드
    public static void solve() {
        
        // 벌 양쪽 배치 - 벌통이 이동하는 경우
        answer = Math.max(answer,side());
        
        // 벌 왼쪽 배치 - 벌이 오른쪽으로 이동하는 경우 
         answer = Math.max(answer,left());

        // 벌 오른쪽 배치 - 벌이 왼쪽으로 이동하는 경우
        answer = Math.max(answer,right());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 장소 수 입력
        st = new StringTokenizer(br.readLine());
        areaCount = Integer.parseInt(st.nextToken());

        // 꿀 배열 생성
        honey = new int[areaCount];

        // 누적합 배열 생성
        leftPrefixSum = new int[areaCount];
        rightPrefixSum = new int[areaCount];

        // 꿀 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<areaCount; index++)
            honey[index] = Integer.parseInt(st.nextToken());

        // 누적합 구하기
        leftPrefixSum[0] = honey[0];
        rightPrefixSum[areaCount-1] = honey[areaCount-1];

        for(int index=1; index<areaCount; index++)
            leftPrefixSum[index] = leftPrefixSum[index-1]+honey[index];

        for(int index=areaCount-2; index>=0; index--)
            rightPrefixSum[index] = rightPrefixSum[index+1]+honey[index];

        // 꿀 따기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}