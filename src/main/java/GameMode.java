import org.apache.log4j.Logger;

public abstract class GameMode {

    private int tryoutNumber = ApplicationProperties.INSTANCE.getPropertyTryoutNumber();
    private Actor challenger;
    private Actor defender;
    private boolean resolve = false;
    private String gameModeMessage;
    private boolean isDevMode = Boolean.parseBoolean(ApplicationProperties.INSTANCE.getPropertyDevMode());
    private static Logger logger = Logger.getLogger(GameMode.class);

    public GameMode(){}

    public GameMode(Actor challenger, Actor defender){
        this.challenger = challenger;
        this.defender = defender;
    }

    public void play(){
        System.out.println(this.gameModeMessage);
        this.defender.setSecretCombination();
        if(isDevMode){
            logger.info("La combinaison secrète est : " + this.defender.getSecretCombination().getCombinationValues());
        }
        Combination secretCombination = this.defender.getSecretCombination();
        do {
            this.decrementTryOutNumber();
            this.challenger.setProposedCombination(this.defender.getAnsweredCombination());
            Combination proposedCombination = this.challenger.getProposedCombination();
            this.defender.setAnsweredCombination(proposedCombination);
            checkIfCombinationAreEquals(proposedCombination, secretCombination);
        } while ((this.tryoutNumber  != 0) && (!isResolve()));
        String message = "Game over : ";
        if(resolve){
            message += "Challenger wins !";
        }
        else{
            message += "Defender wins !";
        }
        System.out.println(message);
    }

    public void decrementTryOutNumber(){
        this.tryoutNumber--;
    }

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

    public void setGameModeMessage(String gameModeMessage) {
        this.gameModeMessage = gameModeMessage;
    }
}
