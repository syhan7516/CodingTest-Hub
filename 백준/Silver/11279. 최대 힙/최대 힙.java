import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> mnq = new PriorityQueue<>(Comparator.reverseOrder());

        int opCnt = Integer.parseInt(st.nextToken());

        for(int idx=0; idx<opCnt; idx++) {
            int opt = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(opt > 0)
                mnq.add(opt);
            else {
                if(mnq.isEmpty())
                    System.out.println(0);
                else {
                    System.out.println(mnq.peek());
                    mnq.poll();
                }
            }
        }
    }
}