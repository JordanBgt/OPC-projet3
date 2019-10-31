import org.apache.log4j.Logger;

public class DuelMode extends GameMode {

    private Player player;
    private ArtificialIntelligence artificialIntelligence;
    private static final Logger LOGGER = Logger.getLogger(DuelMode.class);
    private String winner = "AI";

    public DuelMode() {
        this.player = new Player();
        this.artificialIntelligence = new ArtificialIntelligence();
        this.gameModeMessage = "Welcome to Duel Mode. To win : guess AI' secret combination before it !";
    }

    @Override
    public void play() {
        System.out.println(this.getGameModeMessage());
        this.player.setSecretCombination();
        System.out.println("player secret combination : " + this.player.getSecretCombination().getCombinationValues());
        this.artificialIntelligence.setSecretCombination();
        if(isDevMode()){
            LOGGER.info("AI' secret combination : " + this.artificialIntelligence.getSecretCombination().getCombinationValues());
        }
        do{
            this.setProposedCombinations();
            this.setAnsweredCombination();
        } while(!this.isResolve());
        System.out.println("Game over, " + this.winner + " wins !");
        System.out.println("AI' secret combination was : " + this.artificialIntelligence.getSecretCombination().getCombinationValues());
        System.out.println("Player' secret combination was : " + this.player.getSecretCombination().getCombinationValues());
    }

    public void setProposedCombinations(){
        this.player.setProposedCombination(this.artificialIntelligence.getAnsweredCombination());
        checkIfCombinationAreEquals(this.player.getProposedCombination(), this.artificialIntelligence.getSecretCombination());
        if(!this.isResolve()) {
            if ((this.player.getAnsweredCombination().getCombinationValues() != null) && (!this.player.getAnsweredCombination().getCombinationValues().isEmpty())) {
                this.artificialIntelligence.setProposedCombination(this.player.getAnsweredCombination());
            } else {
                this.artificialIntelligence.setProposedCombination(this.player.getAnsweredCombination());
            }
            checkIfCombinationAreEquals(this.artificialIntelligence.getProposedCombination(), this.player.getSecretCombination());
        }
        else {
            this.winner = "Player";
        }
    }
    
    public void setAnsweredCombination(){
        if(!isResolve()) {
            this.player.setAnsweredCombination(this.artificialIntelligence.getProposedCombination());
            this.artificialIntelligence.setAnsweredCombination(this.player.getProposedCombination());
        }
    }
}
