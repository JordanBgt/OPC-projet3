import java.util.Scanner;

public class Game {

    private GameMode gameMode;
    private String[] gameModeList = {"Challenger : you will guess AI's secret combination", "Defender : you will defend your secret combination", "Duel : both", "Exit application"};
    private final Scanner SCANNER = new Scanner(System.in);
    private static boolean isRunning;

    public void chooseMenu(){
        System.out.println(Messages.WELCOME.getMessage());
        System.out.println("PLEASE, SELECT A MODE :");
        for (int i = 0; i < this.gameModeList.length; i++){
            System.out.println("    " + (i+1) + "-> "+this.gameModeList[i]);
        }
        int userEntry = 0;
        do {
            userEntry = SCANNER.nextInt();
        }while ((userEntry <= 0) || (userEntry > 4));

        if(userEntry == 1){
            this.gameMode = new ChallengerMode();
        }
        else if(userEntry == 2){
            this.gameMode = new DefenderMode();
        }
        else if(userEntry == 3){
            this.gameMode = new DuelMode();
        }
        else{
            this.exitGame();
        }
    }

    public void playGameMode(){
        this.gameMode.play();
    }

    public static void exitGame(){
        isRunning = false;
        System.out.println(Messages.GOODBYE.getMessage());
    }

    public void start(){
        isRunning = true;
        do{
            this.chooseMenu();
            if(this.gameMode != null){
                this.playGameMode();
                this.gameMode = null;
            }
        } while(isRunning);
    }
}
