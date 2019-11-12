/**
 * <b>Defender mode which inherits from GameMode</b>
 *
 * @see GameMode
 */
public class DefenderMode extends GameMode{

    /**
     * Initialize defender mode
     *
     * The challenger is an artificial intelligence
     * The defender is a player
     */
    public void initGameMode() {
        this.challenger = new ArtificialIntelligence();
        this.defender = new Player();
        this.gameModeMessage = "Welcome to Defender Mode : you must define a secret Combination. AI has " + ApplicationProperties.INSTANCE.getPropertyTryoutNumber() + " attempts to guess it.";
    }
}
