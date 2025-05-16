import java.util.*;

// 파일 클래스
class File implements Comparable<File> {
    int index;
    String fileName;
    String head;
    int number;
    String tail;
    
    public File(int index, String fileName, String head, int number, String tail) {
        this.index = index;
        this.fileName = fileName;
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
    
    public int compareTo(File other) {
        
        // HEAD 동일한 경우
        if(this.head.equalsIgnoreCase(other.head)) {
            
            // NUMBER 동일한 경우
            if(this.number==other.number) {
                return this.index - other.index;
            }
            return this.number - other.number;
        }
        return this.head.toLowerCase().compareTo(other.head.toLowerCase());
    }
}

class Solution {
    
    // 파일 저장 배열
    public static File[] fileClassArray;
    
    public static void extractFileName(String fileName, int fileIndex) {
        
        // 문자열 분리 기준 인덱스
        int fileCutIndex = 0;
        
        // HEAD, NUMBER, TAIL
        String head = null;
        int number = -1;
        String tail = null;
        
        // HEAD 분리
        for(int index=0; index<fileName.length(); index++) {
            if(fileName.charAt(index)>='0' && fileName.charAt(index)<='9') {
                head = fileName.substring(fileCutIndex,index);
                fileCutIndex = index;
                break;
            }
        }
        
        // NUMBER, TAIL 분리
        for(int index=fileCutIndex; index<fileName.length(); index++) {
            if(fileName.charAt(index)<'0' || fileName.charAt(index)>'9') {
                number = Integer.parseInt(fileName.substring(fileCutIndex,index));
                tail = fileName.substring(index);
                break;
            }
        }
        
        // TAIL이 없는 경우
        if(number==-1) {
            number = Integer.parseInt(fileName.substring(fileCutIndex));
        }
        
        // File 생성
        fileClassArray[fileIndex] = new File(fileIndex,fileName,head,number,tail);
    }
    
    public String[] solution(String[] files) {
        
        // 파일 저장 배열 생성
        fileClassArray = new File[files.length];
    
        // 파일 형식 분리해서 저장
        for(int fileIndex=0; fileIndex<files.length; fileIndex++) {
            extractFileName(files[fileIndex],fileIndex);
        }
        
        // 정렬
        Arrays.sort(fileClassArray);
        
        // 결과 저장
        String[] answer = new String[files.length];
        for(int fileIndex=0; fileIndex<fileClassArray.length; fileIndex++) {
            answer[fileIndex] = fileClassArray[fileIndex].fileName;
        }
        
        return answer;
    }
}