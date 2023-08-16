import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	
	// 영상 크기
	public static int size;
	// 영상 배열
	public static int video[][];
	
	// 영상 압축하기 메서드
	static void solve(int row, int col, int size) {
		
		// 합
		int sum = 0;
		
		// 영상 확인
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				sum += video[i][j];
			}
		}
		
		// 전부 0인 경우
		if(sum==0) {
			sb.append(0);
		}
		
		// 전부 1인 경우
		else if(sum==size*size) {
			sb.append(1);
		}
		
		// 둘 다 섞인 경우
		else {
			
			// 중간 범위
			int half = size/2;
			
			// 괄호 추가
			sb.append("(");
			
			// 1사분면
			solve(row,col,half);
			// 2사분면
			solve(row,col+half,half);
			// 3사분면
			solve(row+half,col,half);
			// 4사분면
			solve(row+half,col+half,half);
			
			// 괄호 닫기
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 영상 크기 입력
		size = Integer.parseInt(br.readLine());
		
		// 영상 생성
		video = new int[size][size];
		
		// 영상 정보 입력
		for(int i=0; i<size; i++) {
			String line = br.readLine();
			for(int j=0; j<size; j++) {
				video[i][j] = line.charAt(j)-'0';
			}
		}

		// 영상 압축하기
		solve(0,0,size);
		
		// 결과 출력
		System.out.println(sb);
	}
}