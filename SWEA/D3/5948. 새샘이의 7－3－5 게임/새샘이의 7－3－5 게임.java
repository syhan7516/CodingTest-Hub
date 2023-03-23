import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.util.Collections.reverseOrder;

public class Solution {

    // 덧셈 결과 리스트
    public static ArrayList<Integer> result;
    // 수 배열
    public static int nums[];
    // 수 방문 배열
    public static boolean visited[];
    // 세 수 선택 결과 배열
    public static int findNum[];

    // 덧셈 수행 함수
    static void getNumSum(int depth, int idx) {
        // 세 수를 골랐을 경우
        if(depth==3) {
            int numSum = 0;
            for(int element: findNum)
                numSum += element;
            if(!result.contains(numSum))
                result.add(numSum);
            return ;
        }
        // 덜 골랐을 경우
        for(int n=idx; n<7; n++) {
            if(visited[n]==false) {
                visited[n] = true;
                findNum[depth] = nums[n];
                getNumSum(depth+1,n+1);
                visited[n] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 숫자들 입력
            nums = new int[7];
            visited = new boolean[7];
            findNum = new int[3];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<nums.length; n++)
                nums[n] = Integer.parseInt(st.nextToken());

            // 덧셈 수행
            result = new ArrayList<>();
            getNumSum(0,0);

            // 결과 정렬
            Collections.sort(result,reverseOrder());
            System.out.println("#"+(caseIdx+1)+" "+result.get(4));
        }
    }
}