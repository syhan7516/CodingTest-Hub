
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    // 두 수 자리 교환 함수
    static void swap(char arr[], int firPoint, int secPoint) {
        char swapIdx = arr[firPoint];
        arr[firPoint] = arr[secPoint];
        arr[secPoint] = swapIdx;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 문자열 입력
            char nums[] = br.readLine().toCharArray();
            // 비교 문자열 배열
            char copyNums[];

            // 최대, 최소 저장
            int maxNum = Integer.parseInt(String.valueOf(nums));
            int minNum = Integer.parseInt(String.valueOf(nums));

            // 두 숫자 교환하기
            for(int a=0; a<nums.length; a++) {
                for(int b=0; b<nums.length; b++) {
                    if(a==b) continue;
                    copyNums = new char[nums.length];
                    System.arraycopy(nums,0,copyNums,0,nums.length);
                    swap(copyNums,a,b);

                    // 첫 번째 자리가 0인 경우
                    if(copyNums[0]=='0') continue;
                    // 0이 아닌 경우
                    maxNum = Math.max(maxNum,Integer.parseInt(String.valueOf(copyNums)));
                    minNum = Math.min(minNum,Integer.parseInt(String.valueOf(copyNums)));
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+minNum+" "+maxNum+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}