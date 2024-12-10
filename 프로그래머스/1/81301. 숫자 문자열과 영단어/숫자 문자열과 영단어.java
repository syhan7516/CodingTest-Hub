class Solution {
    public int solution(String s) {
        
        // 영단어 배열
        String arr[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        // 문자열 확인
        for(int index=0; index<arr.length; index++) {
            s = s.replace(arr[index],String.valueOf(index));
        }
        
        return Integer.parseInt(s);
    }
}