import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 숫자 개수, 목표 수
    public static int answer, numCount, target;

    // 숫자 배열
    public static int nums[];

    // 부분 수열 합 구하기 메서드
    public static void solve(int index, int sum, int selectedCount) {

        // 숫자 선택이 끝난 경우
        if(index==numCount) {

            // 숫자가 하나도 선택이 안된 경우
            if(selectedCount==0)
                return;

            // 합이 목표와 일치하는 경우
            if(sum==target)
                answer++;
            return;
        }

        // 숫자 선택하기
        solve(index+1,sum+nums[index],selectedCount+1);
        solve(index+1, sum,selectedCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수, 목표 수 입력
        st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        // 숫자 배열 생성
        nums = new int[numCount];

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0;index<numCount;index++) {
            nums[index] = Integer.parseInt(st.nextToken());
        }

        // 부분 수열 합 구하기
        answer = 0;
        solve(0,0,0);

        // 결과 출력
        System.out.println(answer);
    }
}