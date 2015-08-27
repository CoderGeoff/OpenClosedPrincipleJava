package siemens.plm.openclosed.opencloseddicegame;

import java.util.Arrays;
import java.util.List;

public class PatternScoresXRule implements IScoringRule {
	private List<Integer> pattern;
	private int score;

	public PatternScoresXRule(List<Integer> pattern, int score) {
		this.pattern = pattern;
		this.score = score;
	}
	
	public ScoringRuleResult tryMatch(int[] diceCount)
	{
	    int[] diceCountAfterMatch = diceCount.clone();

	    pattern.stream().forEach(diceThrow -> diceCountAfterMatch[diceThrow]--);
	    boolean matches = Arrays.stream(diceCountAfterMatch).allMatch(count -> count >= 0);
	    
	    return matches ? new ScoringRuleResult(score, diceCountAfterMatch) : new ScoringRuleResult();
	}
}
