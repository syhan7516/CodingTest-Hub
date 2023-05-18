import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 돌의 개수 입력
        int stoneCnt = Integer.parseInt(br.readLine());

        // 게임 진행
        if(stoneCnt%2!=0)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}