import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 용액의 수
    public static int fluidCnt;
    // 용액 정보 배열
    public static int fluidArr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 용액의 수 입력
        fluidCnt = Integer.parseInt(br.readLine());

        // 용액 정보 입력
        fluidArr = new int[fluidCnt];
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<fluidCnt; idx++) {
            fluidArr[idx] = Integer.parseInt(st.nextToken());
        }

        // 기본 셋팅
        long result = Long.MAX_VALUE;
        int values[] = new int[2];

        // 투 포인터 위치 설정
        int firPoint = 0;
        int secPoint = fluidArr.length-1;

        // 포인터 범위 제한
        while(firPoint<secPoint) {

            // 현재 가르키는 두 용액의 값
            long curSum = fluidArr[firPoint] + fluidArr[secPoint];

            // 기존보다 0에 더 가까운 경우
            if(Math.abs(curSum)<result) {
                result = Math.abs(curSum);
                values[0] = fluidArr[firPoint];
                values[1] = fluidArr[secPoint];
            }

            // 합이 0일 경우
            if(curSum==0)
                break;
            
            // 합이 0보다 클 경우
            else if(curSum>0) {
                secPoint--;
            }
            
            // 합이 0보다 작을 경우
            else 
                firPoint++;
        }


        // 결과 출력
        Arrays.sort(values);
        System.out.println(values[0]+" "+values[1]);
    }
}
