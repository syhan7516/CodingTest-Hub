class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        // 결과
        int answer = 0;
        
        // 스킬트리 확인
        for(int skillTreeIndex=0; skillTreeIndex<skill_trees.length; skillTreeIndex++) {
            
            // 선행 스킬 이외 스킬 제거
            String extractedSkill = skill_trees[skillTreeIndex].replaceAll("[^"+ skill +"]","");
            
            // 선행 스킬 확인
            for(int skillIndex=0; skillIndex<=skill.length(); skillIndex++) {
                
                // 선행 스킬 순서 비교
                String comparisonSkill = skill.substring(0,skillIndex);
                
                // 올바른 경우
                if(extractedSkill.equals(comparisonSkill)) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}