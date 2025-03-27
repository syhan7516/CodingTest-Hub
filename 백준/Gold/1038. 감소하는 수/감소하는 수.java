import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // 목표 순서
    public static int order;

    // 숫자 배열
    public static int[] nums = {9,8,7,6,5,4,3,2,1,0};

    // 감소하는 수 저장 리스트
    public static ArrayList<Long> decliningNums;

    // 목표 순서 입력
    public static void inputOrder() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        order = Integer.parseInt(br.readLine());
    }

    // 숫자 선택하기 메서드
    public static void solve(int index, long num) {

        // 선택이 완료된 경우
        if(index==nums.length) {
            decliningNums.add(num);
            return;
        }

        // 선택, 미선택
        solve(index+1,num*10+nums[index]);
        solve(index+1,num);
    }

    // 감소하는 수 저장 리스트 생성 메서드
    public static void createDecliningNumsList() {

        // 감소하는 수 저장 리스트 생성
        decliningNums = new ArrayList<>();
    }

    // 초기화 메서드
    public static void initialize() throws IOException {

        // 목표 순서 입력
        inputOrder();

        // 감소하는 수 저장 리스트 생성
        createDecliningNumsList();
    }

    // 목표 순서 숫자 존재 여부 확인 메서드
    public static boolean hasOrderNum() {
        return order+1 < decliningNums.size();
    }

    // 목표 순서 숫자 찾기 메서드
    public static long findOrderNum() {

        // 목표 순서의 수가 있는 경우
        if(hasOrderNum())
            return decliningNums.get(order+1);

        else return -1;
    }

    public static void main(String[] args) throws IOException {

        // 초기화
        initialize();

        // 숫자 선택하기
        solve(0,0);

        // 정렬
        Collections.sort(decliningNums);

        // 목표 순서 숫자 찾기
        System.out.println(findOrderNum());
    }
}