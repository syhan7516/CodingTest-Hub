import java.util.regex.Pattern;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
        // 정규식 패턴
        Pattern pattern = Pattern.compile("(100+1+|01)+");
		
        // 테스트 케이스 수 입력
		int caseCount = Integer.parseInt(br.readLine());
		
        // 케이스 수행
		while(caseCount-- > 0) {

            // 패턴이 적용된 경우
            if(pattern.matcher(br.readLine()).matches()) {
                sb.append("YES").append('\n');
            } 
            
            // 아닌 경우
            else sb.append("NO").append('\n');
		}
		
        // 결과 출력
		System.out.println(sb.toString());

	}
}