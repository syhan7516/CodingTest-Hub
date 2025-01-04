import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// ac
class AC {
    List<Integer> nums;
    boolean flag;

    public AC() {
        nums = new ArrayList<>();
        flag = true;
    }

    public void reverse() {
        flag = !flag;
    }

    public boolean delete() {
        if(nums.isEmpty()) return false;
        if(flag) nums.remove(0);
        else nums.remove(nums.size()-1);
        return true;
    }

    public void strToList(String numbers) {
        if(numbers.length()==2) return;
        numbers = numbers.substring(1,numbers.length()-1);
        Arrays.stream(numbers.split(",")).map(Integer::parseInt).forEach(nums::add);
    }

    public String listToStr() {
        if(!flag) Collections.reverse(nums);
        return "["+nums.stream().map(String::valueOf).collect(Collectors.joining(","))+"]";
    }
}

public class Main {

    // 명령, 배열 정보
    public static String orders, arr;

    // 숫자 개수
    public static int numberCount;

    // 명령 수행 메서드
    public static String solve(AC ac) {

        // 명령 수행
        for(int index=0; index<orders.length(); index++) {

            // 현재 명령
            char order = orders.charAt(index);

            // R
            if(order=='R') {
                ac.reverse();
                continue;
            }

            // D
            if(!ac.delete()) {
                return "error";
            }
        }

        return ac.listToStr();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int testcaseCount = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseCount=0; caseCount<testcaseCount; caseCount++) {
            orders = br.readLine();
            numberCount = Integer.parseInt(br.readLine());
            arr = br.readLine();

            // ac 생성
            AC ac = new AC();

            // ac 리스트 숫자넣기
            ac.strToList(arr);

            // 명령 수행
            sb.append(solve(ac)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}