public abstract class GameMode {

    private int tryoutNumber = ApplicationProperties.INSTANCE.getPropertyTryoutNumber();
    private Actor challenger;
    private Actor defender;
    private boolean isResolve = false;
    private String gameModeMessage;

    public GameMode(){}

    public GameMode(Actor challenger, Actor defender){
        this.challenger = challenger;
        this.defender = defender;
    }

    public void play() throws Exception {
        System.out.println(this.gameModeMessage);
        this.defender.setSecretCombination();
        Combination secretCombination = this.defender.getSecretCombination();
        Combination proposedCombination = null;
        do {
            this.challenger.setProposedCombination(this.defender.getAnsweredCombination());
            proposedCombination = this.challenger.getProposedCombination();
            this.defender.setAnsweredCombination(proposedCombination);
            this.decrementTryOutNumber();
        } while ((this.tryoutNumber > 0) && (!secretCombination.getCombinationValues().equals(proposedCombination.getCombinationValues())));
    }

    public void decrementTryOutNumber(){
        this.tryoutNumber--;
    }

    public boolean isResolve(Combination proposedCombination, Combination secretCombination) {
        return proposedCombination.getCombinationValues().equals(secretCombination.getCombinationValues());
    }

    public void setResolve(boolean resolve) {
        isResolve = resolve;
    }

    public String getGameModeMessage() {
        return gameModeMessage;
    }

    public void setGameModeMessage(String gameModeMessage) {
        this.gameModeMessage = gameModeMessage;
    }
}
