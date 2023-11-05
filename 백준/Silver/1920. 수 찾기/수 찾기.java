import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 배열 원소 수
    public static int cnt1, cnt2;

    // 기존 배열
    public static int [] arr;

    // 수 찾기 메서드
    static int solve(int start, int end, int target) {

        while(start<=end) {

            int mid = (start+end)/2;

            if(arr[mid]==target)
                return 1;

            else if(arr[mid]<target)
                start = mid+1;

            else
                end = mid-1;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 배열 생성
        st = new StringTokenizer(br.readLine());
        cnt1 = Integer.parseInt(st.nextToken());
        arr = new int[cnt1];

        // 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 찾을 수의 개수
        cnt2 = Integer.parseInt(br.readLine());

        // 배열 정렬
        Arrays.sort(arr);

        // 원소 찾기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt2; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(solve(0,arr.length-1,num));
        }
    }
}