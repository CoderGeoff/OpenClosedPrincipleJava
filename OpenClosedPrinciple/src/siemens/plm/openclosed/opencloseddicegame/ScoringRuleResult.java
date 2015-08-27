package siemens.plm.openclosed.opencloseddicegame;

public class ScoringRuleResult {
    private boolean matched;
    private int score;
    private int[] remainingDiceCount;
    
    public ScoringRuleResult() {
    	matched = false;
    	score = 0;
    }
    
    public ScoringRuleResult(int score, int[] diceCountAfterMatch) {
    	this.matched = true;
    	this.score = score;
    	this.remainingDiceCount = diceCountAfterMatch.clone();
    }
    
    public boolean isMatched() {
    	return matched;
    }
    
    public int getScore() {
    	return score;
    }
    
    public int[] getRemaininDiceCount() {
    	return remainingDiceCount;
    }
}
