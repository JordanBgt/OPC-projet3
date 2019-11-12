import java.util.Scanner;

/**
 * <b>Game class</b>
 *
 * It contains the logic of the application
 */
public class Game {

    /**
     * Game mode which will be choose by the player
     *
     * @see GameMode
     * @see ChallengerMode
     * @see DefenderMode
     * @see DuelMode
     */
    private GameMode gameMode;

    /**
     * List of game modes with a short description
     */
    private String[] gameModeList = {"Challenger : you will guess AI's secret combination", "Defender : you will defend your secret combination", "Duel : both", "Exit application"};

    /**
     * Scanner to ask the player to choose a game mode
     */
    private final Scanner SCANNER = new Scanner(System.in);

    /**
     * Boolean that represents if the game is in progress
     */
    private static boolean isRunning;

    /**
     * It displays the choose menu
     */
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
            exitGame();
        }
    }

    /**
     * Method to exit the game and close the application.
     */
    public static void exitGame(){
        isRunning = false;
        System.out.println(Messages.GOODBYE.getMessage());
    }

    /**
     * start the application
     *
     * @see Game#isRunning
     * @see Game#chooseMenu()
     */
    public void start(){
        isRunning = true;
        do{
            this.chooseMenu();
            if(this.gameMode != null){
                this.gameMode.play();
                this.gameMode = null;
            }
        } while(isRunning);
    }
}
