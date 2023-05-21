import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 길이 입력
        int len = Integer.parseInt(br.readLine());
                    
        // 배열 A, B 입력
        int A[] = new int[len];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<len; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }
        
        int B[] = new int[len];
        st = new StringTokenizer(br.readLine());
        for(int n=0; n<len; n++) {
            B[n] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 최솟값 구하기
        int count = 0;
        for(int n=0; n<len; n++) {
            count += A[len-1-n] * B[n];
        }

        // 결과 출력
        System.out.println(count);
    }
}