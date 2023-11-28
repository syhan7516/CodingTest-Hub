import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Value implements Comparable<Value> {
    int num;
    int idx;
    int cnt;
    public Value(int num, int idx , int cnt) {
        this.num = num;
        this.idx = idx;
        this.cnt = cnt;
    }

    public void plus() {
        this.cnt++;
    }

    @Override
    public int compareTo(Value other) {
        if(this.cnt==other.cnt)
            return this.idx-other.idx;
        return other.cnt-this.cnt;
    }
}

public class Main {

    // 숫자 개수
    public static int numCnt;
    
    // 리스트, 해시
    public static HashMap<Integer,Value> map;
    public static ArrayList<Value> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 숫자 개수 입력
        st = new StringTokenizer(br.readLine());
        numCnt = Integer.parseInt(st.nextToken());
        HashMap<Integer, Value> map = new HashMap<>();
        ArrayList<Value> list = new ArrayList<>();

        // 숫자 정보 입력
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<numCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                Value current = new Value(num, i, 0);
                map.put(num, current);
                list.add(current);
            }
            map.get(num).plus();
        }
        
        // 정렬
        Collections.sort(list);
        
        // 결고 저장
        for (int i=0; i<list.size(); i++) {
            Value current = list.get(i);
            int num = current.num;
            int cnt = current.cnt;
            while (cnt-->0)
                sb.append(num).append(" ");
        }
        
        // 결과 출력
        System.out.println(sb);
    }
}