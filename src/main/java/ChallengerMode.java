public class ChallengerMode extends GameMode {

    public ChallengerMode() {
        this.challenger = new Player();
        this.defender = new ArtificialIntelligence();
        this.gameModeMessage = "Welcome to Challenger Mode. You must guess the AI's secret combination. You have " + ApplicationProperties.INSTANCE.getPropertyTryoutNumber() + " attemps.";
    }
}
