import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    // 숫자 개수, 합 횟수,
    public static int numCnt, sumCnt;
    // 시작 인덱스, 끝 인덱스, 결과
    public static int startIdx, endIdx, result;
    // 숫자 정보 배열, 누적합 배열
    public static int[] nums, prefixSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 숫자 개수 입력
        numCnt = Integer.parseInt(st.nextToken());

        // 합을 구해야하는 횟수 입력
        sumCnt = Integer.parseInt(st.nextToken());

        // 숫자 정보 입력
        nums = new int[numCnt+1];
        st = new StringTokenizer(br.readLine());
        for(int n=1; n<=numCnt; n++) {
            nums[n] = Integer.parseInt(st.nextToken());
        }

        // 누적된 합 구하기
        prefixSum = new int[numCnt+1];
        prefixSum[1] = nums[1];
        for(int p=2; p<=numCnt; p++) {
            prefixSum[p] = prefixSum[p-1] + nums[p];
        }

        // i번째 수부터 j번째 수까지 합 구하기
        for(int idx=0; idx<sumCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            startIdx = Integer.parseInt(st.nextToken());
            endIdx = Integer.parseInt(st.nextToken());
            result = prefixSum[endIdx]-prefixSum[startIdx]+nums[startIdx];

            // 결과 저장
            sb.append(result+"\n");
        }

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}