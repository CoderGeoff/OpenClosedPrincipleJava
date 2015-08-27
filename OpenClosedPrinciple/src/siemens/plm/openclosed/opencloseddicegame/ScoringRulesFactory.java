package siemens.plm.openclosed.opencloseddicegame;

import java.util.function.Function;

public class ScoringRulesFactory {

	public IScoringRule[] createRules() 
	{
	    Function<Integer, Boolean> twoToSixPredicate = n ->  n != 1;

	    IScoringRule six1sScore8000 = new PatternScoresXRule(new int[] { 1, 1, 1, 1, 1, 1 }, 8000);
	    IScoringRule five1sScore4000 = new PatternScoresXRule(new int[] { 1, 1, 1, 1, 1 }, 4000);
	    IScoringRule four1sScore2000 = new PatternScoresXRule(new int[] { 1, 1, 1, 1 }, 2000);
	    IScoringRule three1sScore1000 = new PatternScoresXRule(new int[] { 1, 1, 1 }, 1000);
	    IScoringRule six2sTo6sScore800TimesDiceValue = new NOfAKindScoresXRule(twoToSixPredicate, 6, n -> 800 * n);
	    IScoringRule five2sTo6sScore400TimesDiceValue = new NOfAKindScoresXRule(twoToSixPredicate, 5, n -> 400 * n);
	    IScoringRule four2sTo6sScore200TimesDiceValue = new NOfAKindScoresXRule(twoToSixPredicate, 4, n -> 200 * n);
	    IScoringRule three2sTo6sScore100TimesDiceValue = new NOfAKindScoresXRule(twoToSixPredicate, 3, n -> 100 * n);
	    IScoringRule straightFlushScores1500 = new PatternScoresXRule(new int[] { 1, 2, 3, 4, 5, 6 }, 1500);
	    IScoringRule single1Scores100 = new PatternScoresXRule(new int[] { 1 }, 100);
	    IScoringRule single5Scores50 = new PatternScoresXRule(new int[] { 5 }, 50);

	    return new IScoringRule[] {
	        six1sScore8000,
	        five1sScore4000,
	        four1sScore2000,
	        three1sScore1000,
	        six2sTo6sScore800TimesDiceValue,
	        five2sTo6sScore400TimesDiceValue,
	        four2sTo6sScore200TimesDiceValue,
	        three2sTo6sScore100TimesDiceValue,
	        straightFlushScores1500,
	        single1Scores100,
	        single5Scores50
	    };
	}
}
