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

        // 숫자 정보 셋
        HashSet<Integer> set = new HashSet<>();

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numCnt; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            set.add(nums[i]);
        }

        // 중복 제거
        ArrayList<Integer> copyNums = new ArrayList<>();
        for(int data: set) copyNums.add(data);

        // 리스트 정렬
        Collections.sort(copyNums);

        // 압축 정보 결과 해시
        HashMap<Integer,Integer> idx = new HashMap<>();

        // 좌표 압축
        for(int i=0; i<numCnt; i++) {

            // 이미 값이 있는 경우
            if(idx.containsKey(nums[i])) {
                sb.append(idx.get(nums[i])).append(" ");
            }

            // 값이 없는 경우
            else {
                idx.put(nums[i],Collections.binarySearch(copyNums,nums[i]));
                sb.append(idx.get(nums[i])).append(" ");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}