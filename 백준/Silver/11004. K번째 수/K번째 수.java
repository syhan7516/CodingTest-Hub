import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자 개수 & K번째 입력
        int numCnt = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 숫자 배열
        ArrayList<Integer> nums = new ArrayList<>();

        // 숫자 입력
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<numCnt; idx++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬
        Collections.sort(nums);

        // 결과 출력
        System.out.println(nums.get(k-1));
    }
}