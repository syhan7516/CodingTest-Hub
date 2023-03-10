import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 케이스 수 입력
        int caseNum = scanner.nextInt();
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 각도 입력
            int move = scanner.nextInt();

            // 시간 확인
            int time = move * 2;
            int h = time/60;
            int m = time%60;

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+h+" "+m);

        }
        scanner.close();
    }
}
