import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        Long resultNum = Long.MAX_VALUE;
        int resultCnt = 0;

        // 카드 개수 입력
        int cardCnt = Integer.parseInt(br.readLine());

        // 해시 맵
        HashMap map = new HashMap();

        // 숫자 입력
        for(int idx=0; idx<cardCnt; idx++) {
            Long number =Long.parseLong(br.readLine());
            if(!map.containsKey(number)) {
                map.put(number,1);
            }

            else {
                int numCnt = (int) map.get(number);
                map.put(number,++numCnt);
            }
        }

        // 저장 값 순회 & 비교
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if(resultCnt < (int)entry.getValue()) {
                resultCnt = (int)entry.getValue();
                resultNum = (Long)entry.getKey();
                continue;
            }

            if(resultCnt == (int)entry.getValue()) {
                if(resultNum > (Long)entry.getKey()) {
                    resultNum = (Long)entry.getKey();
                }
                continue;
            }
        }

        // 결과 출력
        System.out.println(resultNum);
    }
}