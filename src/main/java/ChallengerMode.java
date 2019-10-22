public class ChallengerMode extends GameMode {

    public ChallengerMode(Player challenger, ArtificialIntelligence defender) {
        super(challenger, defender);
        setGameModeMessage("Welcome to Challenger Mode. You must guess the AI's secret combination. You have " + ApplicationProperties.INSTANCE.getPropertyTryoutNumber() + " attemps.");
    }
}
