import java.util.ArrayList;

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
    public static int COMBINATION_SIZE = ApplicationProperties.INSTANCE.getPropertyTotalCombinationNumber();

    /**
     * List of combination's values
     *
     * @see Combination#setCombinationValues(ArrayList)
     * @see Combination#getCombinationValues()
     */
    private ArrayList<String> combinationValues = new ArrayList<String>();

    /**
     * Type of the combination
     *
     * @see CombinationType
     * @see Combination#setCombinationType(CombinationType)
     * @see Combination#getCombinationType()
     */
    private CombinationType combinationType;

    /**
     * Max combination's value. Combination values must be between 0 and this value.
     *
     * @see ApplicationProperties#getPropertyMaxCombinationValue()
     */
    public static Integer MAX_COMBINATION_VALUE = ApplicationProperties.INSTANCE.getPropertyMaxCombinationValue();

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
    public ArrayList<String> getCombinationValues() {
        return combinationValues;
    }


    /**
     * Adds a value to combinationValues
     *
     * @param value
     * 			Integer
     * @throws IllegalArgumentException
     * 			If we try to add more than the size of the combination
     * @see Combination#COMBINATION_SIZE
     */
    public void addCombinationValue(String value){
        if(combinationValues.size() == COMBINATION_SIZE){
            throw new IllegalArgumentException("Combination can't have more than "+ COMBINATION_SIZE + "values");
        }
        else{
            this.combinationValues.add(value);
        }
    }

    /**
     * @param combinationValues
     * 			ArrayList of Integers
     */
    public void setCombinationValues(ArrayList<String> combinationValues) {
        this.combinationValues = combinationValues;
    }

    /**
     * @return the type of the combination
     * @see CombinationType
     */
    public CombinationType getCombinationType() {
        return combinationType;
    }

    /**
     * @param combinationType
     * 			An instance of CombinationType
     * @see CombinationType
     */
    public void setCombinationType(CombinationType combinationType) {
        this.combinationType = combinationType;
    }

}
