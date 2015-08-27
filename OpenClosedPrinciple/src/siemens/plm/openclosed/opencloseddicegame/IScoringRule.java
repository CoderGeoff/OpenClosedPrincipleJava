package siemens.plm.openclosed.opencloseddicegame;

import java.util.Map;

public interface IScoringRule {
	ScoringRuleResult tryMatch(Map<Integer, Integer> diceCount);
}