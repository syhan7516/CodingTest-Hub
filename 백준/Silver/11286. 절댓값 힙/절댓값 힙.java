import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class DisitNum implements Comparable<DisitNum> {
    private int absNumber;
    private int number;

    public DisitNum(int number) {
        this.absNumber = Math.abs(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public int compareTo(DisitNum other) {
        if(this.absNumber < other.absNumber)
            return -1;

        else if(other.absNumber == this.absNumber) {
            if(this.number < other.number)
                return -1;
        }

        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<DisitNum> priQ = new PriorityQueue<>();

        // 연산의 개수 입력
        int opCnt = Integer.parseInt(br.readLine());

        // 연산의 수만큼 수행
        int num = 0;
        for(int idx=0; idx<opCnt; idx++) {
            num = Integer.parseInt(br.readLine());

            // 0이 아닌 경우
            if(num!=0)
                priQ.offer(new DisitNum(num));

            // 0인 경우
            else {
                // 비어있을 경우
                if(priQ.isEmpty())
                    System.out.println(0);
                // 안 비었을 경우
                else {
                    DisitNum temp = priQ.poll();
                    System.out.println(temp.getNumber());
                }
            }
        }
    }
}