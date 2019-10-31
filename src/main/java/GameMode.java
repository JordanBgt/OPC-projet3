import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class GameMode {

    protected int tryoutNumber = ApplicationProperties.INSTANCE.getPropertyTryoutNumber();
    protected Actor challenger;
    protected Actor defender;
    protected boolean resolve = false;
    protected String gameModeMessage;
    protected boolean devMode = Boolean.parseBoolean(ApplicationProperties.INSTANCE.getPropertyDevMode());
    private static final Logger LOGGER = Logger.getLogger(GameMode.class);
    private final Scanner SCANNER = new Scanner(System.in);

    public GameMode(){
    }

    public abstract void initGameMode();

    public void play(){
        this.initGameMode();
        this.defender.setSecretCombination();
        if(devMode){
            LOGGER.info("La combinaison secrète est : " + this.defender.getSecretCombination().getCombinationValues());
        }
        Combination secretCombination = this.defender.getSecretCombination();
        do {
            this.decrementTryOutNumber();
            this.challenger.setProposedCombination(this.defender.getAnsweredCombination());
            Combination proposedCombination = this.challenger.getProposedCombination();
            this.defender.setAnsweredCombination(proposedCombination);
            checkIfCombinationAreEquals(proposedCombination, secretCombination);
        } while ((this.tryoutNumber  != 0) && (!isResolve()));
        System.out.println(Messages.GAMEOVER.getMessage());
        if(resolve){
            System.out.println("Challenger wins !");
        }
        else{
            System.out.println("Defender wins ! The secret combination was : " + this.defender.getSecretCombination().getCombinationValues());
        }
        this.displayEndGameChoices();
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

    public boolean isDevMode() {
        return devMode;
    }

    public void displayEndGameChoices(){
        System.out.println("Please select an option : ");
        System.out.println("    1-> Try again");
        System.out.println("    2-> Game modes menu");
        System.out.println("    3-> Exit");
        int entry = SCANNER.nextInt();
        if(entry == 1){
            this.play();
        }
        if(entry == 3){
            Game.exitGame();
        }
    }
}
