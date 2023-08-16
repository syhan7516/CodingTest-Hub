import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 기타 클래스
class Guitar implements Comparable<Guitar>{
	String serial;
	int sum;
	
	public Guitar(String serial, int sum) {
		this.serial = serial;
		this.sum = sum;
	}
	
	public int compareTo(Guitar other) {
		
		// 길이가 다른 경우
		if(this.serial.length()!=other.serial.length()) {
			
			// 작은 경우를 먼저
			if(this.serial.length()<other.serial.length())
				return -1;
			
			return 1;
		}
		
		// 길이가 같은 경우
		else {
			if(this.sum<other.sum) {
				return -1;
			}
			
			else if(this.sum==other.sum) {
				return this.serial.compareTo(other.serial);
			}
			
			return 1;
		}
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 우선 순위 큐
		PriorityQueue<Guitar> priQ = new PriorityQueue<>();
		
		// 기타의 개수 입력
		int guitarCnt = Integer.parseInt(br.readLine());
		
		// 기타 보관 배열
		Guitar guitars[] = new Guitar[guitarCnt];
		
		// 기타 시리얼 넘버 입력
		int sum = 0;
		for(int i=0; i<guitarCnt; i++) {
			
			// 시리얼 넘버 입력
			String guitar = br.readLine();
			
			// 각 숫자의 합
			sum = 0;
			for(int j=0; j<guitar.length(); j++) {
				
				// 각 자리 확인
				char alpha = guitar.charAt(j);
				
				// 자리가 숫자인 경우
				if(alpha>='0' && alpha<='9') {
					sum += alpha-'0';
				}
			}
			
			// 정보 저장
			priQ.offer(new Guitar(guitar,sum));
		}
		
		// 결과 출력
		while(!priQ.isEmpty()) {
			System.out.println(priQ.poll().serial);
		}
	}
}