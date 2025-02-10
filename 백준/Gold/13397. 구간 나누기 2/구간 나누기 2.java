import java.util.*;
import java.io.*;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0~배열의 최대값 이분 탐색을 활용해서 구간을 나누자

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int s = 0;
        int e = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            e = Math.max(arr[i], e);
        }

        int ans = 0;
        while(s <= e){

            int mid = (s+e)/2;

            // mid 값을 기준으로 구간의 최대값이라하고 구간 나누기

            int min = 10010;
            int max = 0;

            int cnt = 1;
            for(int i=0; i<N; i++){

                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if (max - min > mid){
                    cnt++;
                    min = arr[i];
                    max = arr[i];
                }
            }

            if (cnt > M){
                s = mid + 1;
            }
            else{
                ans = mid;
                e = mid - 1;
            }
        }


        System.out.println(ans);


    }


}