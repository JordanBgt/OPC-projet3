import org.apache.log4j.Logger;

public class DuelMode extends GameMode {

    private Player player;
    private ArtificialIntelligence artificialIntelligence;
    private Logger logger = Logger.getLogger(DuelMode.class);

    public DuelMode(){}

    public DuelMode(Player player, ArtificialIntelligence artificialIntelligence) {
        this.player = player;
        this.artificialIntelligence = artificialIntelligence;
    }

    @Override
    public void play() {
        this.player.setSecretCombination();
        logger.info("player secret combination : " + this.player.getSecretCombination().getCombinationValues());
        this.artificialIntelligence.setSecretCombination();
        logger.info("ai secret combination : " + this.artificialIntelligence.getSecretCombination().getCombinationValues());

        do{
            this.setProposedCombinations();
            this.setAnsweredCombination();
        } while((!this.isResolve(this.player.getProposedCombination(), this.artificialIntelligence.getSecretCombination())) && (!this.isResolve(this.artificialIntelligence.getProposedCombination(), this.player.getSecretCombination())));

    }

    public void setProposedCombinations(){
        this.player.setProposedCombination(this.artificialIntelligence.getAnsweredCombination());
        logger.info("player proposed combination : " + this.player.getProposedCombination().getCombinationValues());
        if((this.player.getAnsweredCombination().getCombinationValues() != null) && (!this.player.getAnsweredCombination().getCombinationValues().isEmpty())){
            this.artificialIntelligence.setProposedCombination(this.player.getAnsweredCombination());
        } else {
            this.artificialIntelligence.setProposedCombination(this.player.getAnsweredCombination());
        }
        logger.info("ai proposed combination : " + this.artificialIntelligence.getProposedCombination().getCombinationValues());
    }
    
    public void setAnsweredCombination(){
        this.player.setAnsweredCombination(this.artificialIntelligence.getProposedCombination());
        logger.info("player answered combination : " + this.player.getAnsweredCombination().getCombinationValues());
        this.artificialIntelligence.setAnsweredCombination(this.player.getProposedCombination());
        logger.info("ai answered combination : " + this.artificialIntelligence.getAnsweredCombination().getCombinationValues());
    }
}
