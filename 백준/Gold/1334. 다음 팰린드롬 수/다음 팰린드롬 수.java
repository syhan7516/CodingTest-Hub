import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 대칭 만들기 메서드
    public static String makeSymmetryNumber(StringBuilder sb, String num) {
        sb.append(num, 0, (num.length()+1)/2);

        int mid = num.length()/2;
        for(int index=mid-1; index>=0; index--) {
            sb.append(num.charAt(index));
        }

        return sb.toString();
    }

    // 모두 9인 경우 숫자 변환 메서드
    public static String convertNumAllNine(StringBuilder sb, String num) {
        sb.append(1);
        for(int index=0; index<num.length()-1; index++) {
            sb.append(0);
        }
        sb.append(1);

        return sb.toString();
    }

    // 모두 9가 아닌 경우 숫자 변환 메서드
    public static String convertNumIsNotAllNine(StringBuilder sb, String num) {
        int isNotNineIndex = (num.length()+1)/2-1;
        for(int index=isNotNineIndex; index>=0; index--) {
            if(num.charAt(index) != '9') {
                isNotNineIndex = index;
                break;
            }
        }

        sb.append(num);
        sb.setCharAt(isNotNineIndex, (char)(num.charAt(isNotNineIndex)+1));
        for(int index=isNotNineIndex+1; index<num.length(); index++) {
            sb.setCharAt(index, '0');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        String num = br.readLine();

        // 대칭 만들기
        String symmetryNum = makeSymmetryNumber(new StringBuilder(), num);

        // 대칭 수가 작거나, 같은 경우
        if(symmetryNum.compareTo(num) <= 0) {

            // 9가 아닌 자리 찾기
            boolean isAllNine = true;
            for(int index=(symmetryNum.length())/2; index>=0; index--) {
                if(symmetryNum.charAt(index) != '9') {
                    isAllNine = false;
                    break;
                }
            }

            // 모두 9인 경우
            if(isAllNine) symmetryNum = convertNumAllNine(new StringBuilder(), symmetryNum);

            // 아닌 경우
            else {
                symmetryNum = convertNumIsNotAllNine(new StringBuilder(), symmetryNum);
                symmetryNum = makeSymmetryNumber(new StringBuilder(), symmetryNum);
            }
        }

        // 결과 출력
        System.out.println(symmetryNum);
    }
}