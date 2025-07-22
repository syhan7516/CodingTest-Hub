import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 분자, 분모, 최대 분모, 개수
    public static int answer, originalBunja, originalBunmo, maxBunmo, maxCount;

    // 단위분수로 분할하기 메서드
    public static void solve(int bunja, int bunmo, int startBunmo, int count) {

        // 단위분수인 경우
        if(originalBunja * bunmo == originalBunmo * bunja) {
            answer++;
            return;
        }

        // 분할 개수 확인
        if(count==maxCount) {
            return;
        }

        // 분수 더하기
        for(int num=startBunmo; num*bunmo<=maxBunmo; num++) {
            int nextBunja = bunja * num + bunmo;
            int nextBunmo = num * bunmo;
            solve(nextBunja,nextBunmo,num,count+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 분자, 분모, 최대 분모, 개수 입력
        st = new StringTokenizer(br.readLine());
        originalBunja = Integer.parseInt(st.nextToken());
        originalBunmo = Integer.parseInt(st.nextToken());
        maxBunmo = Integer.parseInt(st.nextToken());
        maxCount = Integer.parseInt(st.nextToken());

        // 단위분수로 분할하기
        solve(0,1,1,0);

        // 결과 출력
        System.out.println(answer);
    }
}