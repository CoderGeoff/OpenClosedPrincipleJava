package siemens.plm.openclosed.dicegame.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import siemens.plm.openclosed.dicegame.IScorer;
import siemens.plm.openclosed.dicegame.Scorer;
import siemens.plm.openclosed.opencloseddicegame.OpenClosedScorer;
import siemens.plm.openclosed.opencloseddicegame.ScoringRulesFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ScorerTests<T> {
    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ new Scorer() }, 
        		{ new OpenClosedScorer(new ScoringRulesFactory().createRules()) }
        		});
    }
    @Parameter
    public IScorer scorer;
    
	@Test 
	public void givenOneDie_WhenFiveIsThrown_ScoreShouldBe50() {
		List<Integer> dice = Arrays.asList(5);
		int score = scorer.Score(dice);
		assertEquals(50, score);
	}

	@Test 
	public void givenOneDie_WhenOneIsThrown_ScoreShouldBe100()
	{
		List<Integer> dice = Arrays.asList(1);
		int score = scorer.Score(dice);
		assertEquals(100, score);
	}

	@Test 
	public void givenThreeDie_WhenAllOnesAreThrown_ScoreShouldBe1000() {
		List<Integer> dice = Arrays.asList(1, 1, 1);
		int score = scorer.Score(dice);
		assertEquals(1000, score);
	}

	@Test 
	public void givenThreeDie_WhenAllTwosAreThrown_ScoreShouldBe200() {
		List<Integer> dice = Arrays.asList(2, 2, 2);
		int score = scorer.Score(dice);
		assertEquals(200, score);
	}

	@Test 
	public void givenThreeDie_WhenAllSixesAreThrown_ScoreShouldBe600() {
		List<Integer> dice = Arrays.asList(6, 6, 6);
		int score = scorer.Score(dice);
		assertEquals(600, score);
	}

	@Test 
	public void givenFourDie_WhenAllSixesAreThrown_ScoreShouldBe1200() {
		List<Integer> dice = Arrays.asList(6, 6, 6, 6);
		int score = scorer.Score(dice);
		assertEquals(1200, score);
	}

	@Test 
	public void givenFiveDie_WhenAllOnesAreThrown_ScoreShouldBe4000() {
		List<Integer> dice = Arrays.asList(1, 1, 1, 1, 1);
		int score = scorer.Score(dice);
		assertEquals(4000, score);
	}

	@Test 
	public void givenSixDie_WhenAllThreesAreThrown_ScoreShouldBe2400() {
		List<Integer> dice = Arrays.asList(3, 3, 3, 3, 3, 3);
		int score = scorer.Score(dice);
		assertEquals(2400, score);
	}

	@Test 
	public void givenTwoDie_WhenTwoFivesAreThrownn_ScoreShouldBe100() {
		List<Integer> dice = Arrays.asList(5, 5);
		int score = scorer.Score(dice);
		assertEquals(100, score);
	}

	@Test 
	public void givenTwoDie_WhenTwoOnesAreThrown_ScoreShouldBe200() {
		List<Integer> dice = Arrays.asList(1, 1);
		int score = scorer.Score(dice);
		assertEquals(200, score);
	}

	@Test 
	public void givenSixDie_FullStraight_ScoreShouldBe1500() {
		List<Integer> dice = Arrays.asList(1, 2, 3, 4, 5, 6);
		int score = scorer.Score(dice);
		assertEquals(1500, score);
	}

}
