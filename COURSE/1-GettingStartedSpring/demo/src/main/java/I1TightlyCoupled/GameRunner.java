package I1TightlyCoupled;

public class GameRunner {
    private MarioGame marioGame;

    public GameRunner(MarioGame marioGame){
        this.marioGame = marioGame;
    }

    public void run(){
        System.out.println("RUNNING GAME: "+ marioGame);

        marioGame.up();
        marioGame.down();
        marioGame.left();
        marioGame.right();

    }
}
