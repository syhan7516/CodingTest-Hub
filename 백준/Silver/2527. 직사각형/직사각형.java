import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사각형 정보 입력
        for (int square=0; square<4; square++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();

            // 공통부분이 없는 경우
            if (p1<x2 || q1<y2 || p2<x1 || q2<y1) {
                System.out.println("d");
            }
            
            // 점인 경우
            else if ((x1==p2 && y1==q2) || (x1==p2 && q1==y2) || (p1==x2 && q1==y2) || (p1==x2 && y1==q2)) {
                System.out.println("c");
            }
            
            // 선분인 경우
            else if (p1==x2 || q1==y2|| p2==x1 || y1==q2){
                System.out.println("b");
            }
            
            // 직사각형인 경우
            else {
                System.out.println("a");
            }
        }
    }
}