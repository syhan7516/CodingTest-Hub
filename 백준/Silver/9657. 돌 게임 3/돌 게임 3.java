import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 돌 개수 입력
        int stone = Integer.parseInt(br.readLine());

        // 승자 확인

        // 돌 개수가 7배수 또는 나머지가 2일 경우
        if(stone%7==0 || stone%7==2)
            System.out.println("CY");
        
        // 아닌 경우
        else {
            System.out.println("SK");
        }
    }
}