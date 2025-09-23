import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 힘 최대값
        int maxNum = Integer.MIN_VALUE;

        // 힘 최대값 시작 위치
        int maxNumStartIndex = 0;

        // 힘 최대값 마지막 위치
        int maxNumEndIndex = 0;

        // 인원 수 입력
        int count = Integer.parseInt(br.readLine());

        // 힘 배열 생성
        int[] powers = new int[count];

        // 힘 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<count; index++) {
            powers[index] = Integer.parseInt(st.nextToken());

            // 최대값인 경우
            if(maxNum < powers[index]) {

                // 최대값 갱신
                maxNum = powers[index];
                maxNumStartIndex = index;
                maxNumEndIndex = index;
            }

            // 최대값과 동일한 경우
            else if(maxNum == powers[index]) {

                // 마지막 위치 갱신
                maxNumEndIndex = index;
            }
        }
        
        // 결과 출력
        if(maxNumStartIndex > powers.length-1-maxNumEndIndex) System.out.println("B");
        else if (maxNumStartIndex < powers.length-1-maxNumEndIndex) System.out.println("R");
        else System.out.println("X");
    }
}