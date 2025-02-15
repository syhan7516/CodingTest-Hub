import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 존재 여부 확인 메서드
    public static boolean solve(int nums[], int number) {

        // 범위 설정
        int left = 0;
        int right = nums.length-1;

        // 존재 여부 탐색
        while(left<=right) {

            // 값 설정
            int mid = (left+right)/2;

            // 값을 찾은 경우
            if(nums[mid]==number) return true;

            // 값보다 작은 경우
            else if(nums[mid]<number)
                left = mid+1;

            // 값보다 큰 경우
            else right = mid-1;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 보유한 수 개수 입력
        int count = Integer.parseInt(br.readLine());

        // 보유 수 저장 배열 생성
        int nums[] = new int[count];

        // 보유 수 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<count; index++) {
            nums[index] = Integer.parseInt(st.nextToken());
        }

        // 보유 수 정렬
        Arrays.sort(nums);

        // 확인 수 개수 입력
        int checkCount = Integer.parseInt(br.readLine());

        // 확인 수 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<checkCount; index++) {

            // 확인 수
            int checkNum = Integer.parseInt(st.nextToken());

            // 존재 여부 확인
            if(solve(nums,checkNum)) sb.append(1);
            else sb.append(0);

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}