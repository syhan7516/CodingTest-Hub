import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        int result = 0;

        // 레벨 수 입력
        int level = Integer.parseInt(br.readLine());

        // 각 레벨별 배열
        int levels[] = new int[level];

        // 점수 저장
        for(int l=0; l<level; l++) {
            levels[l] = Integer.parseInt(br.readLine());
        }

        // 레벨이 한 단계일 경우
        if(level==1)
            result = 0;

        // 아닌 경우
        else {

            // 점수 확인
            for(int l=level-2; l>=0; l--) {
                int firScore = levels[l+1];
                int secScore = levels[l];

                if(secScore>=firScore) {
                    result += secScore-(firScore-1);
                    levels[l] = firScore-1;
                }
            }
        }
        
        // 결과 출력
        System.out.print(result);
    }
}