import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 선물 개수, 예산, 할인 선물 개수 입력
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int disCount = Integer.parseInt(st.nextToken());
        
        // 합
        long sum = 0;

        // 선물 배열 생성
        int[] gifts = new int[count];

        // 선물 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<count; index++) {
            gifts[index] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(gifts);

        // 할인 수행
        int start = 0;
        int end = 0;
        for(int index=0; index<count; index++) {
            if(disCount > 0) {
                if (sum + (gifts[index] / 2) <= money) {
                    sum += (gifts[index] / 2);
                    disCount--;
                    end = index + 1;
                }

                else break;
            }

            else {
                sum += (gifts[start] / 2);
                sum += gifts[end] / 2;

                if(sum > money) break;

                else {
                    start++;
                    end++;
                }
            }
        }

        // 결과 출력
        System.out.println(end);
    }
}