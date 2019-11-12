/**
 * <b>Challenger mode which inherits from GameMode</b>
 *
 * @see GameMode
 */
public class ChallengerMode extends GameMode {

    /**
     * Initialize challenger mode
     *
     * The challenger is a player
     * The defender is an artificial intelligence
     */
    public void initGameMode() {
        this.challenger = new Player();
        this.defender = new ArtificialIntelligence();
        this.gameModeMessage = "Welcome to Challenger Mode. You must guess the AI's secret combination. You have " + ApplicationProperties.INSTANCE.getPropertyTryoutNumber() + " attemps.";
    }
}
