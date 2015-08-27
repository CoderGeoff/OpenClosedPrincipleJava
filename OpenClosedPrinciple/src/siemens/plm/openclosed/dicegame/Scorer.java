package siemens.plm.openclosed.dicegame;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Scorer implements IScorer {
	private Map<Integer, Integer> diceCount;

	@Override
	public int Score(List<Integer> diceThrows) {
	    int score = 0;
	    Map<Integer, Integer> diceCount = new HashMap<Integer, Integer>();
	    Map<Integer, Integer> subtractions = new HashMap<Integer, Integer>();
		
		diceThrows.stream().forEach(value -> incrementEntry(diceCount, value, 1));

	    boolean fullStraight = true;
	    for (int diceThrow = 1; diceThrow <= 6; ++diceThrow)
	    {
	        fullStraight = fullStraight && getEntry(diceCount, diceThrow) - getEntry(subtractions, diceThrow) == 1;
	    }
	    if (fullStraight)
	    {
	        for (int diceThrow = 1; diceThrow <= 6; ++diceThrow)
	        {
	            incrementEntry(subtractions, diceThrow, 1);
	        }
	        score += 1500;
	    }

	    for (int diceThrow = 1; diceThrow <= 6; ++diceThrow)
	    {
	        int scoreMultiplier = diceThrow == 1 ? 10 : diceThrow;
	        int numberOfDice = getEntry(diceCount, diceThrow) - getEntry(subtractions, diceThrow);
	        if (numberOfDice >= 3)
	        {
	            score += (100 * scoreMultiplier) * Math.pow(2, numberOfDice - 3);
	            incrementEntry(subtractions, diceThrow, numberOfDice);
	        }
	    }

	    score += (getEntry(diceCount, 5) - subtractions.getOrDefault(5, 0)) * 50;
	    score += (getEntry(diceCount, 1) - subtractions.getOrDefault(1, 0)) * 100;

	    return score;

	}
	
	private Integer incrementEntry(Map<Integer, Integer> map, Integer key, int increment) {
		return map.put(key, getEntry(map, key) + increment);
	}

	private Integer getEntry(Map<Integer, Integer> map, Integer key) {
		return map.getOrDefault(key, 0);
	}
	
	
}
