import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * <b>ArticialIntelligence Class which inherits from Actor</b>
 *
 * <p>Attributes : </p>
 * <ul>
 *     <li>Random object</li>
 *     <li>List of ranges for each proposed combination's values</li>
 * </ul>
 *
 * <p>It overrides :
 * <ul>
 *     <li>setAnsweredCombination</li>
 *     <li>setProposedCombination</li>
 * </ul></p>
 * <p>setProposedCombination(Combination answeredCombination)</p>
 */
public class ArtificialIntelligence extends Actor{

    /**
     * Random object in order to set randomly the AI's secret combination
     */
    private Random rand = new Random();

    /**
     * List of ranges for each proposed combination's values. For each values,
     * AI choose a number between min and max value of the range
     */
    private List<HashMap<String, Integer>> rangeProposedCombinationValues = new ArrayList<>();

    /**
     * It fills the list of ranges with the lower and the upper combination values
     */
    public ArtificialIntelligence(){
        for(int i = 0; i < ApplicationProperties.INSTANCE.getPropertyTotalCombinationNumber() ; i++){
            HashMap<String, Integer> minMax = new HashMap<>();
            minMax.put("min", ApplicationProperties.INSTANCE.getPropertyMinCombinationValue());
            minMax.put("max", ApplicationProperties.INSTANCE.getPropertyMaxCombinationValue() + 1);
            this.rangeProposedCombinationValues.add(minMax);
        }
    }

    /**
     * It checks, for each values of the challenger's combination, if they are greater, less or equals to secret
     * combination's values
     *
     * @param challengerCombination
     *                  Combination made by the challenger
     */
    @Override
    public void setAnsweredCombination(Combination challengerCombination) {
        List<String> secretCombinationValues = this.secretCombination.getCombinationValues();
        List<String> challengerCombinationValues = challengerCombination.getCombinationValues();
        List<String> answeredCombinationValues = new ArrayList<>();
        for (int i = 0; i < secretCombination.getCombinationValues().size(); i++){
            if(Integer.parseInt(secretCombinationValues.get(i)) > Integer.parseInt(challengerCombinationValues.get(i))){
                answeredCombinationValues.add("+");
            }
            else if(Integer.parseInt(secretCombinationValues.get(i)) < Integer.parseInt(challengerCombinationValues.get(i))){
                answeredCombinationValues.add("-");
            }
            else{
                answeredCombinationValues.add("=");
            }
        }
        this.answeredCombination.setCombinationValues(answeredCombinationValues);
    }

    /**
     * set the proposed combination compared to the defender's answered combination.
     * If answeredCombination isn't empty or null, it update the range compared to answeredCombination's values.
     * It uses binary search algorithm to find the secret combination
     *
     * @param answeredCombination
     *          answered combination made by the defender after the first challenger's proposed combination
     * @see ArtificialIntelligence#findMiddleValue(int, int)
     */
    public void setProposedCombination(Combination answeredCombination) {

        if((answeredCombination.getCombinationValues() != null) && (!answeredCombination.getCombinationValues().isEmpty())){
            List<String> answerValues = answeredCombination.getCombinationValues();
            List<String> proposedCombinationValues = this.getProposedCombination().getCombinationValues();
            List<String> newProposition = new ArrayList<>();
            for (int i = 0; i < answerValues.size(); i++) {
                if ("+".equals(answerValues.get(i))) {
                    this.rangeProposedCombinationValues.get(i).put("min", Integer.parseInt(proposedCombinationValues.get(i)));
                    newProposition.add(String.valueOf(this.findMiddleValue(this.rangeProposedCombinationValues.get(i).get("min"), (this.rangeProposedCombinationValues.get(i).get("max")))));
                    System.out.println(this.rangeProposedCombinationValues.get(i));
                } else if ("=".equals(answerValues.get(i))) {
                    newProposition.add(proposedCombinationValues.get(i));
                } else if ("-".equals(answerValues.get(i))) {
                    this.rangeProposedCombinationValues.get(i).put("max", Integer.parseInt(proposedCombinationValues.get(i)));
                    newProposition.add(String.valueOf(this.findMiddleValue(this.rangeProposedCombinationValues.get(i).get("min"), this.rangeProposedCombinationValues.get(i).get("max"))));
                    System.out.println(this.rangeProposedCombinationValues.get(i));
                }
                this.proposedCombination.setCombinationValues(newProposition);
            }
        }
        else{
            List<String> proposedCombinationValues = new ArrayList<>();
            for (int i = 1; i <= this.proposedCombination.getCOMBINATION_SIZE(); i++){
                proposedCombinationValues.add(String.valueOf(this.findMiddleValue(this.proposedCombination.minCombinationValue, this.proposedCombination.maxCombinationValue +1)));
            }
            this.proposedCombination.setCombinationValues(proposedCombinationValues);
        }

    }

    /**
     * Sets randomly secret combination's values
     *
     * Numbers between 0 and 9
     * @see Combination
     */
    @Override
    public void setSecretCombination() {
        List<String> secretCombinationValues = new ArrayList<>();
        for (int i = 1; i <= this.secretCombination.COMBINATION_SIZE; i++){
            secretCombinationValues.add(String.valueOf(this.getRandomNumber(this.secretCombination.maxCombinationValue)));
        }
        this.secretCombination.setCombinationValues(secretCombinationValues);
    }

    /**
     * It returns the middle value between a and b.
     *
     * @param a lower value
     * @param b upper value
     * @return int
     */
    public int findMiddleValue(int a, int b) {
        return (a + b)/2;
    }

    /**
     * It returns int value between 0 (inclusive) and bound value (inclusive).
     *
     * @param bound (bound -1) = max random value
     * @return Integer
     */
    public Integer getRandomNumber(Integer bound){
        return rand.nextInt(bound + 1);
    }

}
