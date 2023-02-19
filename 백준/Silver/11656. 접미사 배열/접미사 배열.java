import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();

        // 단어 입력
        String letters = scanner.next();

        // 접미사 찾기
        for(int idx=0; idx<letters.length(); idx++) {
            result.add(letters.substring(idx));
        }
        // 정렬
        Collections.sort(result);

        // 결과 출력
        for(String element: result)
            System.out.println(element);
    }
}