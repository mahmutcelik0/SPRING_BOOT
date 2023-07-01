package I2LooslyCoupled;

public class GameRunner {

    //NOW THE GAMERUNNER CLASS IS LOOSE COUPLED TO GAMES
    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();
    }


}
