package siemens.plm.openclosed.dicegame;

import java.util.List;

public class Scorer implements IScorer {

	@Override
	public int Score(List<Integer> diceThrows) {
	    int score = 0;
	    int[] diceCount = new int[7];
	    int[] subtractions = new int[7];
		
		diceThrows.stream().forEach(value -> diceCount[value]++);

	    boolean fullStraight = true;
	    for (int diceThrow = 1; diceThrow <= 6; ++diceThrow) {
	        fullStraight = fullStraight && diceCount[diceThrow] - subtractions[diceThrow] == 1;
	    }
	    if (fullStraight) {
	        for (int diceThrow = 1; diceThrow <= 6; ++diceThrow)
	        {
	            subtractions[diceThrow]++;
	        }
	        score += 1500;
	    }

	    for (int diceThrow = 1; diceThrow <= 6; ++diceThrow) {
	        int scoreMultiplier = diceThrow == 1 ? 10 : diceThrow;
	        int numberOfDice = diceCount[diceThrow] - subtractions[diceThrow];
	        if (numberOfDice >= 3) {
	            score += (100 * scoreMultiplier) * Math.pow(2, numberOfDice - 3);
	            subtractions[diceThrow] += numberOfDice;
	        }
	    }

	    score += (diceCount[5] - subtractions[5]) * 50;
	    score += (diceCount[1] - subtractions[1]) * 100;

	    return score;

	}
}
