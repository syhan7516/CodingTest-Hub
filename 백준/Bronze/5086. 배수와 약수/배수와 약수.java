import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            // 숫자 입력
            st = new StringTokenizer(br.readLine());
            int firNum = Integer.parseInt(st.nextToken());
            int secNum = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(firNum==0 && secNum==0)
                break;

            // 숫자 확인
            
            // 조건 1
            if(secNum%firNum==0) {
                System.out.println("factor");
            }

            // 조건 2
            else if(firNum%secNum==0) {
                System.out.println("multiple");
            }

            // 조건 3
            else
                System.out.println("neither");
        }
    }
}