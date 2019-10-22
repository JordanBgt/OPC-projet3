import java.util.ArrayList;
import java.util.List;

/**
 * <b>Class Combination which represent a list of numbers</b>
 *
 * <p>Class attributes :
 * <ul>
 *     <li>Size of the combination</li>
 *     <li>List of combination's values</li>
 *     <li>Type of the combination</li>
 * </ul></p>
 */
public class Combination {

    /**
     * Size of the combination. It's a data in application.properties file.
     *
     * @see ApplicationProperties
     */
    public final int COMBINATION_SIZE = ApplicationProperties.INSTANCE.getPropertyCombinationSize();


    /**
     * List of combination's values
     *
     * @see Combination#setCombinationValues(List)
     * @see Combination#getCombinationValues()
     */
    protected List<String> combinationValues = new ArrayList<>();

    /**
     * Type of the combination
     *
     * @see CombinationType
     * @see Combination#getCombinationType()
     */
    protected CombinationType combinationType;

    /**
     * Max combination's value. Combination values must be between minCombinationValue and this value.
     *
     * @see ApplicationProperties#getPropertyMaxCombinationValue()
     */
    protected Integer maxCombinationValue = ApplicationProperties.INSTANCE.getPropertyMaxCombinationValue();

    /**
     * Max combination's value. Combination values must be between maxCombinationValue and this value.
     *
     * @see ApplicationProperties#getPropertyMinCombinationValue()
     */
    protected Integer minCombinationValue = ApplicationProperties.INSTANCE.getPropertyMinCombinationValue();

    /**
     * Combination's constructor : sets the type of combination
     *
     * @param type CombinationType
     * @see CombinationType
     */
    public Combination(CombinationType type){
        this.combinationType = type;
    }

    /**
     * @return the combination's values
     */
    public List<String> getCombinationValues() {
        return combinationValues;
    }

    /**
     * @param combinationValues
     * 			ArrayList of Integers
     */
    public void setCombinationValues(List<String> combinationValues) {
        this.combinationValues = combinationValues;
    }

    /**
     * @return the type of the combination
     * @see CombinationType
     */
    public CombinationType getCombinationType() {
        return combinationType;
    }

    public int getCOMBINATION_SIZE() {
        return COMBINATION_SIZE;
    }

}
