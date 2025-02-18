import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 개수 입력
        int numCount = Integer.parseInt(br.readLine());

        // 숫자 저장 배열 생성
        int nums[] = new int[numCount];

        // 숫자 정보 입력
        for(int index=0; index<numCount; index++) {
            nums[index] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(nums);

        // 세 변 길이 확인
        int answer = -1;
        for(int index=nums.length-1; index>=2; index--) {
            if(nums[index]<nums[index-1]+nums[index-2]) {
                answer = nums[index]+nums[index-1]+nums[index-2];
                break;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}