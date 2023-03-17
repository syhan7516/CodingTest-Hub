import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 나무의 수, 가져갈 나무 길이 입력, 절단기 높이
    public static int treeCnt, getTreeLen, height;
    // 결과
    public static long result;
    // 나무 길이 정보 배열
    public static int treeLenArr[];

    // 절단하기 함수
    static void getCuttingTree(int start, int end) {
        while(start<=end) {

            // 절단기 중간 높이 지정
            int mid = (start+end)/2;

            // 나무 자르기
            long getTreeSum = 0;
            for(int t=0; t<treeLenArr.length; t++) {
                long treeLen = treeLenArr[t] - mid;
                if(treeLen < 0)
                    treeLen = 0;

                getTreeSum += treeLen;
            }

            // 자른 나무 확인
            if(getTreeSum >= getTreeLen) {
                start = mid+1;
                result = mid;
            }
            else {
                end = mid-1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 나무의 수, 가져갈 나무 길이 입력
        treeCnt = Integer.parseInt(st.nextToken());
        getTreeLen = Integer.parseInt(st.nextToken());

        // 각 나무의 길이
        treeLenArr = new int[treeCnt];

        // 나무 길이 입력
        height = 0;
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<treeCnt; idx++) {
            treeLenArr[idx] = Integer.parseInt(st.nextToken());
            height = Math.max(height, treeLenArr[idx]);
        }

        // 절단하기
        result = 0;
        getCuttingTree(0,height);

        // 결과 확인
        System.out.println(result);
    }
}