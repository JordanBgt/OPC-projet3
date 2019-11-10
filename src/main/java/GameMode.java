import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * <b>Absract class which represents game modes</b>
 *
 * @see ChallengerMode
 * @see DefenderMode
 * @see DuelMode
 */
public abstract class GameMode {

    /**
     * Number of attempts to resolve the game
     *
     * @see ApplicationProperties
     */
    protected int tryoutNumber = ApplicationProperties.INSTANCE.getPropertyTryoutNumber();

    /**
     * A challenger who must guess the defender' secret combination
     *
     * @see Actor
     */
    protected Actor challenger;

    /**
     * A defender who must set the secret combination
     *
     * @see Actor
     */
    protected Actor defender;

    /**
     * Boolean, true if the game is resolve
     */
    protected boolean resolve = false;

    /**
     * Message that introduces the game mode
     */
    protected String gameModeMessage;

    /**
     * If it's true, it displays the secret combination
     *
     * @see ApplicationProperties
     */
    protected boolean devMode = Boolean.parseBoolean(ApplicationProperties.INSTANCE.getPropertyDevMode());

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger(GameMode.class);

    /**
     * Scanner for ask player to key in combination
     */
    private final Scanner SCANNER = new Scanner(System.in);

    public GameMode(){
    }

    /**
     * Initialize the game mode
     *
     * @see ChallengerMode#initGameMode()
     * @see DefenderMode#initGameMode()
     * @see DuelMode#initGameMode()
     */
    public abstract void initGameMode();

    /**
     * It contains the game mode logic.
     * Same method for challenger mode and defender mode : only type of challenger and defender are different.
     *
     * @see ChallengerMode#play()
     * @see DefenderMode#play()
     * @see DuelMode#play()
     */
    public void play(){
        this.initGameMode();
        this.defender.setSecretCombination();
        if(devMode){
            LOGGER.info("La combinaison secrète est : " + this.defender.getSecretCombination().getCombinationValues());
        }
        Combination secretCombination = this.defender.getSecretCombination();
        do {
            this.decrementTryOutNumber();
            this.challenger.setProposedCombination(this.defender.getAnsweredCombination());
            Combination proposedCombination = this.challenger.getProposedCombination();
            this.defender.setAnsweredCombination(proposedCombination);
            checkIfCombinationAreEquals(proposedCombination, secretCombination);
        } while ((this.tryoutNumber  != 0) && (!isResolve()));
        System.out.println(Messages.GAMEOVER.getMessage());
        if(resolve){
            System.out.println("Challenger wins !");
        }
        else{
            System.out.println("Defender wins ! The secret combination was : " + this.defender.getSecretCombination().getCombinationValues());
        }
        this.displayEndGameChoices();
    }

    /**
     * it decrements attempts number
     */
    public void decrementTryOutNumber(){
        this.tryoutNumber--;
    }

    /**
     * Check if the challenger has guessed the secret combination of the defender
     *
     * @param proposedCombination combination proposed by the challenger
     * @param secretCombination defender' secret combination
     */
    public void checkIfCombinationAreEquals(Combination proposedCombination, Combination secretCombination){
        this.setResolve(proposedCombination.getCombinationValues().equals(secretCombination.getCombinationValues()));
    }

    public boolean isResolve() {
        return resolve;
    }

    public void setResolve(boolean bool) {
        this.resolve = bool;
    }

    public String getGameModeMessage() {
        return gameModeMessage;
    }

    public boolean isDevMode() {
        return devMode;
    }

    /**
     * Display a choose menu at the end of the game
     */
    public void displayEndGameChoices(){
        System.out.println("Please select an option : ");
        System.out.println("    1-> Try again");
        System.out.println("    2-> Game modes menu");
        System.out.println("    3-> Exit");
        int entry = SCANNER.nextInt();
        if(entry == 1){
            this.play();
        }
        if(entry == 3){
            Game.exitGame();
        }
    }
}
