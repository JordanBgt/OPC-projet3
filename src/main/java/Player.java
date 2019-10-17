import java.util.Scanner;

/**
 * <b>Player Class which inherits from Actor</b>
 *
 * <p>It overrides :
 * <ul>
 *     <li>setAnsweredCombination</li>
 *     <li>setProposedCombination</li>
 * </ul></p>
 */
public class Player extends Actor {

    /**
     * Ask the player to set an answer to the challenger's proposed combination
     * Check, for each proposed combination's values, if they are greater, less or equals to secret combination's values
     *
     * @param challengerCombination
     *                  Combination made by the challenger
     */
    @Override
    public void setAnsweredCombination(Combination challengerCombination) {
        System.out.println("Yours secret combination : "+this.secretCombination.getCombinationValues());
        System.out.println("Challenger's combination : "+challengerCombination.getCombinationValues());
        System.out.println("Please check Challenger's combination : \"+\" if secret number is greater, " +
                "\"-\" if secret number is less, or \"=\" if both numbers are equals. Separate each value with \",\". Example : \"+,-,-,=\"");
        Scanner sc = new Scanner(System.in);
        String entry = sc.nextLine();
        String[] str = entry.split(",");
        for (String s : str) {
            this.answeredCombination.addCombinationValue(s);
        }
    }

    /**
     * Ask the player to set a proposed combination to guess the secret combination
     */
    @Override
    public void setProposedCombination() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Key in a "+Combination.COMBINATION_SIZE+" numbers combination (between 0 and 9), separates with \",\"");
        String entry = sc.nextLine();
        String[] entryValues = entry.split(",");
        for (String s : entryValues){
            this.proposedCombination.addCombinationValue(s);
        }
    }
}
