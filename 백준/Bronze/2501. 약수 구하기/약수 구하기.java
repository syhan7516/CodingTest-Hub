import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 자연수, 순서 입력
        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        // 순서에 맞는 약수 찾기
        int count = 0;
        for(int idx=1; idx<=number; idx++) {
            if(number%idx==0) {
                count += 1;

                // 찾았을 경우
                if(count==order) {

                    // 결과 출력
                    System.out.println(idx);
                    break;
                }
            }
        }

        // 예외의 경우
        if(count<order)
            System.out.println(0);
    }
}