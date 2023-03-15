import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과 해시
        Map<Integer,Integer> result = new HashMap<>();

        // 숫자1 개수 입력
        int firNumCnt = Integer.parseInt(br.readLine());

        // 숫자1 카드 입력
        int firNums[] = new int[firNumCnt];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<firNumCnt; idx++) {
            firNums[idx] = Integer.parseInt(st.nextToken());
        }

        // 숫자2 개수 입력
        int secNumCnt = Integer.parseInt(br.readLine());
        int number = 0;
        st = new StringTokenizer(br.readLine());
        int secNums[] = new int[secNumCnt];
        for(int idx=0; idx<secNumCnt; idx++) {
            number = Integer.parseInt(st.nextToken());
            secNums[idx] = number;
            result.put(number,0);
        }

        // 숫자1 확인
        for(int idx=0; idx<firNums.length; idx++) {
            int count = 0;
            if(result.get(firNums[idx])!=null) {
                count = result.get(firNums[idx])+1;
                result.put(firNums[idx],count);
            }
        }

        // 결과 출력
        for(int idx=0; idx<secNumCnt; idx++) {
            System.out.print(result.get(secNums[idx])+" ");
        }
    }
}