import java.util.Arrays;
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
     * Scanner to read user's entries
     */
    private final Scanner SCANNER = new Scanner(System.in);

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
        this.askPlayerToSetCombinationValues(this.answeredCombination);
    }

    /**
     * Ask the player to set a proposed combination in order to guess the secret combination
     */
    @Override
    public void setProposedCombination(Combination answeredCombination) {
        if((answeredCombination.getCombinationValues() != null) && (!answeredCombination.getCombinationValues().isEmpty())){
            System.out.println("AI's answered combination : " + answeredCombination.getCombinationValues());
            if((this.getProposedCombination().getCombinationValues() != null) && (!this.getProposedCombination().getCombinationValues().isEmpty())){
                System.out.println("Your previous answer : " + this.getProposedCombination().getCombinationValues());
            }
        }
        this.askPlayerToSetCombinationValues(this.proposedCombination);
    }

    /**
     * Ask the player to set a secret combination
     */
    public void setSecretCombination() {

        this.askPlayerToSetCombinationValues(this.secretCombination);
    }

    /**
     * Ask the player to key in values to fill a combination
     *
     * @param combination
     *          player combination : secret, proposed or answered
     */
    public void askPlayerToSetCombinationValues(Combination combination) {
        String entry;
        do{
            System.out.println(combination.getCombinationType().getMessage());
            entry = SCANNER.nextLine();
        } while(!this.isEntryValid(entry,combination));
        String[] entryValues = entry.split(",");
        combination.setCombinationValues(Arrays.asList(entryValues));
    }

    /**
     * Check if the user's entry matches with the combination's pattern
     *
     * @param userEntry
     *          entry key in by the user
     * @param combination
     *          the combination that the player must fill
     * @return boolean
     */
    public boolean isEntryValid(String userEntry, Combination combination) {
        if(combination.getCombinationType() == CombinationType.ANSWERED){
            if(userEntry.matches(combination.getAnsweredCombinationPattern())){
                return true;
            }
        } else {
            if(userEntry.matches(combination.getCombinationPattern())){
                return true;
            }
        }
        System.out.println("Be careful, the combination does not respect the expected format");
        return false;
    }
}
