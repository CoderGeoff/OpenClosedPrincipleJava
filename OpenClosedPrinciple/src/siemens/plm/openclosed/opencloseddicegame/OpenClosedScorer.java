package siemens.plm.openclosed.opencloseddicegame;

import java.util.List;

import siemens.plm.openclosed.dicegame.IScorer;


public class OpenClosedScorer implements IScorer {

	private IScoringRule[] rules;

	public OpenClosedScorer(IScoringRule[] rules) {
		this.rules = rules;
	}

	@Override
	public int Score(List<Integer> diceThrows) {
	    int score = 0;
	    int[] diceCount = countDice(diceThrows);
	    
	    for (IScoringRule rule : rules)
	    {
	        for (ScoringRuleResult ruleResult = rule.tryMatch(diceCount); ruleResult.isMatched(); ruleResult = rule.tryMatch(diceCount))
	        {
	            score += ruleResult.getScore();
	            diceCount = ruleResult.getRemainingDiceCount();
	        }
	    }
	    return score;
	}

	private int[] countDice(List<Integer> diceThrows) {
		int[] count = new int[7];
		diceThrows.stream().forEach(n -> count[n]++);
		return count;
	}

}
