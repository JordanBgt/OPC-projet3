/**
 * <b>Abstract Class which represent a player or an artificial intelligence</b>
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
     * @see Actor#setProposedCombination(Combination)
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
     * Abstract method to set an answer based on the challenger's combination
     *
     * @param challengerCombination
     *              Combination made by the challenger
     * @see Player#setAnsweredCombination(Combination)
     * @see ArtificialIntelligence#setAnsweredCombination(Combination)
     */
    public abstract void setAnsweredCombination(Combination challengerCombination);

    /**
     * Abstract method to set a proposed combination based on the defender's combination
     *
     * @param answeredCombination
     *              Combination made by the defender
     * @see Player#setProposedCombination(Combination)
     * @see ArtificialIntelligence#setProposedCombination(Combination)
     */
    public abstract void setProposedCombination(Combination answeredCombination);

    /**
     * Abstract method to set a secret combination
     *
     * @see Combination
     * @see Player#setSecretCombination()
     * @see ArtificialIntelligence#setSecretCombination()
     */
    public abstract void setSecretCombination();


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
