import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 두 수 입력
        int firNum = scanner.nextInt();
        int secNum = scanner.nextInt();
        String result = Integer.toString(firNum,secNum);

        // 결과 출력
        System.out.println(result.toUpperCase());
    }
}