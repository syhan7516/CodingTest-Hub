import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 라이언 인형 확인 함수
    static int checkDolls(int dolls[], int lionCnt) {
        int count = Integer.MAX_VALUE;
        int firPoint = 0;
        int secPoint = 0;
        int dollSum = 0;

        // 투 포인터 수행
        dollSum = dolls[secPoint];

        while(firPoint<dolls.length && secPoint<dolls.length) {
            // 개수가 같거나 클 경우
            if(dollSum==lionCnt) {
                count = Math.min(count,secPoint-firPoint+1);
                dollSum -= dolls[firPoint];
                firPoint += 1;
            }

            // 개수가 작을 경우
            else {
                secPoint += 1;
                if(secPoint<dolls.length)
                    dollSum += dolls[secPoint];
            }
        }

        // 결과 리턴
        if(count==Integer.MAX_VALUE)
            return -1;
        else
            return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인형의 개수, 라이언 인형 개수 입력
        int dollCnt = Integer.parseInt(st.nextToken());
        int lionCnt = Integer.parseInt(st.nextToken());

        // 인형 개수 정보 입력
        int dolls[] = new int[dollCnt];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<dollCnt; idx++) {
            int d = Integer.parseInt(st.nextToken());
            if(d==2)
                d = 0;

            dolls[idx] = d;
        }

        // 라이언 인형 확인
        int result = checkDolls(dolls,lionCnt);

        // 결과 출력
        System.out.println(result);
    }
}