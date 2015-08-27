package siemens.plm.openclosed.opencloseddicegame;

import java.util.function.Function;

public class NOfAKindScoringRule implements IScoringRule {

	private Function<Integer, Boolean> valuePredicate;
	private int count;
	private Function<Integer, Integer> scoreEvaluator;

	public NOfAKindScoringRule(Function<Integer, Boolean> valuePredicate, int count, Function<Integer, Integer> scoreEvaluator) {
        this.valuePredicate = valuePredicate;
        this.count = count;
        this.scoreEvaluator = scoreEvaluator;
	}

	@Override
	public ScoringRuleResult tryMatch(int[] diceCount)
	{
	    int[] diceCountAfterApplyingRule = diceCount.clone();
	    
	    for (int n = 1; n <= 6; ++n)
		{
			int diceCountRemaining = diceCountAfterApplyingRule[n];
			if (valuePredicate.apply(n) && diceCountRemaining >= count)
			{
				diceCountAfterApplyingRule[n]--;
				return new ScoringRuleResult(scoreEvaluator.apply(n), diceCountAfterApplyingRule);
			}
		}
		return new ScoringRuleResult();
	}
}
