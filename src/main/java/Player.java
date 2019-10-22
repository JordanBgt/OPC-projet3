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
    private Scanner sc = new Scanner(System.in);

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
     * It fills values of a combination with player's entries
     *
     * @param combination
     *          player combination : secret, proposed or answered
     */
    public void askPlayerToSetCombinationValues(Combination combination){
        System.out.println(combination.getCombinationType().getMessage());
        String entry = sc.nextLine();
        String[] entryValues = entry.split(",");
        combination.setCombinationValues(Arrays.asList(entryValues));
    }
}
