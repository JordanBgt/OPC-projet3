import java.util.ArrayList;

/**
 * <b>ArticialIntelligence Class which inherits from Actor</b>
 *  *
 *  * <p>It overrides :
 *  * <ul>
 *  *     <li>setAnsweredCombination</li>
 *  *     <li>setProposedCombination</li>
 *  * </ul></p>
 *  <p>setProposedCombination(Combination answeredCombination)</p>
 */
public class ArtificialIntelligence extends Actor{

    /**
     * It checks, for each values of the challenger's combination, if they are greater, less or equals to secret
     * combination's values
     *
     * @param challengerCombination
     *                  Combination made by the challenger
     */
    @Override
    public void setAnsweredCombination(Combination challengerCombination) {
        ArrayList<String> secretCombinationValues = this.secretCombination.getCombinationValues();
        ArrayList<String> challengerCombinationValues = challengerCombination.getCombinationValues();
        for (int i = 0; i < secretCombination.getCombinationValues().size(); i++){
            if(Integer.parseInt(secretCombinationValues.get(i)) > Integer.parseInt(challengerCombinationValues.get(i))){
                this.answeredCombination.addCombinationValue("+");
            }
            else if(Integer.parseInt(secretCombinationValues.get(i)) < Integer.parseInt(challengerCombinationValues.get(i))){
                this.answeredCombination.addCombinationValue("-");
            }
            else{
                this.answeredCombination.addCombinationValue("=");
            }
        }
    }

    /**
     * Set randomly the first proposed combination
     */
    @Override
    public void setProposedCombination() {
        for (int i = 1; i <= Combination.COMBINATION_SIZE; i++){
            this.getProposedCombination().addCombinationValue(String.valueOf(this.getRandomNumber(Combination.MAX_COMBINATION_VALUE)));
        }
    }

    /**
     * set the proposed combination compared to the defender's answered combination
     *
     * @param answeredCombination
     *          answered combination made by the defender after the first challenger's proposed combination
     */
    public void setProposedCombination(Combination answeredCombination) throws Exception {
        ArrayList<String> answerValues = answeredCombination.getCombinationValues();
        ArrayList<String> proposedCombinationValues = this.getProposedCombination().getCombinationValues();
        ArrayList<String> newProposition = new ArrayList<String>();
        for (int i = 0; i < answerValues.size(); i++) {
            if ("-".equals(answerValues.get(i))) {
                newProposition.add(String.valueOf(this.getRandomNumber(Integer.parseInt(proposedCombinationValues.get(i)))));
            } else if ("=".equals(answerValues.get(i))) {
                newProposition.add(proposedCombinationValues.get(i));
            } else if ("+".equals(answerValues.get(i))) {
                newProposition.add(String.valueOf(this.getRandomNumberInRange(Integer.parseInt(proposedCombinationValues.get(i)), 9)));
            } else {
                throw new Exception("Error, proposedCombination is false");
            }
            this.proposedCombination.setCombinationValues(newProposition);
        }
    }

}
