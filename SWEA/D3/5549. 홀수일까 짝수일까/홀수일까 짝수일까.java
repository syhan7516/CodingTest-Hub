import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 양의 정수 입력
            String n = br.readLine();

            // 양수, 음수 판별하기
            int number = n.charAt(n.length()-1)-'0';

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(number%2==0)
                System.out.println("Even");
            else
                System.out.println("Odd");
        }
    }
}