package siemens.plm.openclosed.opencloseddicegame;

import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.IntStream;

public class NOfAKindScoresXRule implements IScoringRule {

	private Function<Integer, Boolean> valuePredicate;
	private int count;
	private Function<Integer, Integer> scoreEvaluator;

	public NOfAKindScoresXRule(Function<Integer, Boolean> valuePredicate, int count, Function<Integer, Integer> scoreEvaluator) {
        this.valuePredicate = valuePredicate;
        this.count = count;
        this.scoreEvaluator = scoreEvaluator;
	}

	@Override
	public ScoringRuleResult tryMatch(int[] diceCount) {	    
	    OptionalInt matchingDice = IntStream.range(1, 7).filter(dice -> valuePredicate.apply(dice) && diceCount[dice] >= count).findFirst();
	    
	    if (matchingDice.isPresent()) {
	    	int matchingDiceValue = matchingDice.getAsInt();
		    int[] diceCountAfterApplyingRule = diceCount.clone();
	    	diceCountAfterApplyingRule[matchingDiceValue] -= count;
	    	return new ScoringRuleResult(scoreEvaluator.apply(matchingDiceValue), diceCountAfterApplyingRule);
	    }
	    
		return new ScoringRuleResult();
	}

}
