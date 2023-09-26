import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 수열의 크기
    public static int size;

    // 수열 배열, 길이 배열
    public static int nums[], DP[];

    // 자리 구하기 메서드
    static int getSearch(int start, int end, int target) {

        // 삽입될 위치
        int insertIdx = -1;

        // 위치 확인
        while(start<=end) {

            // 중간 인덱스 값
            int mid = (start+end)/2;

            // 값이 같은 경우
            if(DP[mid]==target)
                return 0;

            // 값이 더 작은 경우
            else if(DP[mid]<target) {
                start = mid+1;
            }

            // 값이 더 큰 경우
            else {
                insertIdx = mid;
                end = mid-1;
            }
        }

        return insertIdx;
    }

    // 가장 긴 증가하는 부분 수열 구하기 메서드
    static int solve() {

        // 현재 길이
        int idx = 1;

        // 초기 값 넣기
        DP[1] = nums[0];

        // 모든 수 확인하기
        for(int i=1; i<size; i++) {

            // 확인 수가 가장 작은 경우
            if(DP[1]>nums[i])
                DP[1] = nums[i];

            // 확인 수가 가장 큰 경우
            else if(DP[idx]<nums[i])
                DP[++idx] = nums[i];

            // 아닌 경우
            else {

                // 삽입될 자리 구하기
                int point = getSearch(1,idx,nums[i]);

                // 갱신
                DP[point] = nums[i];
            }
        }

        return idx;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 수열의 크기 입력
        size = Integer.parseInt(br.readLine());

        // 수열 배열, 길이 배열 생성
        nums = new int[size];
        DP = new int[size+1];

        // 수열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 긴 증가하는 부분 수열 구하기
        int result = solve();

        // 결과 출력
        System.out.println(result);
    }
}