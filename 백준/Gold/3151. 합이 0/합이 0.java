import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        long ans = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 오름차순 정렬
        Arrays.sort(arr);

        // 2개 먼저 뽑기
        for(int i = 0 ; i < N-2 ; i ++){
            for(int j = i+1 ; j < N-1 ; j ++){
                int lower = binarySearch(arr[i] + arr[j],  j+1, 0);
                int upper = binarySearch(arr[i] + arr[j], j+1, 1);

                ans += upper - lower;
            }
        }

        System.out.print(ans);
    }

    private static int binarySearch(int target, int s, int type) {
        int e = N;
        int m = 0;

        while(e > s){
            m = (s + e) / 2;

            if(type == 0 && arr[m] + target >= 0)
                e = m;
            else if(type == 1 && arr[m] + target > 0)
                e = m;
            else
                s = m + 1;
        }

        return s;
    }
}