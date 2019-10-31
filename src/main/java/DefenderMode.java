public class DefenderMode extends GameMode{

    @Override
    public void initGameMode() {
        this.challenger = new ArtificialIntelligence();
        this.defender = new Player();
        this.gameModeMessage = "Welcome to Defender Mode : you must define a secret Combination. AI has " + ApplicationProperties.INSTANCE.getPropertyTryoutNumber() + " attempts to guess it.";
    }
}
