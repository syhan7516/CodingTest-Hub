import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    // 자연수 개수
    public static int numCnt;

    // 자연수 정보 배열
    public static int nums[];

    // 두 수의 합 저장 리스트
    public static List<Integer> sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자연수 개수 입력
        numCnt = Integer.parseInt(br.readLine());

        // 자연수 정보 배열 생성
        nums = new int[numCnt];

        // 두 수 합 정보 리스트 생성
        sum = new ArrayList<>();

        // 자연수 정보 입력
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 두 수의 합 구하기
        for(int i=0; i<numCnt; i++) {
            for(int j=0; j<numCnt; j++) {
                sum.add(nums[i]+nums[j]);
            }
        }

        // 정렬
        Arrays.sort(nums);
        Collections.sort(sum);

        // x+y = k-z 구하기
        for(int i=numCnt-1; i>=0; i--) {
            for(int j=numCnt-1; j>=0; j--) {

                // k-z
                int minus = nums[i]-nums[j];

                // k-z 찾기
                if(Collections.binarySearch(sum,minus)>=0) {
                    System.out.println(nums[i]);
                    return;
                }
            }
        }
    }
}