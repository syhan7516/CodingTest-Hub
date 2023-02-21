import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 테스트 케이스 수 입력
        int caseNum = scanner.nextInt();

        // 케이스 수만큼 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 두 수 입력
            int firNum = scanner.nextInt();
            int secNum = scanner.nextInt();

            // 큰 수, 작은 수 정하기
            if(firNum > secNum) {
                int swap = firNum;
                firNum = secNum;
                secNum = swap;
            }

            // 최대공약수 구하기
            int maxNum = 0;
            for(int idx=1; idx<=firNum; idx++) {
                if(firNum%idx==0 && secNum%idx==0)
                    maxNum = idx;
            }

            // 최소공배수 구하기
            int minNum = 0;
            minNum = firNum * secNum / maxNum;

            // 결과 출력
            System.out.println(minNum);
        }
    }
}