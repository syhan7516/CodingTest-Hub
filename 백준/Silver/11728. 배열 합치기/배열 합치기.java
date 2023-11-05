import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 배열 크기 입력
        st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());

        // 배열 생성
        int [] arr1 = new int[size1];
        int [] arr2 = new int[size2];

        // 배열 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size1; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size2; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        // 배열 합치기
        int point1 = 0;
        int point2 = 0;

        while(point1<size1 && point2<size2) {

            if(arr1[point1]>arr2[point2]) {
                sb.append(arr2[point2]).append(" ");
                point2++;
            }

            else if(arr1[point1]<arr2[point2]) {
                sb.append(arr1[point1]).append(" ");
                point1++;
            }

            else {
                sb.append(arr1[point1]).append(" ");
                sb.append(arr2[point2]).append(" ");
                point1++;
                point2++;
            }
        }

        // 남은 경우
        if(point1<size1) {
            while(point1<size1) {
                sb.append(arr1[point1]).append(" ");
                point1++;
            }
        }

        else {
            while(point2<size2) {
                sb.append(arr2[point2]).append(" ");
                point2++;
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}