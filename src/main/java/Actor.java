import java.util.Random;

/**
 * <b>Abstract Class wich represent a player or an artifial intelligence</b>
 * @see Player
 * @see ArtificialIntelligence
 *
 * <p>Class Attributes :
 * <ul>
 *     <li>A secret combination</li>
 *     <li>A proposed combination</li>
 *     <li>An answer to player's or artificial intelligence's proposed combination</li>
 * </ul>
 * </p>
 */
public abstract class Actor {

    /**
     * The secret combination that actor has to make someone guess
     *
     * @see Combination
     * @see Actor#setSecretCombination()
     * @see Actor#getSecretCombination()
     */
    protected Combination secretCombination = new Combination(CombinationType.SECRET);

    /**
     * The proposed combination that actor makes
     *
     * @see Combination
     * @see Actor#setProposedCombination()
     * @see Actor#getProposedCombination()
     */
    protected Combination proposedCombination = new Combination(CombinationType.PROPOSED);

    /**
     * The actor's answer to a proposed combination
     *
     * @see Combination
     * @see Actor#setAnsweredCombination(Combination)
     * @see Actor#getAnsweredCombination()
     */
    protected Combination answeredCombination = new Combination(CombinationType.ANSWERED);

    /**
     * Object Random
     *
     * @see Actor#getRandomNumber(Integer)
     * @see Actor#getRandomNumberInRange(Integer, Integer)
     */
    protected Random rand = new Random();

    /**
     * Abstract method to set an answer based on the challenger's combination
     *
     * @param challengerCombination
     *                  Combination made by the challenger
     * @see Player#setAnsweredCombination(Combination)
     * @see ArtificialIntelligence#setAnsweredCombination(Combination)
     */
    public abstract void setAnsweredCombination(Combination challengerCombination);

    /**
     * Abstract method to set a proposed combination
     *
     * @see Player#setProposedCombination()
     * @see ArtificialIntelligence#setProposedCombination()
     */
    public abstract void setProposedCombination();

    /**
     * Sets randomly secret combination's values
     *
     * Numbers between 0 and 9
     * @see Combination
     */
    public void setSecretCombination() {
        for (int i = 1; i <= Combination.COMBINATION_SIZE; i++){
            this.getSecretCombination().addCombinationValue(String.valueOf(this.getRandomNumber(Combination.MAX_COMBINATION_VALUE)));
        }
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

    /**
     * It returns int value between lower (exlusive) and upper (inclusive). We will use this method only when a
     * secret value is greater than the proposal value. So, new value must be between proposal value + 1 (exlusive) and
     * maximum value + 1 (inclusive)
     *
     * @param lower min value
     * @param upper max value
     * @return Integer
     */
    public Integer getRandomNumberInRange(Integer lower, Integer upper){
        lower++;
        upper++;
        return (rand.nextInt(upper - lower) + lower);
    }

    /**
     * @return actor's secret combination
     */
    public Combination getSecretCombination() {
        return secretCombination;
    }

    /**
     * @return actor's proposed combination
     */
    public Combination getProposedCombination() {
        return proposedCombination;
    }

    /**
     * @return actor's answer
     */
    public Combination getAnsweredCombination() {
        return answeredCombination;
    }
}
