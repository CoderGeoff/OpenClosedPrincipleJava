package siemens.plm.openclosed.opencloseddicegame;

import java.util.Map;

public class ScoringRuleResult {
    private boolean matched;
    private int score;
    private Map<Integer, Integer> remainingDiceCount;
    
    public ScoringRuleResult() {
    	matched = false;
    	score = 0;
    }
    
    public ScoringRuleResult(int score, Map<Integer, Integer> remainingDiceCount) {
    	this.matched = true;
    	this.score = score;
    	this.remainingDiceCount = remainingDiceCount;
    }
    
    public boolean isMatched() {
    	return matched;
    }
    
    public int getScore() {
    	return score;
    }
    
    public Map<Integer, Integer> getRemaininDiceCount() {
    	return remainingDiceCount;
    }
}
