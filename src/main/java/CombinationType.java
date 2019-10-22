/**
 * <b>Enum which represents the type of the combination and its message</b>
 *
 * <p>Secret for the combination to make guess</p>
 * <p>Proposed for a guess try</p>
 * <p>Answered for the response to the proposed combination</p>
 */
public enum CombinationType {

    SECRET ("Key in secret combination : " + ApplicationProperties.INSTANCE.getPropertyCombinationSize() +
            " numbers between " + ApplicationProperties.INSTANCE.getPropertyMinCombinationValue() + " and " +
            ApplicationProperties.INSTANCE.getPropertyMaxCombinationValue() + ", separates with \",\""),

    PROPOSED ("Key in proposed combination : " + ApplicationProperties.INSTANCE.getPropertyCombinationSize() +
            " numbers between " + ApplicationProperties.INSTANCE.getPropertyMinCombinationValue() + " and " +
            ApplicationProperties.INSTANCE.getPropertyMaxCombinationValue() + ", separates with \",\""),

    ANSWERED ("Please check Challenger's combination : \"+\" if secret number is greater, \"-\" if it's less" +
            "or \"=\" if both numbers are equals. Separate each values with \",\". Example : \"+,-,-,=\"");

    CombinationType(String message){
        this.message = message;
    }

    private String message;

    public String getMessage(){
        return message;
    }
}
