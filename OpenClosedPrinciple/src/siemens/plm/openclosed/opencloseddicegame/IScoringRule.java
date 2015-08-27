package siemens.plm.openclosed.opencloseddicegame;

public interface IScoringRule {
	ScoringRuleResult tryMatch(int[] diceCount);
}