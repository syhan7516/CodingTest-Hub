import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 용액 개수, 결과 용액
    public static int materialCnt, firMaterial, secMaterial;

    // 용액 정보 배열
    public static int material[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 용액 개수 입력
        materialCnt = Integer.parseInt(br.readLine());

        // 용액 정보 배열 생성
        material = new int[materialCnt];

        // 용액 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<materialCnt; i++)
            material[i] = Integer.parseInt(st.nextToken());

        // 용액 정렬
        Arrays.sort(material);

        // 용액 합쳐보기
        int mix = Integer.MAX_VALUE;
        int firPoint = 0;
        int secPoint = material.length-1;

        while(firPoint<secPoint) {

            // 합치기
            int value = material[firPoint]+material[secPoint];

            // 절대 값이 기존보다 0에 더 가까울 경우
            if(Math.abs(value)<mix) {
                firMaterial = material[firPoint];
                secMaterial = material[secPoint];
                mix = Math.abs(value);
            }

            // 합이 0보다 큰 경우
            if(value>0) {
                secPoint--;
            }
            // 아닌 경우
            else {
                firPoint++;
            }
        }

        // 결과 출력
        System.out.println(firMaterial+" "+secMaterial);
    }
}