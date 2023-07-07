import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 숫자 배열
        int nums[] = new int[numCnt];

        // 숫자 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<numCnt; n++) nums[n] = Integer.parseInt(st.nextToken());

        // 목표 숫자 입력
        int target = Integer.parseInt(br.readLine());

        // 숫자 정렬
        Arrays.sort(nums);

        // 결과
        int result = 0;
        
        // 요소가 하나인 경우
        if (numCnt==1) {
            if (nums[0]==target) result++;
        } 
        
        // 아닌 경우
        else {
            int firPoint = 0;
            int secPoint = nums.length-1;
            
            while (firPoint<secPoint) {
                
                // 두 포인터 요소 합이 목표 값보다 같거나 작은 경우
                if(nums[firPoint]+nums[secPoint]<=target) {
                    
                    // 목표와 같은 경우
                    if(nums[firPoint]+nums[secPoint]==target) result++;
                    firPoint++;
                } 
                
                // 아닌 경우
                else {
                    secPoint--;
                }
            }
        }
        
        // 결과 출력
        System.out.println(result);
    }
}