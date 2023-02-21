import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String bin[] = {"000","001","010","011","100","101","110","111"};
        String oct[] = {"0","1","2","3","4","5","6","7"};

        // 2진수 입력
        String binaryNum = scanner.next();

        // 전처리
        if(binaryNum.length()%3==1)
            binaryNum = "00" + binaryNum;
        else if(binaryNum.length()%3==2)
            binaryNum = "0" + binaryNum;

        // 진수 변환
        for(int a=0; a<binaryNum.length()-2; a+=3) {
            String temp = binaryNum.substring(a,a+3);
            for(int b=0; b<bin.length; b++) {
                if(temp.equals(bin[b]))
                    System.out.print(oct[b]);
            }
        }
    }
}