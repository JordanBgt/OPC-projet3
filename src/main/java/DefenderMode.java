public class DefenderMode extends GameMode{

    public DefenderMode(ArtificialIntelligence challenger, Player defender) {
        super(challenger, defender);
        setGameModeMessage("Welcome to Defender Mode : you must define a secret Combination. AI has " + ApplicationProperties.INSTANCE.getPropertyTryoutNumber() + " attempts to guess it.");
    }
}
