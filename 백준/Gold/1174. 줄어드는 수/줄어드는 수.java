import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // 목표 순서
    public static int order;

    // 줄어드는 수 저장 리스트
    public static ArrayList<Long> decreasingNums;

    // 선택 대상 숫자 배열
    public static int[] nums = {9,8,7,6,5,4,3,2,1,0};

    // 초기화 메서드
    public static void inintialize() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        order = Integer.parseInt(br.readLine());
        decreasingNums = new ArrayList<>();
    }

    // 목표 순서 찾기 메서드
    public static void solve(int point, long num) {

        // 끝까지 온 경우
        if(point==nums.length) {
            if(!decreasingNums.contains(num))
                decreasingNums.add(num);
            return;
        }

        // 순서대로 선택하기
        for(int index=point; index<nums.length; index++) {
            solve(index+1,num*10+nums[index]);
            solve(index+1,num);
        }
    }

    // 결과 확인 메서드
    public static long checkResult() {

        // 목표 순서가 없는 경우
        if(decreasingNums.size()<order) return -1;
        else return decreasingNums.get(order-1);
    }

    public static void main(String[] args) throws IOException {

        // 초기화
        inintialize();

        // 목표 순서 찾기
        solve(0,0);

        // 정렬
        Collections.sort(decreasingNums);

        // 결과 출력
        System.out.println(checkResult());
    }
}