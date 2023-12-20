import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 숫자 개수 입력
        int numCnt = Integer.parseInt(br.readLine());

        // 숫자 정보 저장 배열 생성
        int nums[] = new int[numCnt];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자 정보 배열 복사
        int copyNums[] = Arrays.copyOfRange(nums,0,numCnt);

        // 복사 배열 정렬
        Arrays.sort(copyNums);

        // 압축 정보 결과 해시
        HashMap<Integer,Integer> map = new HashMap<>();

        // 좌표 압축
        int idx = 0;
        for(int i=0; i<numCnt; i++) {

            // 값이 없는 경우
            if(!map.containsKey(copyNums[i])) {
                map.put(copyNums[i],idx);
                idx++;
            }
        }

        // 결과 저장
        for(int data: nums)
            sb.append(map.get(data)).append(" ");

        // 결과 출력
        System.out.println(sb.toString());
    }
}